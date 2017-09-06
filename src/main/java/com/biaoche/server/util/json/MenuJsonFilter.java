package com.biaoche.server.util.json;

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.ValueFilter;

public class MenuJsonFilter implements PropertyFilter,ValueFilter {

	public boolean apply(Object obj, String name, Object value) {
		if("id".equals(name)){
			return false;
		}
		if("fatherId".equals(name)){
			return false;
		}
		return true;
	}

	@Override
	public Object process(Object obj, String name, Object value) {
		if("spread".equals(name)){
			value=(int)value==1?true:false;
		}
		return value;
	}

}
