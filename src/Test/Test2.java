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
		
	

		User user = new User();
		user.setUserid("123123456123564123456213231213123425613");
		
		BaseInfo baseinfo = new BaseInfo();
		baseinfo.setUserid("123123456123564123432132156123425613");
		
		user.setBaseInfo(baseinfo);
		
		Session session  = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
			
		
		tx.commit();
		session.close();
	}
}



