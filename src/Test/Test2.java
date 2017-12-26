package Test;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import stu.wl.twitter.domain.BaseInfo;
import stu.wl.twitter.domain.ConcernInfo;
import stu.wl.twitter.domain.User;

public class Test2 {
	public static void main(String args[]){
		Configuration cfg= new Configuration().configure("configuration/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session  = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, "100");
		System.out.println(user);
		//tx.commit();
		session.close();
	}
}



