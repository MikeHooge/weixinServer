package com.biaoche.server.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReceiveMessage {
	/// *****************公用属性************************
	@XmlCDATA
	private String ToUserName;// 开发者微信号
	@XmlCDATA
	private String FromUserName;// 发送方帐号（一个OpenID）
	private Date CreateTime;// 消息创建时间 （整型）
	@XmlCDATA
	private String MsgType;// 消息类型是:text
	private long MsgId;// 消息id，64位整型
	@XmlCDATA
	private String MediaId;// 消息媒体id，可以调用多媒体文件下载接口拉取数据

	/// ****************文本消息属性*************************
	@XmlCDATA
	private String Content;// 文本消息内容

	/// ***************图片消息属性**************************
	@XmlCDATA
	private String PicUrl;// 图片链接

	/// *****************链接消息属性************************
	@XmlCDATA
	private String title;// 消息标题
	@XmlCDATA
	private String Description;// 消息描述
	@XmlCDATA
	private String Url;// 消息链接

	/// *******************位置消息属性**********************
	@XmlCDATA
	private String Location_X;// 地理位置维度
	@XmlCDATA
	private String Location_Y;// 地理位置经度
	@XmlCDATA
	private String Scale;// 地图缩放大小
	@XmlCDATA
	private String Lable;// 地理位置信息

	/// ********************视频(小视频)消息属性****************
	@XmlCDATA
	private String ThumbMediaId;// 视频消息缩略图的媒体ID;

	/// ****************语音消息属性**************************
	@XmlCDATA
	private String Format;// 语音格式，如amr，speex等

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

	public Date getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	public String getLable() {
		return Lable;
	}

	public void setLable(String lable) {
		Lable = lable;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

}
