package tech.gearsofcode.petclinic.facade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.gearsofcode.petclinic.domain.Pet;
import tech.gearsofcode.petclinic.domain.PetType;
import tech.gearsofcode.petclinic.web.dto.PetTypeDTO;
import tech.gearsofcode.petclinic.domain.Visit;
import tech.gearsofcode.petclinic.web.dto.VisitDTO;
import tech.gearsofcode.petclinic.service.PetService;
import tech.gearsofcode.petclinic.web.dto.PetCriteria;
import tech.gearsofcode.petclinic.web.dto.PetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
@Service
@Transactional
@Component
public class PetFacade {
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	@Autowired
	private PetService petService;

	@Autowired
	private PetTypeFacade petTypeFacade;

	@Autowired
	private VisitFacade visitFacade;
	public void delete (Pet pet){
		petService.delete(pet);
	} 



	public void update (PetDTO petDTO){
		Pet pet = findById(petDTO.getId());
		updateModel(pet, petDTO);
		petService.update(pet);
	}



	public Pet findById(int id){
		return petService.findById(id);
	}



	public List<Pet> findByCriteria(PetCriteria petCriteria){
		return petService.findByCriteria(petCriteria);
	}



	public Long getTotalRecords(PetCriteria petCriteria){
		return petService.getTotalRecords(petCriteria);
	}



	public List<Pet> findAll(){
		return petService.findAll();
	}



	public void insert (PetDTO petDTO){
		Pet pet = toModel(petDTO);
		petService.insert(pet);
	}



	public PetDTO toDTO(Pet pet){
		PetDTO petDTO = new PetDTO(); 	
		petDTO.setId(pet.getId());
		petDTO.setName(pet.getName());
		if (pet.getBirthDate()!=null){
			petDTO.setBirthDate(sdf.format(pet.getBirthDate()));
		}
		PetType type =  pet.getType();
		if (type != null){
			PetTypeDTO typeDTO = petTypeFacade.toDTO(type);
			petDTO.setType(typeDTO);
		}
		return petDTO;
	}		



	public Pet toModel(PetDTO petDTO){
		Pet pet = new Pet(); 
		pet.setId(petDTO.getId());
		pet.setName(petDTO.getName());
		if (petDTO.getBirthDate()!=null){
			try{
			pet.setBirthDate(sdf.parse(petDTO.getBirthDate()));
			}
			catch (ParseException e) {
				throw new IllegalArgumentException(String.format("Invalid date format for attribute '%s'.", "birthDate"), e);
			}
		}
		PetTypeDTO typeDTO = petDTO.getType();
		if (typeDTO !=null){
			pet.setType(petTypeFacade.findById(typeDTO.getId()));
		}
		return pet;
	}	



	public void updateModel(Pet pet, PetDTO dto){
		pet.setId(dto.getId());
		pet.setName(dto.getName());
		if (pet.getBirthDate()!=null){
			try{
			pet.setBirthDate(sdf.parse(dto.getBirthDate()));
			}
			catch (ParseException e) {
				throw new IllegalArgumentException(String.format("Valor de data inv�lida para o atributo '%s'.", "birthDate"), e);
			}
		}
		PetTypeDTO typeDTO = dto.getType(); 
	}
}
