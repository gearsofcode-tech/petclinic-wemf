package tech.gearsofcode.petclinic.service;
import tech.gearsofcode.petclinic.domain.PetType;
import tech.gearsofcode.petclinic.repository.PetTypeRepository;
import tech.gearsofcode.petclinic.web.dto.PetTypeCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional
@Component
public class PetTypeService {
	@Autowired
	PetTypeRepository petTypeRepository;
	public void insert (PetType petType){
		petTypeRepository.insert(petType);
	}



	public void delete (PetType petType){
		petTypeRepository.delete(petType);
	} 



	public void update (PetType petType){
		petTypeRepository.update(petType);
	}



	public PetType findById(int id){
		return petTypeRepository.findById(id);
	}



	public List<PetType> findByCriteria(PetTypeCriteria petTypeCriteria){
		return petTypeRepository.findByCriteria(petTypeCriteria);
	}



	public Long getTotalRecords(PetTypeCriteria petTypeCriteria){
		return petTypeRepository.getTotalRecords(petTypeCriteria);
	}



	public List<PetType> findAll(){
		return petTypeRepository.findAll();
	}
}
