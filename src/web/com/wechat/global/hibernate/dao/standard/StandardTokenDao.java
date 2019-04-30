package com.wechat.global.hibernate.dao.standard;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.wechat.global.hibernate.dao.TokenDao;
import com.wechat.global.hibernate.entity.Token;

public class StandardTokenDao extends HibernateTemplate implements TokenDao  {

private SessionFactory sessionFactory;
    
    //获取和当前线程绑定的Seesion
    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
    
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveToken(Token token) {
		// TODO Auto-generated method stub
		  this.getSession().save(token);
		
	}

	@Override
	public Token getToken() {
		// TODO Auto-generated method stub
		String hql=" select * from Token order by create_Time desc limit 0,1 ";
		//getSession().createSQLQuery(hql).list().get(0);
        //Query query=getSession().createQuery(hql);
		return (Token)getSession().createSQLQuery(hql).addEntity(Token.class).list().get(0);
	}

}
