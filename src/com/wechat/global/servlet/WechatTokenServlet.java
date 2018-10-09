package com.wechat.global.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.DocumentException;

import com.wechat.global.enums.MsgTypeEnum;
import com.wechat.global.service.Dispatcher.EventServiceDispatcher;
import com.wechat.global.service.Dispatcher.MessageServiceDispatcher;
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
	static Logger logger = LogManager.getLogger(WechatTokenServlet.class.getName());
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
		logger.info("随机字符串" + echostr);
		logger.info("微信加密签名" + signature);
		logger.info("时间戳" + timestamp);
		logger.info("随机数" + nonce);
		if (TokenUtil.validateSignature(signature, timestamp, nonce)) {
			logger.info("成功的验证");
			out.print(echostr);
		} else {
			logger.info("验证失败");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String msgType = null ,xmlString=null;
		Map<String, String> returnMap=new HashMap<String, String>();
		try {
			returnMap=MessageUtil.xmlToMap(request);
			msgType = returnMap.get("MsgType");
			if (MsgTypeEnum.MsgType_Event.equals(msgType)) {
				xmlString = EventServiceDispatcher.processRequestMap(returnMap);//进入事件处理
			} else {
				xmlString = MessageServiceDispatcher.processRequestMap(returnMap);//进入消息处理
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null==xmlString) {
			xmlString="";
		}
		PrintWriter out = response.getWriter();
		out.print(xmlString);
		out.close();
		logger.info(xmlString);
		logger.info("方法的结束地方");
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
