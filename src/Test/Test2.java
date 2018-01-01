package Test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import stu.wl.twitter.domain.BaseInfo;
import stu.wl.twitter.domain.User;

public class Test2 {
	public static void main(String args[]){
		
		Configuration cfg= new Configuration().configure("configuration/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session  = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		/*User user = null;
		BaseInfo base = null;
		for(int i = 0; i<5000000; i++){
			tx = session.beginTransaction();
			base = new BaseInfo();
			base.setUserid("testtt"+i);
			base.setNickName(i*i+"");
			base.setRealName(i*10+"");
			base.setSex('G');
			base.setSimpleinfo(""+i*i*i);
			
			user = new User();
			user.setUserid("testtt"+i);
			user.setBaseInfo(base);
			
			session.save(user);
			tx.commit();

		}*/
		
		User user = session.get(User.class, "test999");
		BaseInfo baseinfo = user.getBaseInfo();
		baseinfo.setBirthday(new Date());
		
		session.update(user);
		
		long t1 = System.currentTimeMillis();
		tx.commit();
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		
		session.close();
	}
}



