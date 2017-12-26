package Test;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_teacher")
public class Teacher extends People{
	//@OneToMany(targetEntity = Score.class, cascade = CascadeType.ALL)
	//@JoinColumn(name = "tea_id")
	@Transient
	private List<Score> scores;
	
	public Teacher(String name){
		this.setName(name);
	}
	public Teacher(){}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	
}
