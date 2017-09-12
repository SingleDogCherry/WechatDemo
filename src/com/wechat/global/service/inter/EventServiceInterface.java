package com.wechat.global.service.inter;

import java.util.Map;
/**
 * 事件处理接口
 * */
public interface EventServiceInterface extends BaseInterface{

	/**
	 * @param  请求map
	 * @return 返回处理字符串
	 * */
	 String execRequestMap(Map<String, String> requestMap) ;

}
