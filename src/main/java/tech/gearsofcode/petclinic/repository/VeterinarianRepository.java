package tech.gearsofcode.petclinic.repository;
import tech.gearsofcode.petclinic.domain.Veterinarian;
import tech.gearsofcode.petclinic.web.dto.VeterinarianCriteria;
import java.util.List;
public interface VeterinarianRepository {
	void insert (Veterinarian veterinarian);
	void delete (Veterinarian veterinarian); 
	void update (Veterinarian veterinarian);
	Veterinarian findById(int id);
	List<Veterinarian> findByCriteria(VeterinarianCriteria criteria);
	Long getTotalRecords(VeterinarianCriteria criteria);
	List<Veterinarian> findAll();
}
