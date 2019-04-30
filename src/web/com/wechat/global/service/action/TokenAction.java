package com.wechat.global.service.action;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.wechat.global.hibernate.entity.Token;
import com.wechat.global.hibernate.manager.TokenManager;



/**
 * @author cherryxing
 * @category 
 * 
 * */
public class TokenAction extends ActionSupport{
	static Logger logger = LogManager.getLogger(TokenAction.class.getName());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accessToken;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public TokenManager getTokenManager() {
		return tokenManager;
	}
	public void setTokenManager(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}
	public void setToken(Token token) {
		this.token = token;
	}
	private TokenManager tokenManager;
	private Token token;
	public Token getToken() {
		return token;
	}
	public String getTokenInfo() {
		logger.info("############################################################");
		token=tokenManager.getToken();
		accessToken = token.getAccessToken();
		
		
		
		logger.info("####################token########################################"+token.toString());
		return SUCCESS;
	}
	
	
	
	
	
	

}
