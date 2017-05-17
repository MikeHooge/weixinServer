package com.biaoche.server.pojo.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.biaoche.server.util.CDataAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Article {
	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String Title;// 图文消息名称
	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String Description;// 图文消息描述
	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String PicUrl;// 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
	@XmlJavaTypeAdapter(CDataAdapter.class)
	private String Url;// 点击图文消息跳转链接

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

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

}
