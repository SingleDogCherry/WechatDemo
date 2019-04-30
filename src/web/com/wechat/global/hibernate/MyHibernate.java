package com.wechat.global.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.wechat.global.hibernate.dao.standard.StandardTokenDao;

public class MyHibernate extends HibernateDaoSupport{
	// private static SessionFactory sessionFactory;
	StandardTokenDao standardTokenDao;
	
	
	public StandardTokenDao getStandardTokenDao() {
		return standardTokenDao;
	}
	public void setStandardTokenDao(StandardTokenDao standardTokenDao) {
		this.standardTokenDao = standardTokenDao;
	}
	public static void main(String[] args) {
		MyHibernate myHibernate = new MyHibernate();
		//myHibernate.testMyHibernate();
		myHibernate.testMyHibernate();

	}
	public void testTokenDao() {
		
		
		
		
		
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public void mainHibernate() {
		SessionFactory sessionFactory;
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // configures settings from
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//session.saveOrUpdate( new Lottery(10001,"01","01","01","01","02","01","01") );

		@SuppressWarnings("rawtypes")
		List result = session.createQuery("from Lottery where report_id=:report_id").setParameter("report_id", 10001).list();
		//List result = session.createQuery("from Lottery  where report_id=10001").list();
		for (Lottery event : (List<Lottery>) result) {
			System.out.println("Event (" + event.toString() + ") : " + event.toString());
		}
		session.getTransaction().commit();
		session.close();
		//session.saveOrUpdate(object);
		sessionFactory.close();
	}
	/*public void testHibernateS() {
		Criteria criteriaQuery = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Lottery.class);
		criteriaQuery.add(Restrictions.eq(Lottery.PROP_BLUE_BALL_1,"02"));
		Lottery tmp = (Lottery)criteriaQuery.list();
		tmp.toString();
		extends HibernateDaoSupport
	}
*/
	public void testMyHibernate() {

		/*
		 * // TODO Auto-generated method stub //Session session = new
		 * SessionFactory().openSession(); final StandardServiceRegistry registry = new
		 * StandardServiceRegistryBuilder() .configure() // configures settings from
		 * hibernate.cfg.xml .build(); setSessionFactory(new MetadataSources( registry
		 * ).buildMetadata().buildSessionFactory()); Session session =
		 * sessionFactory.openSession(); session.beginTransaction(); List<Lottery>
		 * result = session.createQuery( "from lottery where reprot_id='07001'"
		 * ).list(); for ( Lottery lottery : (List<Lottery>) result ) {
		 * System.out.println( "Lottery (" + lottery.toString() + ") : " +
		 * lottery.toString() ); } session.getTransaction().commit(); session.close();
		 * 
		 */
		System.out.println("开始                               ------------------------------------------------");
		Configuration configuation = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuation.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		@SuppressWarnings("unchecked")
		List<Lottery> result = session.createQuery("from Lottery ").list();

		for (Lottery lottery : (List<Lottery>) result) {
			System.out.println("Lottery (" + lottery.toString() + ") : " + lottery.toString());
		}
		transaction.commit();
		session.close();
		System.out.println("结束了                                ------------------------------------------------");

	}

}
