package com.biaoche.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/")
	public String login(){
		return "login";
	}
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	@RequestMapping("/header")
	public String header(){
		return "header";
	}
	@RequestMapping("/flot")
	public String flot(){
		return "flot";
	}
}
