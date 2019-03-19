package com.wechat.global.enums;

/**
 * 事件类型枚举
 * */
public class EventTypeEnum {
	/** 请求消息推送*/
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";
	/** 关注事件*/
	public static final String MsgType_Subscribe="subscribe";
	/** 取消关注事件*/
	public static final String MsgType_UnSubscribe="unsubscribe";
	/** 自定义菜单点击事件*/
	public static final String MsgType_Click="CLICK";
	/** 位置上报事件*/
	public static final String EVENT_TYPE_LOCATION = "LOCATION";
	/** 自定义菜单view事件*/
	public static final String EVENT_TYPE_VIEW = "VIEW";
	/** 二维码扫描事件*/
	 public static final String EVENT_TYPE_SCAN = "SCAN";
	

}
