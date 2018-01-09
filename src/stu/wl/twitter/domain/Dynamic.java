package stu.wl.twitter.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="t_dynamic")
public class Dynamic {	//动态
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String dynamicId;	//id
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;		//用户
	private String topic;	//标题
	private String content;		//内容
	private String path;	//视频图片的路径
	private int like_number;	//点赞数
	
	@OneToMany(targetEntity = Discuss.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "dynamic_id")
	private List<Discuss> discuss;	//评论
	private String deliver_time;	//发表时间
	public String getDynamicId() {
		return dynamicId;
	}
	public void setDynamicId(String dynamicId) {
		this.dynamicId = dynamicId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getLike_number() {
		return like_number;
	}
	public void setLike_number(int like_number) {
		this.like_number = like_number;
	}
	public List<Discuss> getDiscuss() {
		return discuss;
	}
	public void setDiscuss(List<Discuss> discuss) {
		this.discuss = discuss;
	}
	public String getDeliver_time() {
		return deliver_time;
	}
	public void setDeliver_time(String deliver_time) {
		this.deliver_time = deliver_time;
	}
	@Override  
	@Transactional
	public String toString() {
		return "Dynamic [dynamicId=" + dynamicId + ", user=" + user + ", topic=" + topic + ", content=" + content
				+ ", path=" + path + ", like_number=" + like_number + ", discuss=" + discuss + ", deliver_time="
				+ deliver_time + "]";
	}
	
	
}
