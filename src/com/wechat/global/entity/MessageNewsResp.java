package com.wechat.global.entity;

import java.util.List;

import com.wechat.global.entity.base.MessageBase;
/**
 * 多图文消息回复实体
 * */
public class MessageNewsResp extends MessageBase {
	/**标题列表*/
	private List<News> articles;
	/**消息个数，限定10个以内*/
	private int articleCount;
	public int getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}
	public List<News> getArticles() {
		return articles;
	}
	public void setArticles(List<News> articles) {
		this.articles = articles;
	}
	

}
