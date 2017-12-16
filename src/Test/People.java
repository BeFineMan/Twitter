package Test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_people")
public class People {
	@Transient
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(generator="assigned")
	@GenericGenerator(name="assigned",strategy="assigned")
	private String id;
	private String name;
	private int age;
	private String describes;
	public People(){}
	public People(String name){
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + ", describe=" + describes + "]";
	}
	
}
