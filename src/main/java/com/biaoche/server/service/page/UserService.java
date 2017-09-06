package com.biaoche.server.service.page;

import com.biaoche.server.commons.WebResult;

public interface UserService {
	/**
	 * 获取所有记录(分页)
	 * @return
	 */
	WebResult getUserListByPage(int pageIndex,int pageSize);

}
