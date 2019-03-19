package com.wechat.global.service.inter;


import java.util.Map;

/**
 * 服务处理接口
 * 
 */
public interface ServiceInterface  extends BaseInterface {
	/**
	 * 消息请求处理方法
	 * */
	  String execRequest(Map<String, String> requestMap) ;
}
