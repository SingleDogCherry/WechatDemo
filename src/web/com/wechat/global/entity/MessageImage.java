package com.wechat.global.entity;

import com.wechat.global.entity.base.MessageBase;
import com.wechat.global.enums.MsgTypeEnum;

/**
 * 图片消息实体
 * 
 * */
public class MessageImage extends MessageBase {
	/** 图片链接（由系统生成） */
	private String picUrl;
	/** 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。 */
	private String mediaId;
	/** 图片类型 */
	// private static final String msgType=MsgTypeEnum.MsgType_Image;
	/** 图片描述 */
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	public void setMsgType(String msgType) {
		super.setMsgType(MsgTypeEnum.MsgType_Image);
	}
	@Override
	public String toString()
	{
		super.toString();
		return "图片消息类";
	}
	

}
