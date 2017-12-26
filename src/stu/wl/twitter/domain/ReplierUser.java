package stu.wl.twitter.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "t_replier_user")
@PrimaryKeyJoinColumn(name="replier_user_id")  
public class ReplierUser extends User{
	@OneToMany(targetEntity = Discuss.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "replier_user")
	private List<Discuss> rep_discusses;	//回复的评论

	public List<Discuss> getRep_discusses() {
		return rep_discusses;
	}

	public void setRep_discusses(List<Discuss> rep_discusses) {
		this.rep_discusses = rep_discusses;
	}

}
