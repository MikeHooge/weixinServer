package com.biaoche.server.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * CDATA适配器
 * @author Administrator
 *
 */
public class CDataAdapter extends XmlAdapter<String, String> {

	//从javabean到xml的适配方法
	@Override
	public String marshal(String v) throws Exception {
		// TODO Auto-generated method stub
		return "<![CDATA[" + v + "]]>";
	}

	//从xml到javabean的适配方法
	@Override
	public String unmarshal(String v) throws Exception {
		return v;
	}

}
