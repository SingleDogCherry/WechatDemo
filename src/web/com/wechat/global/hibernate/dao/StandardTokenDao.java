package com.wechat.global.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wechat.global.hibernate.entity.Token;

public class StandardTokenDao implements TokenDao{

private SessionFactory sessionFactory;
    
    //获取和当前线程绑定的Seesion
    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
    
	@Override
	public void saveToken(Token token) {
		// TODO Auto-generated method stub
		  getSession().save(token);
		
	}

	@Override
	public Token getToken() {
		// TODO Auto-generated method stub
		return null;
	}

}
