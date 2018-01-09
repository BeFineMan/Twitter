package stu.wl.twitter.dao;

import java.util.List;

import stu.wl.twitter.domain.Dynamic;
import stu.wl.twitter.domain.User;

public interface DynamicDao extends BaseDao<Dynamic>{
	List<Dynamic> getDynamicsByUserByfocus(User user);
	List<Dynamic> getDynamicsByUserAndFocus(User user);
}
