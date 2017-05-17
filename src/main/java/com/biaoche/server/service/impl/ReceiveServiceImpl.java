package com.biaoche.server.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.biaoche.server.pojo.ReceiveMessage;
import com.biaoche.server.pojo.resp.TextMessage;
import com.biaoche.server.service.ReceiveService;
import com.biaoche.server.util.MsgUtil;

/**
 * 消息处理
 * 
 * @author Administrator
 *
 */

@Service
public class ReceiveServiceImpl implements ReceiveService {

	@Override
	public String dealReceiveMsg(ReceiveMessage message) {
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(message.getFromUserName());
		textMessage.setFromUserName(message.getToUserName());
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType("text");
		if (message.getMsgType().trim().equals("text")) {
			textMessage.setContent("你发了一个文本消息.");
		}else if (message.getMsgType().trim().equals("image")) {
			textMessage.setContent("你发了一个图片消息.");
		}else if (message.getMsgType().trim().equals("voice")) {
			textMessage.setContent("你发了一个语音消息.");
		}else if (message.getMsgType().trim().equals("video")) {
			textMessage.setContent("你发了一个视频消息.");
		}else{
			textMessage.setContent("你发的消息无法识别,联系管理员也不理你.");
		}
		return MsgUtil.convertToXml(textMessage, "UTF-8");
	}

}
