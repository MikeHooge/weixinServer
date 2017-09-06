package com.biaoche.server.commons;

/**
 * 分页Example
 * 
 * @author Administrator
 *
 */
public abstract class PageExample {
	
	protected Page<?> page;

	public Page<?> getPage() {
		return page;
	}

	public void setPage(Page<?> page) {
		this.page = page;
	}
}
