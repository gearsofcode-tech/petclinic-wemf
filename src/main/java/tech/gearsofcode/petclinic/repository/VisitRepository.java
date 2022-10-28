package tech.gearsofcode.petclinic.repository;
import tech.gearsofcode.petclinic.domain.Visit;
import tech.gearsofcode.petclinic.web.dto.VisitCriteria;
import java.util.List;
public interface VisitRepository {
	void insert (Visit visit);
	void delete (Visit visit); 
	void update (Visit visit);
	Visit findById(int id);
	List<Visit> findByCriteria(VisitCriteria criteria);
	Long getTotalRecords(VisitCriteria criteria);
	List<Visit> findAll();
}
