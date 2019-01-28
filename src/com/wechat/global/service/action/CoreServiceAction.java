package com.wechat.global.service.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.dom4j.DocumentException;

import com.opensymphony.xwork2.ActionSupport;
import com.wechat.global.enums.MsgTypeEnum;
import com.wechat.global.service.Dispatcher.EventServiceDispatcher;
import com.wechat.global.service.Dispatcher.MessageServiceDispatcher;
import com.wechat.global.util.MessageUtil;
import com.wechat.global.util.TokenUtil;

public class CoreServiceAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	static Logger logger = LogManager.getLogger(CoreServiceAction.class.getName());
	/*** 微信加密签名 */
	private String signature;
	/** 时间戳 */
	private String timestamp;
	/** 随机数 */
	private String nonce;
	/** 随机字符串 */
	private String echostr;
	/** xml报文 */
	private String xml;
	private Map<String, String> returnMap;
	private String msgType;

	public String execute() throws HTTPException, IOException, DocumentException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		echostr = request.getParameter("echostr");
		signature = request.getParameter("signature");
		timestamp = request.getParameter("timestamp");
		nonce = request.getParameter("nonce");
		logger.info("CoreServiceAction随机字符串" + echostr);
		logger.info("CoreServiceAction微信加密签名" + signature);
		logger.info("CoreServiceAction时间戳" + timestamp);
		logger.info("CoreServiceAction随机数" + nonce);
		if (TokenUtil.validateSignature(signature, timestamp, nonce)) {
			logger.info("CoreServiceAction成功的验证");
			returnMap = MessageUtil.xmlToMap(request);
			msgType = returnMap.get("MsgType");
			if (MsgTypeEnum.MsgType_Event.equals(msgType)) {
				xml = EventServiceDispatcher.processRequestMap(returnMap);// 进入事件处理
			} else {
				xml = MessageServiceDispatcher.processRequestMap(returnMap);// 进入消息处理
			}
			out.print(xml);
			return null;
		} else {
			logger.info("CoreServiceAction验证失败");
			return ERROR;
		}

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

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public Map<String, String> getReturnMap() {
		return returnMap;
	}

	public void setReturnMap(Map<String, String> returnMap) {
		this.returnMap = returnMap;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
}
