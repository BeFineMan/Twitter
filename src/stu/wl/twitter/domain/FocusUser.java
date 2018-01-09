package stu.wl.twitter.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "t_focusUser")
//@PrimaryKeyJoinColumn(name = "focus_user_id")
//关注用户
public class FocusUser{
	@Id
	@GenericGenerator(name="foreignKey", strategy="foreign", parameters=@Parameter(name="property", value="user"))  
    @GeneratedValue(generator="foreignKey", strategy=GenerationType.IDENTITY)
	private String focusId;
	@ManyToMany(targetEntity = FansUser.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST},mappedBy = "focusUser")
	private List<FansUser> fans = new LinkedList<FansUser>();	//粉丝，也就是被关注的用户
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="userid", referencedColumnName="userid")  
	private User user;		//变成用户
	
	public String getFocusId() {
		return focusId;
	}

	public void setFocusId(String focusId) {
		this.focusId = focusId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<FansUser> getFans() {
		return fans;
	}

	public void setFans(List<FansUser> fans) {
		this.fans = fans;
	}

}
