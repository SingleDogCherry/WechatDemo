package com.wechat.global.hibernate.manager.standard;

import org.springframework.transaction.annotation.Transactional;

import com.wechat.global.hibernate.dao.TokenDao;
import com.wechat.global.hibernate.entity.Token;
import com.wechat.global.hibernate.manager.TokenManager;
@Transactional 
public class StandardTokenManager implements TokenManager {

	private TokenDao tokenDao;
	@Override
	public void saveToken(Token token) {
		// TODO Auto-generated method stub
		tokenDao.saveToken(token);

	}

	public TokenDao getTokenDao() {
		return tokenDao;
	}

	public void setTokenDao(TokenDao tokenDao) {
		this.tokenDao = tokenDao;
	}

	@Override
	public Token getToken() {
		// TODO Auto-generated method stub
		return tokenDao.getToken();
	}

}
