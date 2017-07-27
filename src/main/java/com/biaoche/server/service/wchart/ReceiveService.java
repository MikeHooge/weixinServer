package com.biaoche.server.service.wchart;

import com.biaoche.server.pojo.req.ReceiveMessage;

public interface ReceiveService {
	/**
	 * 处理接收到的消息
	 * @param message
	 * @return
	 */
	public String dealReceiveMsg(ReceiveMessage message);
}
