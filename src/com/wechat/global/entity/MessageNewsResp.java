package com.wechat.global.entity;

import java.util.List;

import com.wechat.global.entity.base.MessageBase;
/**
 * 多图文消息回复实体
 * */
public class MessageNewsResp extends MessageBase {
	/**标题列表*/
	private List<News> aritcles;
	/**消息个数，限定10个以内*/
	private int articleCount;
	public List<News> getAritcles() {
		return aritcles;
	}
	public void setAritcles(List<News> aritcles) {
		this.aritcles = aritcles;
	}
	public int getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}
	

}
