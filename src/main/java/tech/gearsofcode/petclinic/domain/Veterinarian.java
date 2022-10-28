package tech.gearsofcode.petclinic.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.List;
@Entity
public class Veterinarian implements Serializable{
	@Id
	private int id;
	private String firstName;
	private String lastName;
	@ManyToMany
	private List<Specialty> specialties;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public List<Specialty> getSpecialties() {
		return specialties;
	}



	public void setSpecialties(List<Specialty> specialties) {
		this.specialties = specialties;
	}
}
