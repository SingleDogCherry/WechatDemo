package com.wechat.global.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;

import com.wechat.global.enums.MsgTypeEnum;
import com.wechat.global.service.inter.EventServiceInterface;
import com.wechat.global.util.MessageUtil;

public class EventServiceDispatcher {
	private static Map<String, String> returnMap = new HashMap<String, String>();
	protected static String xmlstring;

	public static String processRequest(HttpServletRequest request)
			throws IOException {

		try {
			returnMap = (MessageUtil.xmlToMap(request));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		// 发送消息的人和接收消息的人是一个人，所以要相反赋值
		String msgType = returnMap.get("MsgType");
		if (MsgTypeEnum.MsgType_Event.equals(msgType)) {
			EventServiceInterface esInter = new EventService();
			xmlstring = esInter.execRequest(returnMap);
		} else {
			System.out.println("错误的请求信息");

		}

		return xmlstring;

	}

}
