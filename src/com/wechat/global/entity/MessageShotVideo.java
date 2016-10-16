package com.wechat.global.entity;

import com.wechat.global.entity.base.MessageBase;
import com.wechat.global.enums.MsgTypeEnum;

public class MessageShotVideo  extends MessageBase {
	
	/**小视频为shortVideo*/
	private  static final String msgType=MsgTypeEnum.MsgType_Shortvideo;
	/**视频消息媒体id*/
	private String MediaId;
	/**视频消息缩略图的媒体id*/
	private String thumbMediaId;


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
