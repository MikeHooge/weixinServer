package com.biaoche.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.biaoche.server.commons.WebResult;
import com.biaoche.server.pojo.entity.Menu;
import com.biaoche.server.service.page.MenuService;
import com.biaoche.server.service.page.UserService;
import com.biaoche.server.util.json.MenuJsonFilter;
import com.biaoche.server.util.json.OperUsersJsonFilter;

@RestController
public class dataController {
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuservice;
	
	@RequestMapping(value = "/users")
	public String getUserList(int pageIndex,int pageSize){
		WebResult userList = userService.getUserListByPage(pageIndex,pageSize);
		return JSON.toJSONString(userList,new OperUsersJsonFilter());
	}
	@RequestMapping(value="/menuList",produces="text/plain;charset=UTF-8")
	public String getMenuList(){
		List<Menu> menuList = menuservice.getMenuList();
		return JSON.toJSONString(menuList,new MenuJsonFilter());
	}

}
