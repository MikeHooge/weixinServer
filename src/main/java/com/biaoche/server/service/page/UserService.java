package com.biaoche.server.service.page;

import java.util.List;

import com.biaoche.server.pojo.entity.OperUsers;

public interface UserService {
	/**
	 * 获取所有记录
	 * @return
	 */
	List<OperUsers> getUserList();

}
