package com.wechat.global.entity;

import com.wechat.global.entity.base.ClassBase;
/**
 * 视频实体
 * 
 * */
public class Video extends ClassBase {
	/** 标题 */
	private String title;
	/** 视频消息媒体id */
	private String MediaId;
	/** 视频消息缩略图的媒体id */
	private String thumbMediaId;
	/** 视频描述 */
	private String description;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
