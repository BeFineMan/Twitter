package Test;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import stu.wl.twitter.domain.FansUser;
import stu.wl.twitter.domain.FocusUser;
import stu.wl.twitter.domain.User;

public class Test2 {
	public static void main(String args[]){
		System.out.println("```````````````");
		Configuration cfg= new Configuration().configure("configuration/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		/*User user = new User();
		user.setUserid("dsadasdas26dad65as");
		FocusUser focus = new FocusUser();
		user.setBeFocusUser(focus);
		focus.setUser(user);*/
		
		/*User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		User user4 = new User();
		
		user1.setUserid("oooooo1");
		user2.setUserid("oooooo2");
		user3.setUserid("oooooo3");
		user4.setUserid("oooooo4");

		FocusUser focusUser1 = new FocusUser();
		FocusUser focusUser2 = new FocusUser();
		FocusUser focusUser3 = new FocusUser();
		FocusUser focusUser4 = new FocusUser();

		FansUser fansUser1 = new FansUser();
		FansUser fansUser2 = new FansUser();
		FansUser fansUser3 = new FansUser();
		FansUser fansUser4 = new FansUser();

		user1.setBeFocusUser(focusUser1);
		user1.setBeFansUser(fansUser1);
		
		user2.setBeFocusUser(focusUser2);
		user2.setBeFansUser(fansUser2);
		
		user3.setBeFocusUser(focusUser3);
		user3.setBeFansUser(fansUser3);
		
		user4.setBeFocusUser(focusUser4);
		user4.setBeFansUser(fansUser4);
		
		focusUser1.setUser(user1);
		focusUser2.setUser(user2);
		focusUser3.setUser(user3);
		focusUser4.setUser(user4);

		fansUser1.setUser(user1);
		fansUser2.setUser(user2);
		fansUser3.setUser(user3);
		fansUser4.setUser(user4);

		
		session.save(user1);
		session.save(user2);
		session.save(user3);
		session.save(user4);*/
		
		FocusUser focusUser1 = session.get(FocusUser.class, "oooooo1");
		FocusUser focusUser2 = session.get(FocusUser.class, "oooooo2");
		FocusUser focusUser3 = session.get(FocusUser.class, "oooooo3");
		FocusUser focusUser4 = session.get(FocusUser.class, "oooooo4");
		
		FansUser fansUser1 = session.get(FansUser.class, "oooooo1");
		FansUser fansUser2 = session.get(FansUser.class, "oooooo2");
		FansUser fansUser3 = session.get(FansUser.class, "oooooo3");
		FansUser fansUser4 = session.get(FansUser.class, "oooooo4");

		//这个用户被三个用户关注了
		focusUser1.getFans().add(fansUser2);
		focusUser1.getFans().add(fansUser3);
		focusUser1.getFans().add(fansUser4);
		
		
		//这三个用户关注了这个用户
		fansUser2.getFocusUser().add(focusUser1);
		fansUser3.getFocusUser().add(focusUser1);
		fansUser4.getFocusUser().add(focusUser1);
		
		focusUser3.getFans().add(fansUser2);
		fansUser2.getFocusUser().add(focusUser3);


		session.update(focusUser1);
		session.update(focusUser3);
		
		tx.commit();
		session.close();
	}
}



