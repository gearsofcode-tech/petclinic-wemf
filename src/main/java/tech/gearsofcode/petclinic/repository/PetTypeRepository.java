package tech.gearsofcode.petclinic.repository;
import tech.gearsofcode.petclinic.domain.PetType;
import tech.gearsofcode.petclinic.web.dto.PetTypeCriteria;
import java.util.List;
public interface PetTypeRepository {
	void insert (PetType pettype);
	void delete (PetType pettype); 
	void update (PetType pettype);
	PetType findById(int id);
	List<PetType> findByCriteria(PetTypeCriteria criteria);
	Long getTotalRecords(PetTypeCriteria criteria);
	List<PetType> findAll();
}
