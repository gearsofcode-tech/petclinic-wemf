package tech.gearsofcode.petclinic.domain;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Pet implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	
	private Date birthDate;
	
	@OneToOne
	private PetType type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Owner owner;
	
	@OneToMany(fetch = FetchType.LAZY)
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
