package com.wechat.global.service.inter;


import java.util.Map;

/**
 * 消息处理接口
 * 
 */
public interface MessageServiceInterface  extends BaseInterface {
	/**
	 * 消息请求处理方法
	 * */
	  String execRequest(Map<String, String> returnMap) ;
}
