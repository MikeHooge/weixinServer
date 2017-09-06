package com.biaoche.server.commons;

import java.util.List;

/**
 * Web端返回结果类
 * @author Administrator
 *
 */
public class WebResult {
	private boolean rel;	//结果代码
	private String msg;		//结果信息
	private List<?> list;	//附带的数据
	private int count;		//可选数据
	public boolean isRel() {
		return rel;
	}
	public void setRel(boolean rel) {
		this.rel = rel;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	private WebResult(List<?> list, int count) {
		super();
		this.list = list;
		this.count = count;
	}
	private WebResult(boolean rel, String msg) {
		super();
		this.rel = rel;
		this.msg = msg;
	}
	
	public static WebResult getSuccessResult(List<?> dataList,int totalCount){
		WebResult result = new WebResult(dataList, totalCount);
		result.setRel(true);
		result.setMsg("成功");
		return result;
	}
	public static WebResult getSuccessResult(){
		return new WebResult(true, "成功");
	}
	
	public static WebResult getResult(boolean rel, String msg){
		return new WebResult(rel,msg);
	}
}
