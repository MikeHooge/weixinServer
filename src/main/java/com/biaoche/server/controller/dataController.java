package com.biaoche.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.biaoche.server.pojo.entity.OperUsers;
import com.biaoche.server.service.page.UserService;

@RestController
public class dataController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/users",produces = "text/plain;charset=UTF-8")
	public String getUserList(){
		List<OperUsers> userList = userService.getUserList();
		return JSON.toJSONString(userList);
	}

}
