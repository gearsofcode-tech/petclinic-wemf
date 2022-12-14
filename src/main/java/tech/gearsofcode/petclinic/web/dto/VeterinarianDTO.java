package tech.gearsofcode.petclinic.web.dto;
import java.util.List;
public class VeterinarianDTO {
	private Integer id;
	private String firstName;
	private String lastName;
	private List<SpecialtyDTO> specialties;
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
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



	public List<SpecialtyDTO> getSpecialties() {
		return specialties;
	}



	public void setSpecialties(List<SpecialtyDTO> specialties) {
		this.specialties = specialties;
	}
}
