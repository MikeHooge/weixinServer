package com.biaoche.server.util.json;

import java.text.SimpleDateFormat;

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.ValueFilter;

public class OperUsersJsonFilter implements PropertyFilter,ValueFilter {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public boolean apply(Object obj, String name, Object value) {
		if("systemUserId".equals(name)){
			return false;
		}
		if("password".equals(name)){
			return false;
		}
		if("loginName".equals(name)){
			return false;
		}
		return true;
	}

	@Override
	public Object process(Object obj, String name, Object value) {
		if("state".equals(name)){
			value=(int)value==1?"在职":"离职";
		}
		if("createTime".equals(name)){
			value=dateFormat.format(value);
		}
		return value;
	}

}
