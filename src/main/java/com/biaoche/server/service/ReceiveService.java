package com.biaoche.server.service;

import com.biaoche.server.pojo.ReceiveMessage;

public interface ReceiveService {
	/**
	 * 处理接收到的消息
	 * @param message
	 * @return
	 */
	public String dealReceiveMsg(ReceiveMessage message);
}
