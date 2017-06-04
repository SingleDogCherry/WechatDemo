package com.wechat.global.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.wechat.global.entity.MessageImage;
import com.wechat.global.entity.MessageText;
import com.wechat.global.enums.MsgTypeEnum;
import com.wechat.global.util.MessageUtil;
/**
 * 消息业务处理类
 * */
public class MessageService {
	private static Map<String, String> returnMap;
	/**
	 * @throws IOException 
	 * */
	public static String processRequest(HttpServletRequest request ) throws IOException{
		

		
		String xmlstring = "";
		returnMap=new HashMap<String, String>();
		try {
			returnMap=(MessageUtil.xmlToMap(request));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String toUserName = returnMap.get("FromUserName");
		String fromUserName = returnMap.get("ToUserName");// 发送消息的人和接收消息的人是一个人，所以要相反赋值
		String msgType = returnMap.get("MsgType");
		String content = returnMap.get("Content");
		String msgId = returnMap.get("MsgId");

		if (MsgTypeEnum.MsgType_Text.equals(msgType)) {

			MessageText mst = new MessageText();

			mst.setToUserName(toUserName);
			mst.setFromUserName(fromUserName);
			mst.setCreateTime(new Date().getTime());
			mst.setMsgType(msgType);
			mst.setMsgType(msgType);
			mst.setContent(content);
			mst.setMsgId(msgId);
			// System.out.println("print mst  "+mst.toString());
			xmlstring = MessageUtil.beanToXml(mst);
			System.out.println(xmlstring);
			
		} else if (MsgTypeEnum.MsgType_Image.equals(msgType)) {
			MessageImage msi = new MessageImage();

		}
		return  xmlstring;
		
	
		
		
	}
	public Map<String, String> getReturnMap() {
		return returnMap;
	}
	public void setReturnMap(Map<String, String> returnMap) {
		this.returnMap = returnMap;
	}

}
