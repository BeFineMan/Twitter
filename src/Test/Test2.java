package Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import stu.wl.twitter.domain.Dynamic;
import stu.wl.twitter.domain.User;

public class Test2 {
	public static void main(String args[]){
		System.out.println("ru1n");
		Configuration cfg= new Configuration().configure("configuration/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session  = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		/*User user = new User();
		User user1 = new User();
		User user2 = new User();
		
		user.setUserid("aaaaaa111111");
		user1.setUserid("aaaaaa111112");
		user2.setUserid("aaaaaa111113");

		List<User> users = new LinkedList<User>();
		users.add(user1);
		users.add(user2);
		
		user.setFocusUser(users);
		session.save(user1);
		session.save(user2);
		session.save(user);
		tx.commit();*/
		
			User user = session.get(User.class, "aaaaaa111111");
			
		
		tx.commit();
		session.close();
	}
}



