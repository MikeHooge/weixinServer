package com.biaoche.server;

import org.junit.Test;

public class xmlTest {
	
	@Test
	public void toXml(){
		User user = new User();
		user.setAge(23);
		user.setDec("IT民工");
		user.setName("胡奇");
		String convertToXml = JavaBeanToXmlUtil.convertToXml(user, "UTF-8");
		System.out.println(convertToXml);
	}
	@Test
	public void parseXml(){
		
	}

}
