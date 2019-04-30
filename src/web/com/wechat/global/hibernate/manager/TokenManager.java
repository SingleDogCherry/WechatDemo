package com.wechat.global.hibernate.manager;

import com.wechat.global.hibernate.entity.Token;

public interface TokenManager {
	public void saveToken(Token  token);
	public Token getToken() ;
}
