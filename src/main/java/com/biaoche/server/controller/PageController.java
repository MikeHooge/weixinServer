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
	@RequestMapping("/index-top")
	public String indexTops(){
		return "index-frame";
	}
	@RequestMapping("/index-menu")
	public String indexMenu(){
		return "index-menu";
	}
	@RequestMapping("/editor")
	public String editor(){
		return "editor";
	}
}
