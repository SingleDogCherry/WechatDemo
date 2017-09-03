package com.wechat.global.service.inter;

import java.util.Map;

public interface EventServiceInterface extends BaseInterface{
	/**
	 * 事件处理接口
	 * */
	 String execRequest(Map<String, String> returnMap) ;

}
