package tech.gearsofcode.petclinic.facade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.gearsofcode.petclinic.domain.PetType;
import tech.gearsofcode.petclinic.service.PetTypeService;
import tech.gearsofcode.petclinic.web.dto.PetTypeCriteria;
import tech.gearsofcode.petclinic.web.dto.PetTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
@Service
@Transactional
@Component
public class PetTypeFacade {
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	@Autowired
	private PetTypeService petTypeService;
	public void delete (PetType petType){
		petTypeService.delete(petType);
	} 



	public void update (PetTypeDTO petTypeDTO){
		PetType petType = findById(petTypeDTO.getId());
		updateModel(petType, petTypeDTO);
		petTypeService.update(petType);
	}



	public PetType findById(int id){
		return petTypeService.findById(id);
	}



	public List<PetType> findByCriteria(PetTypeCriteria petTypeCriteria){
		return petTypeService.findByCriteria(petTypeCriteria);
	}



	public Long getTotalRecords(PetTypeCriteria petTypeCriteria){
		return petTypeService.getTotalRecords(petTypeCriteria);
	}



	public List<PetType> findAll(){
		return petTypeService.findAll();
	}



	public void insert (PetTypeDTO petTypeDTO){
		PetType petType = toModel(petTypeDTO);
		petTypeService.insert(petType);
	}



	public PetTypeDTO toDTO(PetType petType){
		PetTypeDTO petTypeDTO = new PetTypeDTO(); 	
		petTypeDTO.setId(petType.getId());
		petTypeDTO.setName(petType.getName());
		return petTypeDTO;
	}		



	public PetType toModel(PetTypeDTO petTypeDTO){
		PetType petType = new PetType(); 
		petType.setId(petTypeDTO.getId());
		petType.setName(petTypeDTO.getName());
		return petType;
	}	



	public void updateModel(PetType petType, PetTypeDTO dto){
		petType.setId(dto.getId());
		petType.setName(dto.getName());
	}
}
