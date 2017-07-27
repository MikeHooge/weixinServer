package com.biaoche.server.service.page.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biaoche.server.dao.dao.OperUsersMapper;
import com.biaoche.server.pojo.entity.OperUsers;
import com.biaoche.server.service.page.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private OperUsersMapper userMapper;

	@Override
	public List<OperUsers> getUserList() {
		return userMapper.selectByExample(null);
	}

}
