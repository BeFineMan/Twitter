package Test;

import java.io.PrintStream;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test2 {
	public static void main(String args[]){
		String str = "/Twitter/edit/json.log?test='测试一个值' && aa= 'asd'".trim();
		int whindex = str.indexOf('?');
		
		String param = str.substring(whindex+1);
		System.out.println(param);
		
		/*Configuration cfg= new Configuration().configure("configuration/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session  = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		String sql = "SELECT userid FROM t_user where userid = '05'";
		List list = session.createNativeQuery(sql).getResultList();
		System.out.println(list.isEmpty()?"空":list.get(0));
		//tx.commit();
		session.close();*/
	}
}



