package com.biaoche.server.pojo.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.biaoche.server.util.CDataAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class BaseMessage {
	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String ToUserName;//接收方账号(收到的OpenID)
	
	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String FromUserName;//开发者微信号
	
	private long CreateTime;//消息创建时间(long整形)
	
	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String MsgType;//消息类型(text/music/news)
	
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
