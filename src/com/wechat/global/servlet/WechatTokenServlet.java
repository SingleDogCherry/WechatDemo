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
 * @author rjrcu_rzx
 * @Email 421347251@qq.com
 * @see 核心请求处理 微信token处理类
 * 
 * 
 */
@WebServlet("/WechatTokenServlet")
public class WechatTokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		PrintWriter out = response.getWriter();
		if (TokenUtil.validateSignature(signature, timestamp, nonce)) {
			out.println(echostr);
			// System.out.println("yes");
		}
		out.close();
		out = null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// request.setCharacterEncoding("UTF-8");
		// response.setCharacterEncoding("UTF-8");
		// TODO 消息的接受、处理、响应
		PrintWriter out = response.getWriter();
		String xmlstring = "";
		Map<String, String> returnMap = new HashMap<String, String>();

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
			 System.out.println("print mst  "+mst.toString());
			xmlstring = MessageUtil.beanToXml(mst);
			System.out.println(xmlstring);
		} else if (MsgTypeEnum.MsgType_Image.equals(msgType)) {
			MessageImage msi = new MessageImage();

		}

		out.println(xmlstring);
		out.close();
	}
}
