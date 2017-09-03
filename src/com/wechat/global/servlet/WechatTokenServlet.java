package com.wechat.global.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.wechat.global.enums.MsgTypeEnum;
import com.wechat.global.service.EventServiceDispatcher;
import com.wechat.global.service.MessageServiceDispatcher;
import com.wechat.global.util.MessageUtil;
import com.wechat.global.util.TokenUtil;

/**
 * Servlet implementation class WechatTokenServlet
 * 
 * @author zjrcu_rzx
 * @Email 974068104@qq.com
 * @see 核心请求处理 微信token处理类
 * 
 * 
 */
@WebServlet("/WechatTokenServlet")
public class WechatTokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
		echostr = request.getParameter("echostr");
		signature = request.getParameter("signature");
		timestamp = request.getParameter("timestamp");
		nonce = request.getParameter("nonce");
		PrintWriter out = response.getWriter();
		System.out.println("随机字符串" + echostr);
		System.out.println("微信加密签名" + signature);
		System.out.println("时间戳" + timestamp);
		System.out.println("随机数" + nonce);
		if (TokenUtil.validateSignature(signature, timestamp, nonce)) {
			System.out.println("成功的验证");
			out.print(echostr);
		} else {
			System.out.println("验证失败");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String msgType = null ,xmlString;
		try {
			msgType = MessageUtil.xmlToMap(request).get("MsgType");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (MsgTypeEnum.MsgType_Event.equals(msgType)) {
			xmlString = EventServiceDispatcher.processRequest(request);//进入事件处理
		} else {
			xmlString = MessageServiceDispatcher.processRequest(request);//进入消息处理
		}
		PrintWriter out = response.getWriter();
		out.print(xmlString);
		out.close();

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
