package com.wechat.global.entity;

import com.wechat.global.entity.base.MessageBase;
import com.wechat.global.enums.MsgTypeEnum;
/**
 * 文本消息实体
 * 
 * */
public class MessageText  extends MessageBase{
	
	/** 文本消息内容 */
	private String content;
	/**文本类型*/
	//private static final String msgType=MsgTypeEnum.MsgType_Text;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public  void setMsgType(String msgType){
		super.setMsgType(MsgTypeEnum.MsgType_Text);
	}
	@Override
	public String toString()
	{
		super.toString();
		return "文本消息类";
	}
	

}
