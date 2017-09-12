package com.wechat.global.entity;

import com.wechat.global.entity.base.ClassBase;
/**
 *音乐实体 
 * */
public class Music extends ClassBase{
	/**标题*/
	private String title;
	/**描述*/
	private String description;
	/**链接*/
	private String musicUrl;
	/**高质量链接*/
	private String highMusicUrl;
	/**缩略图*/
	private String thumbMediaId;
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
	public String getMusicUrl() {
		return musicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	public String getHighMusicUrl() {
		return highMusicUrl;
	}
	public void setHighMusicUrl(String highMusicUrl) {
		this.highMusicUrl = highMusicUrl;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	

}
