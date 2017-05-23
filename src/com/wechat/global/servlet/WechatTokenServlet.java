package com.wechat.global.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.wechat.global.entity.MessageImage;
import com.wechat.global.entity.MessageText;
import com.wechat.global.entity.base.MessageBase;
import com.wechat.global.enums.MsgTypeEnum;
import com.wechat.global.util.MessageUtil;
import com.wechat.global.util.TokenUtil;

/**
 * Servlet implementation class WechatTokenServlet
 * 
 * @author zjrcu_rzx
 * @Email 9740681041@qq.com
 * @see 核心请求处理 微信token处理类
 * 
 * 
 */
@WebServlet("/WechatTokenServlet")
public class WechatTokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, String> returnMap;
	/*** 微信加密签名 */
	private String signature;
	/** 时间戳 */
	private String timestamp;
	/** 随机数 */
	private String nonce;
	/** 随机字符串 */
	private String echostr;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WechatTokenServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response) 对微信签名进行校验
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			returnMap=MessageUtil.xmlToMap(request);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		echostr=request.getParameter("echostr");
		signature=request.getParameter("signature");
		timestamp=request.getParameter("timestamp");
		nonce=request.getParameter("nonce");
		
		PrintWriter out = response.getWriter();
		System.out.println("随机字符串" + echostr);
		System.out.println("微信加密签名" + signature);
		System.out.println("时间戳" + timestamp);
		System.out.println("随机数" + nonce);
		if (TokenUtil.validateSignature(signature, timestamp, nonce)) {
			out.println(echostr);
		}
		else {
			out.print("验证失败");
		}
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String xmlstring = "";
		returnMap = new HashMap<String, String>();
		try {
			returnMap = MessageUtil.xmlToMap(request);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String toUserName = returnMap.get("FromUserName");
		String fromUserName = returnMap.get("ToUserName");// 发送消息的人和接收消息的人是一个人，所以要相反赋值
		String msgType = returnMap.get("MsgType");
		String content = returnMap.get("Content");
		String msgId = returnMap.get("MsgId");

		// 2017-04-23 修改为基本对象存储
		MessageBase messageBase = new MessageBase();
		messageBase.setToUserName(toUserName);
		messageBase.setFromUserName(fromUserName);
		messageBase.setMsgType(msgType);
		// 待确定要不要在基本类中加 content字段
		messageBase.setMsgId(msgId);
		messageBase.setCreateTime(new Date().getTime());

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

		out.println(xmlstring);
		out.close();
	}

	public Map<String, String> getReturnMap() {
		return returnMap;
	}

	public void setReturnMap(Map<String, String> returnMap) {
		this.returnMap = returnMap;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getEchostr() {
		return echostr;
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
}
