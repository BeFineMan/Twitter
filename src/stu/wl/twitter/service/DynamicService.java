package stu.wl.twitter.service;

import org.springframework.stereotype.Service;

import stu.wl.twitter.dao.DynamicDao;
import stu.wl.twitter.domain.User;

@Service("dynamicService")
public class DynamicService {
	private DynamicDao dynamicDao;

	public void publishDynamic(User user){
		
	}
	
	public DynamicDao getDynamicDao() {
		return dynamicDao;
	}

	public void setDynamicDao(DynamicDao dynamicDao) {
		this.dynamicDao = dynamicDao;
	}
	
}
