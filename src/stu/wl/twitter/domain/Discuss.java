package stu.wl.twitter.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "t_discuss")
public class Discuss {		//评论
	@Id
	@GeneratedValue(generator = "assigned")
	@GenericGenerator(name = "assigned", strategy = "assigned")
	private String discussId;	//id
	
	@ManyToOne(targetEntity = PublishUser.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "publish_user")
	private User publishUser;	//发表评论的用户
	
	@ManyToOne(targetEntity = ReplierUser.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "replier_user")
	private User replierUser;	//回复评论的用户
	
	private String content;		//内容
	private int like_number;	//点赞数
	private String dicuss_time;		//评论时间
	public String getDiscussId() {
		return discussId;
	}
	public void setDiscussId(String discussId) {
		this.discussId = discussId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLike_number() {
		return like_number;
	}
	public void setLike_number(int like_number) {
		this.like_number = like_number;
	}
	public String getDicuss_time() {
		return dicuss_time;
	}
	public void setDicuss_time(String dicuss_time) {
		this.dicuss_time = dicuss_time;
	}
	public User getPublishUser() {
		return publishUser;
	}
	public void setPublishUser(User publishUser) {
		this.publishUser = publishUser;
	}
	public User getReplierUser() {
		return replierUser;
	}
	public void setReplierUser(User replierUser) {
		this.replierUser = replierUser;
	}
	@Override
	@Transactional
	public String toString() {
		return "Discuss [discussId=" + discussId + ", content=" + content + ", like_number=" + like_number
				+ ", dicuss_time=" + dicuss_time + "]";
	}
	
}
