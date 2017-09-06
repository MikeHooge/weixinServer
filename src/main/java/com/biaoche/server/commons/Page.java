package com.biaoche.server.commons;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	public Page(Integer pageIndex, Integer pageSize) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}

	// 当前页
	private Integer pageIndex;
	// 页面大小
	private Integer pageSize;
	// 总记录数
	private Integer count;
	// 数据
	private List<T> list = new ArrayList<>();

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
