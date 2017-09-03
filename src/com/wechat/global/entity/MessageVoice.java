package com.wechat.global.entity;

import com.wechat.global.entity.base.MessageBase;
import com.wechat.global.enums.MsgTypeEnum;

public class MessageVoice extends MessageBase {
	/** voice */
	private static final String MsgType = MsgTypeEnum.MsgType_Voice;
	/** media_id */
	private String MediaId;
	/** 语音格式 */
	private String Format;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public static String getMsgtype() {
		return MsgType;
	}

}
