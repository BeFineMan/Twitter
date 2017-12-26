package Test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import stu.wl.twitter.dao.UserDao;
import stu.wl.twitter.domain.Discuss;
import stu.wl.twitter.domain.PublishUser;
import stu.wl.twitter.domain.ReplierUser;
import stu.wl.twitter.domain.User;
import stu.wl.twitter.impl.PeopleDaoImpl;

public class Test {
	public static void main(String args[]){
		/*Configuration cfg = new Configuration().configure("configuration/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();*/
		
		ApplicationContext con = new ClassPathXmlApplicationContext("configuration/applicationContext.xml");
		UserDao userdao = (UserDao) con.getBean("userDao");
		PeopleDaoImpl peopledao = (PeopleDaoImpl) con.getBean("peopleDao");
		
		
		User user1 = new PublishUser();
		user1.setUserid("001");
		user1.setUserName("1040978586");
		User user2 = new ReplierUser();
		user2.setUserid("002");
		user2.setUserName("877462882");
		
		
		Discuss discuss = new Discuss();
		discuss.setDiscussId("110");
		discuss.setContent("哈啥的哈的撒");
		discuss.setPublishUser(user1);
		discuss.setReplierUser(user2);
		
		List<Discuss> discusses = new ArrayList<Discuss>();
		discusses.add(discuss);
		
		user1.setDiscusses(discusses);
		user2.setDiscusses(discusses);
		
		
		user1.setDiscusses(discusses);
		userdao.save(user1);
		userdao.save(user2);
		peopledao.save(discuss);
		
	}
}




