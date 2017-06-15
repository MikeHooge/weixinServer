package com.biaoche.server.pojo.resp;

public class Video {

	private String MediaId;// 媒体文件ID
	
	private String Title;//视频消息的标题

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
