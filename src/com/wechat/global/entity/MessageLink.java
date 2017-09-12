package com.wechat.global.entity;

import com.wechat.global.entity.base.MessageBase;
import com.wechat.global.enums.MsgTypeEnum;
/**
 * 链接消息实体
 * 
 * */
public class MessageLink extends MessageBase {
	/**消息标题*/
	private String title;
	/**消息描述*/
	private String description;
	/**消息链接*/
	private String url;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public void setMsgType(String msgType){
		super.setMsgType(MsgTypeEnum.MsgType_Link);
	}

}
