package com.wechat.global.service.Dispatcher;

import java.io.IOException;
import java.util.Map;

import com.wechat.global.enums.MsgTypeEnum;
import com.wechat.global.service.MessageImageService;
import com.wechat.global.service.MessageTextService;
import com.wechat.global.service.inter.ServiceInterface;

/**
 * 消息业务处理分发类
 * */
public class MessageServiceDispatcher {

	/**
	 * @throws IOException
	 * */
	public static String processRequestMap(Map<String, String> requestMap)
			throws IOException {

		//获取消息类型，进行分发处理
		String msgType = requestMap.get("MsgType");
		ServiceInterface msInter = null;
		if (MsgTypeEnum.MsgType_Text.equals(msgType)) {
			msInter = new MessageTextService();
			return  msInter.execRequest(requestMap);
		} else if (MsgTypeEnum.MsgType_Image.equals(msgType)) {
			msInter=new  MessageImageService();
			return msInter.execRequest(requestMap);
			
		}
		return "不好意思，出错了";
	}



}
