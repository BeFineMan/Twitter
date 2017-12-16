package Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import stu.wl.twitter.dao.UserDao;
import stu.wl.twitter.domain.User;
import stu.wl.twitter.service.UserService;

public class Test {
	public static void main(String args[]){
		ApplicationContext con = new ClassPathXmlApplicationContext("configuration/applicationContext.xml");
		
		UserService userService = (UserService) con.getBean("userService");
		User user = userService.getUserById("20171216");
		System.out.println(user);
		
		/*User user = new User();
		user.setUserid("20171216");
		user.setUserName("1040978586@qq.com");
		user.setPassword("123456789");
		user.setRealName("英俊哥");
		
		UserDao userdao = (UserDao) con.getBean("userDao");
		userdao.save(user);
		System.out.println("保存成功");*/
	}
}




