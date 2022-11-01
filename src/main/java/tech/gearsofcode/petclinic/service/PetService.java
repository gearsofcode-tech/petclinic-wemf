package tech.gearsofcode.petclinic.service;
import tech.gearsofcode.petclinic.domain.Pet;
import tech.gearsofcode.petclinic.repository.PetRepository;
import tech.gearsofcode.petclinic.web.dto.PetCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional
@Component
public class PetService {
	@Autowired
	PetRepository petRepository;
	public void insert (Pet pet){
		petRepository.insert(pet);
	}



	public void delete (Pet pet){
		petRepository.delete(pet);
	} 



	public void update (Pet pet){
		petRepository.update(pet);
	}



	public Pet findById(int id){
		return petRepository.findById(id);
	}



	public List<Pet> findByCriteria(PetCriteria petCriteria){
		return petRepository.findByCriteria(petCriteria);
	}



	public Long getTotalRecords(PetCriteria petCriteria){
		return petRepository.getTotalRecords(petCriteria);
	}



	public List<Pet> findAll(){
		return petRepository.findAll();
	}
}
