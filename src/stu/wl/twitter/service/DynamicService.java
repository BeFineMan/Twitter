package stu.wl.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stu.wl.twitter.dao.DynamicDao;
import stu.wl.twitter.domain.Dynamic;
import stu.wl.twitter.domain.User;

@Service("dynamicService")
public class DynamicService {
	@Autowired
	private DynamicDao dynamicDao;

	
	public void publishDynamic(User user,String path){
		Dynamic dynamic = new Dynamic();
		dynamic.setDeliver_time(new Date());
	}
	
	public DynamicDao getDynamicDao() {
		return dynamicDao;
	}

	public void setDynamicDao(DynamicDao dynamicDao) {
		this.dynamicDao = dynamicDao;
	}
	
}
