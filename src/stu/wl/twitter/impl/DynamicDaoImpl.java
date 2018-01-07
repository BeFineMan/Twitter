package stu.wl.twitter.impl;

import java.util.List;

import stu.wl.twitter.dao.DynamicDao;
import stu.wl.twitter.domain.Dynamic;

public class DynamicDaoImpl extends BaseDaoImpl<Dynamic> implements DynamicDao{
	
	public List<Dynamic> getDynamicsByTime(){
		super.getHibernateTemplate().Q
		return null;
	}
}
