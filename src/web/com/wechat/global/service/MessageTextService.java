package com.wechat.global.service;

import java.util.Date;
import java.util.Map;

import com.wechat.global.entity.MessageText;
import com.wechat.global.service.inter.ServiceInterface;
import com.wechat.global.util.MessageUtil;


/**
 * 文本消息处理类
 * */
public class MessageTextService implements
ServiceInterface {

	@Override
	public String execRequest(Map<String, String> requestMap) {
		MessageText mst = new MessageText();

		mst.setToUserName(requestMap.get("FromUserName"));// 发送消息的人和接收消息的人是一个人，所以要相反赋值
		mst.setFromUserName(requestMap.get("ToUserName"));
		mst.setCreateTime(new Date().getTime());
		mst.setMsgType(requestMap.get("MsgType"));
		mst.setContent(TulingApiService.getTulingResult(
				requestMap.get("Content"), requestMap.get("FromUserName")));
		mst.setMsgId(requestMap.get("MsgId"));
		return MessageUtil.beanToXml(mst);

	}

}
