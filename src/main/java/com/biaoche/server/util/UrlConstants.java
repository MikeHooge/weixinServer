package com.biaoche.server.util;

/**
 * url常量类
 * @author Administrator
 *
 */
public class UrlConstants {
	
	/**微信:获取access_token,请求方式GET**/
	public static final String WECHART_GET_TOKEN = "https://api.weixin.qq.com/cgi-bin/token";
	/**微信:创建菜单，请求方式POST**/
	public static final String WECHART_CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create";
	/**微信:查询菜单,请求方式GET**/
	public static final String WECHART_QUERY_MENU = "https://api.weixin.qq.com/cgi-bin/menu/get";
	/**微信:删除菜单，请求方式GET**/
	public static final String WECHART_DELETE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/delete";
}
