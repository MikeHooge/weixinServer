package com.biaoche.server.pojo.resp;

public class BaseMessage {
	public String ToUserName;//接收方账号(收到的OpenID)
	
	public String FromUserName;//开发者微信号
	
	public long CreateTime;//消息创建时间(long整形)
	
	public String MsgType;//消息类型(text/music/news)
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	
}
