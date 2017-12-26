package Test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test2 {
	public static void main(String args[]){
		Configuration cfg= new Configuration().configure("configuration/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session  = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		String sql = "SELECT userid FROM t_user where userid = '05'";
		List list = session.createNativeQuery(sql).getResultList();
		System.out.println(list.isEmpty()?"空":list.get(0));
		//tx.commit();
		session.close();
	}
}



