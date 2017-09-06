package com.biaoche.server.util.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

public class HttpClientUtil {
	private static Logger log = Logger.getLogger(HttpClientUtil.class);
	
	public static String httpGet(String url,Map<String, Object> params,String charset){
		if(StringUtils.isEmpty(charset)){
			charset = "UTF-8";//默认编码是UTF-8
		}
		String result = "";
		if (params != null) {
			StringBuffer sb = new StringBuffer("?");
			for (Entry<String, Object> e : params.entrySet()) {
				sb.append(e.getKey());
				sb.append("=");
				sb.append(e.getValue());
				sb.append("&");
			}
			url =url + sb.substring(0, sb.length() - 1);
		}
		HttpResponse response = null;
		log.info("get请求的url:"+url);
		try {
			HttpGet httpGet = new HttpGet(url);
			response =  HttpClientPool.getHttpClient().execute(httpGet);
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				EntityUtils.consume(response.getEntity());
			}else{
				result = EntityUtils.toString(response.getEntity(),charset);
				log.info("return Data:" + result);
			}
		} catch (Exception e) {
			if(response!=null){
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		return result;
	}
	
	public static String httpPost(String url,Map<String, Object> params,String charset){
		if(StringUtils.isEmpty(charset)){
			charset = "UTF-8";//默认编码是UTF-8
		}
		String result = "";
		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		if (params != null) {
			Iterator<Entry<String, Object>> iterator = params.entrySet().iterator();  
            while(iterator.hasNext()){  
                Entry<String,Object> elem = (Entry<String, Object>) iterator.next();  
                paramList.add(new BasicNameValuePair(elem.getKey(),String.valueOf(elem.getValue())));  
            }  
		}
		HttpResponse response = null;
		HttpPost httpPost = new HttpPost(url);
		log.info("post请求的url:"+url);
		try {
			if(paramList.size() > 0){  
	            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,charset);  
	            httpPost.setEntity(entity);  
	        }
			response =  HttpClientPool.getHttpClient().execute(httpPost);
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				log.info("访问出错,状态码 : "+response.getStatusLine().getStatusCode());
				EntityUtils.consume(response.getEntity());
			}else{
				result = EntityUtils.toString(response.getEntity(),charset);
				log.info("return Data:" + result);
			}
		} catch (Exception e) {
			if(response!=null){
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 
	 * @param url
	 * @param params
	 * @param charset
	 * @return
	 */
	public static String httpPost(String url,String params,String charset){
		if(StringUtils.isEmpty(charset)){
			charset = "UTF-8";//默认编码是UTF-8
		}
		String result = "";
		HttpResponse response = null;
		JSON.parseObject(params);
		HttpPost httpPost = new HttpPost(url);
		if(isJson(params)){
			log.info("参数为json格式,设置json请求头");
			httpPost.setHeader("contentType", "application/json; charset=utf-8");
		}else if (isXml(params)) {
			log.info("参数为xml格式,设置xml请求头");
			httpPost.setHeader("contentType", "application/xml; charset=utf-8");
		}
		httpPost.setEntity(new StringEntity(params, charset));
		log.info("post请求的url:"+url);
		try {
			response =  HttpClientPool.getHttpClient().execute(httpPost);
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				log.info("访问出错,状态码 : "+response.getStatusLine().getStatusCode());
				EntityUtils.consume(response.getEntity());
			}else{
				result = EntityUtils.toString(response.getEntity(),charset);
				log.info("return Data:" + result);
			}
		} catch (Exception e) {
			if(response!=null){
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		return result;
	}
	
	private static boolean isJson(String value){
		try {
			JSON.parse(value);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	private static boolean isXml(String value){
		try {
			JSON.parse(value);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	
	@Test
	public void test(){
		String access_token="V3x6g64cRvKyUGg9_FjJYWnM_gSDN3DjZiNt6to9COO4FRILRKBI7LFz71kBiG1uWhbn3YKmyLuPdcyP2JpH9OSabj7lqXG7uQTLyGid9jroYzByHmktArrahLfYMRcYQINjABALDI";
		Map<String, Object> params = new HashMap<>();
//		params.put("grant_type", "client_credential");
//		params.put("appid", "wx0acdc62d5e945ca8");
//		params.put("secret", "e9c4b9458cd42ac1510e43b136f11a66");
		params.put("access_token", access_token);
//		String url = "https://api.weixin.qq.com/cgi-bin/token";
		String url = "https://api.weixin.qq.com/cgi-bin/getcallbackip";
		String sendGet = HttpClientUtil.httpGet(url, params, "UTF-8");
		System.out.println(sendGet);
	}
	
}
