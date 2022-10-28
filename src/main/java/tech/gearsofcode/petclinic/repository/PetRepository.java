package tech.gearsofcode.petclinic.repository;
import tech.gearsofcode.petclinic.domain.Pet;
import tech.gearsofcode.petclinic.web.dto.PetCriteria;
import java.util.List;
public interface PetRepository {
	void insert (Pet pet);
	void delete (Pet pet); 
	void update (Pet pet);
	Pet findById(int id);
	List<Pet> findByCriteria(PetCriteria criteria);
	Long getTotalRecords(PetCriteria criteria);
	List<Pet> findAll();
}
