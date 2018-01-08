package Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import stu.wl.twitter.domain.BaseInfo;
import stu.wl.twitter.domain.Dynamic;
import stu.wl.twitter.domain.User;

public class Test2 {
	public static void main(String args[]){
		System.out.println("ru11n");
		Configuration cfg= new Configuration().configure("configuration/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Dynamic dynamic = new Dynamic();

		session.save(dynamic);
			
		
		tx.commit();
		session.close();
	}
}



