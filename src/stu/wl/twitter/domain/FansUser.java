package stu.wl.twitter.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "t_fansUser")
//@PrimaryKeyJoinColumn(name = "fans_user_id")  
//粉丝
public class FansUser{
	@Id
	@GenericGenerator(name="foreignKey", strategy="foreign", parameters=@Parameter(name="property", value="user"))  
    @GeneratedValue(generator="foreignKey", strategy=GenerationType.IDENTITY)
	private String fansId;
	
	@ManyToMany(targetEntity = FocusUser.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.EAGER)
	@JoinTable(name = "t_focusAndFans",
		joinColumns = @JoinColumn(name = "fans_id"),
		inverseJoinColumns = @JoinColumn(name = "focus_id")
			)
	private List<FocusUser> focusUser = new LinkedList<FocusUser>();	//关注的用户
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="userid", referencedColumnName="userid")  
	private User user;	//变成用户

	public String getFansId() {
		return fansId;
	}

	public void setFansId(String fansId) {
		this.fansId = fansId;
	}

	public List<FocusUser> getFocusUser() {
		return focusUser;
	}

	public void setFocusUser(List<FocusUser> focusUser) {
		this.focusUser = focusUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
