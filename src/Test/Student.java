package Test;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_student")
public class Student extends People{
	//@OneToMany(targetEntity = Score.class, cascade = CascadeType.ALL)
	//@JoinColumn(name = "stu_id")
	@Transient
	private List<Score> scores;
	private int age;
	public Student(){}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

}
