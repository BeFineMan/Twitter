package Test;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_score")
public class Score {
	@Id
	@GeneratedValue(generator="assigned")
	@GenericGenerator(name="assigned",strategy="assigned")
	private String sid;
	
	//@ManyToOne(targetEntity = People.class, cascade = CascadeType.ALL)
	//@JoinColumn(name = "stu_id")
	@Transient
	private People student;
	
	//@ManyToOne(targetEntity = People.class, cascade = CascadeType.ALL)
	//@JoinColumn(name = "tea_id")
	@Transient
	private People teacher;
	
	@ManyToOne(targetEntity = People.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "people_id")
	private People people;
	private String score;
	public People getPeople() {
		return people;
	}
	public void setPeople(People people) {
		this.people = people;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public People getStudent() {
		return student;
	}
	public void setStudent(People student) {
		this.student = student;
	}
	public People getTeacher() {
		return teacher;
	}
	public void setTeacher(People teacher) {
		this.teacher = teacher;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	
}
