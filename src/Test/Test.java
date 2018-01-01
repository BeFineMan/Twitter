package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import stu.wl.twitter.dao.UserDao;
import stu.wl.twitter.domain.BaseInfo;
import stu.wl.twitter.domain.User;
import stu.wl.twitter.impl.PeopleDaoImpl;

public class Test {
	public static void main(String args[]){
		/*Configuration cfg = new Configuration().configure("configuration/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();*/
		System.out.println("11");
		ApplicationContext con = new ClassPathXmlApplicationContext("configuration/applicationContext.xml");
		UserDao userdao = (UserDao) con.getBean("userDao");
		PeopleDaoImpl peopledao = (PeopleDaoImpl) con.getBean("peopleDao");
		
		//User user = new User();
		BaseInfo base = new BaseInfo();
		base.setUserid("1q111qq12123q");
		peopledao.save(base);
		/*user.setBaseInfo(base);
		user.setUserid("qqqqqq");
		userdao.save(user);*/
		
	}
}




