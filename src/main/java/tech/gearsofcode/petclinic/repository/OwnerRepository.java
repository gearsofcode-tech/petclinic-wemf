package tech.gearsofcode.petclinic.repository;
import tech.gearsofcode.petclinic.domain.Owner;
import tech.gearsofcode.petclinic.web.dto.OwnerCriteria;
import java.util.List;
public interface OwnerRepository {
	void insert (Owner owner);
	void delete (Owner owner); 
	void update (Owner owner);
	Owner findById(int id);
	List<Owner> findByCriteria(OwnerCriteria criteria);
	Long getTotalRecords(OwnerCriteria criteria);
	List<Owner> findAll();
}
