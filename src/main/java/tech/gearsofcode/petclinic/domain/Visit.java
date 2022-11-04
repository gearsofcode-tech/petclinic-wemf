package tech.gearsofcode.petclinic.domain;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Visit implements Serializable{
	
	private static final long serialVersionUID = 962694744405512624L;
	@Id
	private int id;
	private Date date;
	private String description;
	@ManyToOne
	private Pet pet;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
}
