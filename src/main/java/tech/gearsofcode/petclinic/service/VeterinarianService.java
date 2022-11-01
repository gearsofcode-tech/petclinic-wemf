package tech.gearsofcode.petclinic.service;
import tech.gearsofcode.petclinic.domain.Veterinarian;
import tech.gearsofcode.petclinic.repository.VeterinarianRepository;
import tech.gearsofcode.petclinic.web.dto.VeterinarianCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional
@Component
public class VeterinarianService {
	@Autowired
	VeterinarianRepository veterinarianRepository;
	public void insert (Veterinarian veterinarian){
		veterinarianRepository.insert(veterinarian);
	}



	public void delete (Veterinarian veterinarian){
		veterinarianRepository.delete(veterinarian);
	} 



	public void update (Veterinarian veterinarian){
		veterinarianRepository.update(veterinarian);
	}



	public Veterinarian findById(int id){
		return veterinarianRepository.findById(id);
	}



	public List<Veterinarian> findByCriteria(VeterinarianCriteria veterinarianCriteria){
		return veterinarianRepository.findByCriteria(veterinarianCriteria);
	}



	public Long getTotalRecords(VeterinarianCriteria veterinarianCriteria){
		return veterinarianRepository.getTotalRecords(veterinarianCriteria);
	}



	public List<Veterinarian> findAll(){
		return veterinarianRepository.findAll();
	}
}
