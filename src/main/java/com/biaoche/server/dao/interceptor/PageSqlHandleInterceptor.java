package com.biaoche.server.dao.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.log4j.Logger;

import com.biaoche.server.commons.Page;
import com.biaoche.server.commons.PageExample;
import com.biaoche.server.util.ReflectUtil;

/**
 * mybatis拦截器
 * @author Administrator
 *
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PageSqlHandleInterceptor implements Interceptor {
	private static Logger log = Logger.getLogger(PageSqlHandleInterceptor.class);
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
		StatementHandler delegate = (StatementHandler) ReflectUtil.getFieldValue(handler, "delegate");
		BoundSql boundSql = delegate.getBoundSql();
		Object obj = boundSql.getParameterObject();
		if (obj instanceof PageExample) {
			PageExample pageExample = (PageExample) obj;
			Page<?> page = pageExample.getPage();
			if (page != null) {
				MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getFieldValue(delegate,"mappedStatement");
				Connection connection = (Connection) invocation.getArgs()[0];
				String sql = boundSql.getSql();
				log.debug("原有的sql:" + sql);
				this.setTotalRecord(pageExample, mappedStatement, connection);
				String pageSql = this.getPageSql(page, sql);
				log.debug("分页改造后的sql:" + pageSql);
				ReflectUtil.setFieldValue(boundSql, "sql", pageSql);
			}
		}
		return invocation.proceed();
	}
	
	/**
	 * 拦截器用于封装目标对象的
	 */
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 根据原Sql语句获取对应的查询总记录数的Sql语句
	 */
	private String getCountSql(String sql) {
		int index = sql.indexOf("from");
		return "select count(*) " + sql.substring(index);
	}
	
	private String getPageSql(Page<?> page, String sql) {
		StringBuffer sqlBuffer = new StringBuffer(sql);
		int offset = (page.getPageIndex() - 1) * page.getPageSize();
		sqlBuffer.append(" limit ").append(offset).append(",").append(page.getPageSize());
		return sqlBuffer.toString();
	}
	
	private void setTotalRecord(PageExample pageExample, MappedStatement mappedStatement, Connection connection) {
		BoundSql boundSql = mappedStatement.getBoundSql(pageExample);
		Page<?> page = pageExample.getPage();
		String sql = boundSql.getSql();
		String countSql = this.getCountSql(sql);
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, page);
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, page, countBoundSql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(countSql);
			parameterHandler.setParameters(pstmt);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int totalRecord = rs.getInt(1);
				page.setCount(totalRecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
