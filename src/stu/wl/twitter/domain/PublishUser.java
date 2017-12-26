package stu.wl.twitter.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "t_publish_user")
@PrimaryKeyJoinColumn(name = "publish_user_id")  
public class PublishUser extends User{
	@OneToMany(targetEntity = Discuss.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "publish_user")
	private List<Discuss> pub_discusses;	//提交的评论

	public List<Discuss> getPub_discusses() {
		return pub_discusses;
	}

	public void setPub_discusses(List<Discuss> pub_discusses) {
		this.pub_discusses = pub_discusses;
	}

	
}
