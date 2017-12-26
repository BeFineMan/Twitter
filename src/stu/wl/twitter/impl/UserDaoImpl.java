package stu.wl.twitter.impl;

import java.util.List;

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
	
	public List asdas(){
		return null;
	}
	
}
