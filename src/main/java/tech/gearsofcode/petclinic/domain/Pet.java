package tech.gearsofcode.petclinic.domain;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Pet implements Serializable{
	@Id
	private int id;
	private String name;
	private Date birthDate;
	private PetType type;
	
	@ManyToOne
	private Owner owner;
	
	@OneToMany
	private List<Visit> visits;
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}



	public PetType getType() {
		return type;
	}



	public void setType(PetType type) {
		this.type = type;
	}



	public List<Visit> getVisits() {
		return visits;
	}



	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}
}
