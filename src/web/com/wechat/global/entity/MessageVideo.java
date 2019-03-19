package com.wechat.global.entity;

import com.wechat.global.entity.base.MessageBase;
import com.wechat.global.enums.MsgTypeEnum;
/**
 * 视频消息实体
 * 
 * */
public class MessageVideo extends MessageBase {
	/**视频消息媒体id*/
	private String MediaId;
	/**视频消息缩略图的媒体id*/
	private String thumbMediaId;
	/**视频为video*/
	private final static String msgType=MsgTypeEnum.MsgType_Video;
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	public static String getMsgtype() {
		return msgType;
	}
	

}
