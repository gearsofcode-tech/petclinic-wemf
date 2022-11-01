package tech.gearsofcode.petclinic.facade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.gearsofcode.petclinic.domain.Specialty;
import tech.gearsofcode.petclinic.service.SpecialtyService;
import tech.gearsofcode.petclinic.web.dto.SpecialtyCriteria;
import tech.gearsofcode.petclinic.web.dto.SpecialtyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
@Service
@Transactional
@Component
public class SpecialtyFacade {
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	@Autowired
	private SpecialtyService specialtyService;
	public void delete (Specialty specialty){
		specialtyService.delete(specialty);
	} 



	public void update (SpecialtyDTO specialtyDTO){
		Specialty specialty = findById(specialtyDTO.getId());
		updateModel(specialty, specialtyDTO);
		specialtyService.update(specialty);
	}



	public Specialty findById(int id){
		return specialtyService.findById(id);
	}



	public List<Specialty> findByCriteria(SpecialtyCriteria specialtyCriteria){
		return specialtyService.findByCriteria(specialtyCriteria);
	}



	public Long getTotalRecords(SpecialtyCriteria specialtyCriteria){
		return specialtyService.getTotalRecords(specialtyCriteria);
	}



	public List<Specialty> findAll(){
		return specialtyService.findAll();
	}



	public void insert (SpecialtyDTO specialtyDTO){
		Specialty specialty = toModel(specialtyDTO);
		specialtyService.insert(specialty);
	}



	public SpecialtyDTO toDTO(Specialty specialty){
		SpecialtyDTO specialtyDTO = new SpecialtyDTO(); 	
		specialtyDTO.setId(specialty.getId());
		specialtyDTO.setName(specialty.getName());
		return specialtyDTO;
	}		



	public Specialty toModel(SpecialtyDTO specialtyDTO){
		Specialty specialty = new Specialty(); 
		specialty.setId(specialtyDTO.getId());
		specialty.setName(specialtyDTO.getName());
		return specialty;
	}	



	public void updateModel(Specialty specialty, SpecialtyDTO dto){
		specialty.setId(dto.getId());
		specialty.setName(dto.getName());
	}
}
