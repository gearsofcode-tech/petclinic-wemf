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
import java.util.List;
import java.math.BigDecimal;
import java.io.Serializable;

@Entity
public class Specialty implements Serializable {
	@Id
	private int id;
	private String name;
	@ManyToMany
	private List<Veterinarian> veterinarians;

	public List<Veterinarian> getVeterinarians() {
		return veterinarians;
	}

	public void setVeterinarians(List<Veterinarian> veterinarians) {
		this.veterinarians = veterinarians;
	}

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
}
