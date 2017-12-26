package stu.wl.twitter.dao;

import java.util.List;

import stu.wl.twitter.domain.User;

public interface UserDao extends BaseDao<User>{
	User getUserByUserName(String userName);
	List queryUserByUserName(String userName);
	Object queryUserId(String userid);
}
