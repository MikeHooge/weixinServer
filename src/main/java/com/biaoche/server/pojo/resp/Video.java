package com.biaoche.server.pojo.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.biaoche.server.util.CDataAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Video {

	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String MediaId;// 媒体文件ID
	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String Title;//视频消息的标题
	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String Description;//视频消息的描述
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
}
