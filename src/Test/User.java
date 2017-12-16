package Test;

import org.springframework.stereotype.Component;

@Component("user")
public class User {
	private String name;
	public User(){
		System.out.println("初始化构造方法");
	}
	public User(String name){
		this.name = name;
	}
	public String toString(){
		return "User: name="+this.name;
	}
}
