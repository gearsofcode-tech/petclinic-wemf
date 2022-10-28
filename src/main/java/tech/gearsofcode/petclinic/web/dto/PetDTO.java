package tech.gearsofcode.petclinic.web.dto;
import java.util.List;
public class PetDTO {
	private Integer id;
	private String birthDate;
	private PetTypeDTO type;
	private List<VisitDTO> visits;
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}



	public PetTypeDTO getType() {
		return type;
	}



	public void setType(PetTypeDTO type) {
		this.type = type;
	}



	public List<VisitDTO> getVisits() {
		return visits;
	}



	public void setVisits(List<VisitDTO> visits) {
		this.visits = visits;
	}
}
