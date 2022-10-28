package tech.gearsofcode.petclinic.repository;
import tech.gearsofcode.petclinic.domain.Specialty;
import tech.gearsofcode.petclinic.web.dto.SpecialtyCriteria;
import java.util.List;
public interface SpecialtyRepository {
	void insert (Specialty specialty);
	void delete (Specialty specialty); 
	void update (Specialty specialty);
	Specialty findById(int id);
	List<Specialty> findByCriteria(SpecialtyCriteria criteria);
	Long getTotalRecords(SpecialtyCriteria criteria);
	List<Specialty> findAll();
}
