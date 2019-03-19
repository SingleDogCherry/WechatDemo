package com.wechat.global.entity;

import com.wechat.global.entity.base.MessageBase;
import com.wechat.global.enums.MsgTypeEnum;
/**
 * 地理位置实体
 * 
 * */
public class MessageLocation extends MessageBase {
	/** 地理位置为location */
	private static final String msgType = MsgTypeEnum.MsgType_Location;
	/** 地理位置维度 */
	private String Location_X;
	/** 地理位置经度 */
	private String Location_Y;
	/** 地图缩放大小 */
	private String Scale;
	/** 地理位置信息 */
	private String Label;

	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public static String getMsgtype() {
		return msgType;
	}
	@Override
	public void setMsgType(String msgType){
		super.setMsgType(MsgTypeEnum.MsgType_Location);
	}

}
