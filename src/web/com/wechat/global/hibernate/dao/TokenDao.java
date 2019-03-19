package com.wechat.global.hibernate.dao;

import com.wechat.global.hibernate.entity.Token;

public interface TokenDao {
	public void saveToken(Token token);
	public Token getToken();
}
