package com.biaoche.server.pojo.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class VideoMessage extends BaseMessage{
	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		this.Video = video;
	}
	

}
