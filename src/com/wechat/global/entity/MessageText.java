package com.wechat.global.entity;

import com.wechat.global.entity.base.MessageBase;
import com.wechat.global.enums.MsgTypeEnum;

public class MessageText  extends MessageBase{
	
	/** 文本消息内容 */
	private String content;
	/**文本类型*/
	private static final String msgType=MsgTypeEnum.MsgType_Text;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public static String getMsgtype() {
		return msgType;
	}
	

}
