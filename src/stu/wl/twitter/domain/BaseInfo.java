package stu.wl.twitter.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "t_baseinfo")
public class BaseInfo{		//基本信息
	@Id
	private String userid;
	private String nickName;	//昵称
	private String realName;	//真实姓名
	private char sex;	//性别
	private Date birthday;	//生日
	private String simpleinfo;	//简介
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSimpleinfo() {
		return simpleinfo;
	}
	public void setSimpleinfo(String simpleinfo) {
		this.simpleinfo = simpleinfo;
	}
	@Override
	public String toString() {
		return "BaseInfo [nickName=" + nickName + ", realName=" + realName + ", sex=" + sex + ", birthday=" + birthday
				+ ", simpleinfo=" + simpleinfo + "]";
	}
	
}
