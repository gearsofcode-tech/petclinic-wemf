package tech.gearsofcode.petclinic.domain;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class PetType implements Serializable{
	
	private static final long serialVersionUID = 1097180668120167992L;
	
	@Id
	private int id;
	private String name;
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
