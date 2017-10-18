package com.wechat.global.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.wechat.global.entity.MessageNewsResp;
import com.wechat.global.entity.News;
import com.wechat.global.service.inter.MessageServiceInterface;
import com.wechat.global.util.MessageUtil;

public class MessageImageService implements MessageServiceInterface {

	@Override
	public String execRequest(Map<String, String> requestMap) {
		
		MessageNewsResp msnp = new MessageNewsResp();
	//	MessageImage msi = new MessageImage();
		msnp.setToUserName(requestMap.get("FromUserName"));// 发送消息的人和接收消息的人是一个人，所以要相反赋值
		msnp.setFromUserName(requestMap.get("ToUserName"));
		msnp.setCreateTime(new Date().getTime());
		msnp.setMsgType(requestMap.get("MsgType"));
		msnp.setMsgId(requestMap.get("MsgId"));
		
		News news = new News();
		news.setArticle("测试图片消息回复");
		news.setDescription("图片描述");
		news.setDetailUrl("http://res.cuiyongzhi.com/2016/03/201603086749_6850.png");
		news.setSource("cherryxing");
		List< News>  articleList = new ArrayList<News>();
		
		articleList.add(news);
		msnp.setArticleCount(articleList.size());
		msnp.setArticles(articleList);
		//TODO:图片消息不能回复图片，还有问题待修改
		return MessageUtil.beanToXml(msnp);

		
		
		
	}

}
