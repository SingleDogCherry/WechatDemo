package com.wechat.global.entity;

import com.wechat.global.entity.base.ClassBase;

/**
 * 新闻实体类
 * */
public class News extends ClassBase {
	/** 标题 */
	private String article;
	/** 消息url */
	private String detailUrl;
	/** 描述 */
	private String description;
	/** 新闻来源 */
	private String source;
	/** 图片url */
	private String icon;

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
