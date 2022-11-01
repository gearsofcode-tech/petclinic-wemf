package tech.gearsofcode.petclinic.service;
import tech.gearsofcode.petclinic.domain.Specialty;
import tech.gearsofcode.petclinic.repository.SpecialtyRepository;
import tech.gearsofcode.petclinic.web.dto.SpecialtyCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional
@Component
public class SpecialtyService {
	@Autowired
	SpecialtyRepository specialtyRepository;
	public void insert (Specialty specialty){
		specialtyRepository.insert(specialty);
	}



	public void delete (Specialty specialty){
		specialtyRepository.delete(specialty);
	} 



	public void update (Specialty specialty){
		specialtyRepository.update(specialty);
	}



	public Specialty findById(int id){
		return specialtyRepository.findById(id);
	}



	public List<Specialty> findByCriteria(SpecialtyCriteria specialtyCriteria){
		return specialtyRepository.findByCriteria(specialtyCriteria);
	}



	public Long getTotalRecords(SpecialtyCriteria specialtyCriteria){
		return specialtyRepository.getTotalRecords(specialtyCriteria);
	}



	public List<Specialty> findAll(){
		return specialtyRepository.findAll();
	}
}
