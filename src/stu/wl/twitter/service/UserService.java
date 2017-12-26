package stu.wl.twitter.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stu.wl.twitter.dao.UserDao;
import stu.wl.twitter.domain.User;
import stu.wl.twitter.exception.UserExistException;

@Service("userService")
public class UserService {
	@Autowired
	private UserDao userdao;
	
	//注册一个新用户，如果用户已存在，则抛出UserExistException异常
	public void register(User user) throws UserExistException{
		User u = userdao.getUserByUserName(user.getUserName());
		if(u != null){
			throw new UserExistException("用户名已存在");
		}else{
			synchronized (this) {
				user.setUserid(this.getSystemTime());
			}
			userdao.save(user);
		}
	}
	
	//根据userId加载User对象
	public User getUserById(String userId){
		return this.userdao.get(userId);
	}
	
	public User getUserByName(String name){
		User user=userdao.getUserByUserName(name);
		return user;
	}
	//获取时间戳+3个随机数
	public static String getSystemTime(){
		String date = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		StringBuffer sbf=new StringBuffer(date);
		
		Random rand = new Random();
		for(int i=0;i<3;i++){
			sbf.append(rand.nextInt(10));
		}
		return sbf.toString();
	}
	
	
	public UserDao getUserdao() {
		return userdao;
	}
	
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
}
