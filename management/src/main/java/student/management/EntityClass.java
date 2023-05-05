package student.management;

import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Service
@Table(name="classtenth")
public class EntityClass {
	
	@Id
	private Integer rollnumber;
	private String name;
	private Integer tamil;
	private Integer english;
	private Integer maths;
	private Integer science;
	private Integer social;
	@Id
	public Integer getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(Integer rollnumber) {
		this.rollnumber = rollnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTamil() {
		return tamil;
	}
	public void setTamil(Integer tamil) {
		this.tamil = tamil;
	}
	public Integer getEnglish() {
		return english;
	}
	public void setEnglish(Integer english) {
		this.english = english;
	}
	public Integer getMaths() {
		return maths;
	}
	public void setMaths(Integer maths) {
		this.maths = maths;
	}
	public Integer getScience() {
		return science;
	}
	public void setScience(Integer science) {
		this.science = science;
	}
	public Integer getSocial() {
		return social;
	}
	public void setSocial(Integer social) {
		this.social = social;
	}
	
	
	
	

}
