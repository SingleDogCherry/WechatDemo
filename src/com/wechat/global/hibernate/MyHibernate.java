package com.wechat.global.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class MyHibernate {
	// private static SessionFactory sessionFactory;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		SessionFactory sessionFactory;
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // configures settings from
																							// hibernate.cfg.xml
				
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//session.saveOrUpdate( new Lottery(10001,"01","01","01","01","02","01","01") );

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
