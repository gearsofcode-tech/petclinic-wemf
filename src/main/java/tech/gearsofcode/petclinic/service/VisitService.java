package tech.gearsofcode.petclinic.service;
import tech.gearsofcode.petclinic.domain.Visit;
import tech.gearsofcode.petclinic.repository.VisitRepository;
import tech.gearsofcode.petclinic.web.dto.VisitCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional
@Component
public class VisitService {
	@Autowired
	VisitRepository visitRepository;
	public void insert (Visit visit){
		visitRepository.insert(visit);
	}



	public void delete (Visit visit){
		visitRepository.delete(visit);
	} 



	public void update (Visit visit){
		visitRepository.update(visit);
	}



	public Visit findById(int id){
		return visitRepository.findById(id);
	}



	public List<Visit> findByCriteria(VisitCriteria visitCriteria){
		return visitRepository.findByCriteria(visitCriteria);
	}



	public Long getTotalRecords(VisitCriteria visitCriteria){
		return visitRepository.getTotalRecords(visitCriteria);
	}



	public List<Visit> findAll(){
		return visitRepository.findAll();
	}
}
