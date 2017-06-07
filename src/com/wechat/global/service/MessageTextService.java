package com.wechat.global.service;

import java.util.Date;
import java.util.Map;


import com.wechat.global.entity.MessageText;
import com.wechat.global.service.inter.MessageServiceInterface;
import com.wechat.global.util.MessageUtil;

public class MessageTextService extends MessageService implements MessageServiceInterface  {

	@Override
	public String execRequest(Map<String, String> returnMap) {
		MessageText mst = new MessageText();

		mst.setToUserName(returnMap.get("FromUserName"));// 发送消息的人和接收消息的人是一个人，所以要相反赋值
		mst.setFromUserName(returnMap.get("ToUserName"));
		mst.setCreateTime(new Date().getTime());
		mst.setMsgType(returnMap.get("MsgType"));
		mst.setContent(TulingApiService.getTulingResult(returnMap.get("Content"),returnMap.get("FromUserName")));
		//mst.setContent(returnMap.get("Content"));
		mst.setMsgId(returnMap.get("MsgId"));
		xmlstring=(MessageUtil.beanToXml(mst));
		//System.out.println(getXmlstring());
		return xmlstring;
	}

}
