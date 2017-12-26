package Test;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_people")
@Inheritance(strategy = InheritanceType.JOINED)
public class People {
	@Id
	@GeneratedValue(generator="assigned")
	@GenericGenerator(name="assigned",strategy="assigned")
	private String pid;
	private String name;
	
	@OneToMany(targetEntity = Score.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "people_id")
	private List<Score> scorees;
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Score> getScorees() {
		return scorees;
	}

	public void setScorees(List<Score> scorees) {
		this.scorees = scorees;
	}

	@Override
	public String toString() {
		return "People [pid=" + pid + ", name=" + name + "]";
	}
	
}
