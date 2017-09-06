package com.biaoche.server.config;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.biaoche.server.dao.interceptor.PageSqlHandleInterceptor;

@Configuration
public class MybatisConfig {
	
	@Autowired
	private DataSource dataSource;
	
	@Value("${mybatis.mapper-locations}")
	private String mapperLocations;
	
	@Value("${mybatis.type-aliases-package}")
	private String typeAliasesPackage;

	@Bean
	public SqlSessionFactory sqlSessionFactory(Interceptor interceptor){
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setPlugins(new Interceptor[] { interceptor });
		try {
			ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			factoryBean.setMapperLocations(resolver.getResources(mapperLocations));
			factoryBean.setTypeAliasesPackage(typeAliasesPackage);
			return factoryBean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Bean
	public Interceptor getInterceptor(){
		return new PageSqlHandleInterceptor();
	}
}
