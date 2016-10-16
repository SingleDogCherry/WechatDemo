package com.wechat.global.entity;

import com.wechat.global.enums.MsgTypeEnum;


public class MessageImage {
	/**图片链接（由系统生成）*/
	private String picUrl;
	/**图片消息媒体id，可以调用多媒体文件下载接口拉取数据。*/
	private String mediaId;
	/**图片类型*/
	@SuppressWarnings("unused")
	private String msgType;
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
	public String getMsgType() {
		return MsgTypeEnum.MsgType_Image;
	}
	public void setMsgType(String msgType) {
		this.msgType = MsgTypeEnum.MsgType_Image;;
	}
	
}
