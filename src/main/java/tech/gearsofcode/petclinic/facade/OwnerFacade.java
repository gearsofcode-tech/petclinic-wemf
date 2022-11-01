package tech.gearsofcode.petclinic.facade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.gearsofcode.petclinic.domain.Owner;
import tech.gearsofcode.petclinic.domain.Pet;
import tech.gearsofcode.petclinic.web.dto.PetDTO;
import tech.gearsofcode.petclinic.service.OwnerService;
import tech.gearsofcode.petclinic.web.dto.OwnerCriteria;
import tech.gearsofcode.petclinic.web.dto.OwnerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
@Service
@Transactional
@Component
public class OwnerFacade {
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	@Autowired
	private OwnerService ownerService;

	@Autowired
	private PetFacade petFacade;
	public void delete (Owner owner){
		ownerService.delete(owner);
	} 



	public void update (OwnerDTO ownerDTO){
		Owner owner = findById(ownerDTO.getId());
		updateModel(owner, ownerDTO);
		ownerService.update(owner);
	}



	public Owner findById(int id){
		return ownerService.findById(id);
	}



	public List<Owner> findByCriteria(OwnerCriteria ownerCriteria){
		return ownerService.findByCriteria(ownerCriteria);
	}



	public Long getTotalRecords(OwnerCriteria ownerCriteria){
		return ownerService.getTotalRecords(ownerCriteria);
	}



	public List<Owner> findAll(){
		return ownerService.findAll();
	}



	public void insert (OwnerDTO ownerDTO){
		Owner owner = toModel(ownerDTO);
		ownerService.insert(owner);
	}



	public OwnerDTO toDTO(Owner owner){
		OwnerDTO ownerDTO = new OwnerDTO(); 	
		ownerDTO.setId(owner.getId());
		ownerDTO.setFirstName(owner.getFirstName());
		ownerDTO.setLastName(owner.getLastName());
		ownerDTO.setAddress(owner.getAddress());
		ownerDTO.setCity(owner.getCity());
		ownerDTO.setTelephone(owner.getTelephone());
		return ownerDTO;
	}		



	public Owner toModel(OwnerDTO ownerDTO){
		Owner owner = new Owner(); 
		owner.setId(ownerDTO.getId());
		owner.setFirstName(ownerDTO.getFirstName());
		owner.setLastName(ownerDTO.getLastName());
		owner.setAddress(ownerDTO.getAddress());
		owner.setCity(ownerDTO.getCity());
		owner.setTelephone(ownerDTO.getTelephone());
		return owner;
	}	



	public void updateModel(Owner owner, OwnerDTO dto){
		owner.setId(dto.getId());
		owner.setFirstName(dto.getFirstName());
		owner.setLastName(dto.getLastName());
		owner.setAddress(dto.getAddress());
		owner.setCity(dto.getCity());
		owner.setTelephone(dto.getTelephone());
	}
}
