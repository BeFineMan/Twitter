package stu.wl.twitter.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="t_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable{
	private static final long seriaVersionUID = 10L;
	@Id
	@GeneratedValue(generator="assigned")
	@GenericGenerator(name="assigned",strategy="assigned")
	private String userid;		//用户id
	private String userName;	//用户名
	private String password;	//密码
	private String icon; 	//头像
	
	@OneToOne(targetEntity = BaseInfo.class,cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "baseInfo_id")
	private BaseInfo baseInfo;	//基本信息
	
	@OneToOne(targetEntity = ConcernInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "concerInfo_id")
	private ConcernInfo concernInfo;	//联系信息
	
	@OneToMany(targetEntity = Dynamic.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Dynamic> dynamics;		//动态
	
	@OneToMany(targetEntity = Discuss.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Discuss> discusses;	//评论
	
	@OneToMany(targetEntity = User.class,cascade = CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name = "focusUser_id")	
	private List<User> focusUser;	//关注的用户
 
	public User(){}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Dynamic> getDynamics() {
		return dynamics;
	}
	public void setDynamics(List<Dynamic> dynamics) {
		this.dynamics = dynamics;
	}
	public List<Discuss> getDiscusses() {
		return discusses;
	}
	public void setDiscusses(List<Discuss> discusses) {
		this.discusses = discusses;
	}
	public BaseInfo getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	public ConcernInfo getConcernInfo() {
		return concernInfo;
	}
	public void setConcernInfo(ConcernInfo concernInfo) {
		this.concernInfo = concernInfo;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public List<User> getFocusUser() {
		return focusUser;
	}
	public void setFocusUser(List<User> focusUser) {
		this.focusUser = focusUser;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", userName=" + userName + ", password=" + password + ", baseInfo=" + baseInfo
				+ ", concernInfo=" + concernInfo + "]";
	}
	
	
}
