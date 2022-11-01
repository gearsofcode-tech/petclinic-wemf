package tech.gearsofcode.petclinic.facade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.gearsofcode.petclinic.domain.Veterinarian;
import tech.gearsofcode.petclinic.domain.Specialty;
import tech.gearsofcode.petclinic.web.dto.SpecialtyDTO;
import tech.gearsofcode.petclinic.service.VeterinarianService;
import tech.gearsofcode.petclinic.web.dto.VeterinarianCriteria;
import tech.gearsofcode.petclinic.web.dto.VeterinarianDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
@Service
@Transactional
@Component
public class VeterinarianFacade {
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	@Autowired
	private VeterinarianService veterinarianService;

	@Autowired
	private SpecialtyFacade specialtyFacade;
	public void delete (Veterinarian veterinarian){
		veterinarianService.delete(veterinarian);
	} 



	public void update (VeterinarianDTO veterinarianDTO){
		Veterinarian veterinarian = findById(veterinarianDTO.getId());
		updateModel(veterinarian, veterinarianDTO);
		veterinarianService.update(veterinarian);
	}



	public Veterinarian findById(int id){
		return veterinarianService.findById(id);
	}



	public List<Veterinarian> findByCriteria(VeterinarianCriteria veterinarianCriteria){
		return veterinarianService.findByCriteria(veterinarianCriteria);
	}



	public Long getTotalRecords(VeterinarianCriteria veterinarianCriteria){
		return veterinarianService.getTotalRecords(veterinarianCriteria);
	}



	public List<Veterinarian> findAll(){
		return veterinarianService.findAll();
	}



	public void insert (VeterinarianDTO veterinarianDTO){
		Veterinarian veterinarian = toModel(veterinarianDTO);
		veterinarianService.insert(veterinarian);
	}



	public VeterinarianDTO toDTO(Veterinarian veterinarian){
		VeterinarianDTO veterinarianDTO = new VeterinarianDTO(); 	
		veterinarianDTO.setId(veterinarian.getId());
		veterinarianDTO.setFirstName(veterinarian.getFirstName());
		veterinarianDTO.setLastName(veterinarian.getLastName());
		return veterinarianDTO;
	}		



	public Veterinarian toModel(VeterinarianDTO veterinarianDTO){
		Veterinarian veterinarian = new Veterinarian(); 
		veterinarian.setId(veterinarianDTO.getId());
		veterinarian.setFirstName(veterinarianDTO.getFirstName());
		veterinarian.setLastName(veterinarianDTO.getLastName());
		return veterinarian;
	}	



	public void updateModel(Veterinarian veterinarian, VeterinarianDTO dto){
		veterinarian.setId(dto.getId());
		veterinarian.setFirstName(dto.getFirstName());
		veterinarian.setLastName(dto.getLastName());
	}
}
