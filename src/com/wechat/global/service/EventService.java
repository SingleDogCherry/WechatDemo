package com.wechat.global.service;

import java.util.Date;
import java.util.Map;

import com.wechat.global.entity.MessageText;
import com.wechat.global.service.inter.EventServiceInterface;
import com.wechat.global.util.MessageUtil;
/***
 *事件处理类 
 * 
 */
public class EventService implements EventServiceInterface {

	private String xmlstring;

	public String getXmlstring() {
		return xmlstring;
	}

	public void setXmlstring(String xmlstring) {
		this.xmlstring = xmlstring;
	}

	@Override
	public String execRequestMap(Map<String, String> requestMap) {
		MessageText mst = new MessageText();

		mst.setToUserName(requestMap.get("FromUserName"));// 发送消息的人和接收消息的人是一个人，所以要相反赋值
		mst.setFromUserName(requestMap.get("ToUserName"));
		mst.setCreateTime(new Date().getTime());
		mst.setMsgType(requestMap.get("MsgType"));
		mst.setContent(TulingApiService.getTulingResult(requestMap.get("Content"),requestMap.get("FromUserName")));
		//mst.setContent(requestMap.get("Content"));
		mst.setMsgId(requestMap.get("MsgId"));
		xmlstring=(MessageUtil.beanToXml(mst));
		//System.out.println(getXmlstring());
		return xmlstring;
	}

}
