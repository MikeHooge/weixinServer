package com.biaoche.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biaoche.server.pojo.ReceiveMessage;
import com.biaoche.server.service.ReceiveService;
import com.biaoche.server.util.SignUtil;

@RestController
public class ReceiveController {
	
	@Autowired
	private ReceiveService receiveService;

	
	@RequestMapping(value="/connectServer",method=RequestMethod.GET)
	public String connectServer(String signature,String timestamp,String nonce,String echostr){
		if(SignUtil.checkSignature(signature, timestamp, nonce)){
			return echostr;
		}
		return "errer";
	}
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(){
		return "hello world";
	}
	
	@RequestMapping(value="/connectServer",method=RequestMethod.POST)
	public String receiveTextMsg(@RequestBody ReceiveMessage receiveMsg){
		String sendMsg = receiveService.dealReceiveMsg(receiveMsg);
		System.out.println(sendMsg);
		if(StringUtils.isEmpty(sendMsg)){
			return "接收消息成功";
		}
		return sendMsg;
	}
}
