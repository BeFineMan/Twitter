package stu.wl.twitter.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import stu.wl.twitter.dao.UserDao;
import stu.wl.twitter.domain.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	private static final String GET_USER_BY_USERNAME = "from User u where u.userName = ?";
	private static final String QUERY_USER_BY_USERNAME = "from User u where u.userName like ?";
	
	//根据用户名获取用户
	public User getUserByUserName(String userName){
		List<User> users=(List<User>) super.getHibernateTemplate().find(GET_USER_BY_USERNAME, userName);
		if(users.isEmpty()){
			return null;
		}else{
			return users.get(0);
		}
	}
	
	//根据用户名模糊查询
	public List queryUserByUserName(String userName){
		return (List<User>) super.getHibernateTemplate().find(QUERY_USER_BY_USERNAME, userName);
	}
	
	//查询userid是否存在
	public Object queryUserId(String userid){
		String sql = "SELECT userid FROM t_user where userid = '"+userid+"'";
		List list = super.getSession().createNativeQuery(sql).getResultList();
		return list.isEmpty() ? null : list.get(0);
	}
	
	/*获取关注的用户*/
	public List<User> getFocusByUser(User user){
		Session session = super.getSession();
		Transaction tx = session.beginTransaction();
		
		List<User> users = user.getFocusUser();
		
		tx.commit();
		session.close();
		return users;
	}
	
}





