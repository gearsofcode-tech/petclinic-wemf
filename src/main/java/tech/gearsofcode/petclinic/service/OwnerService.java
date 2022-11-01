package tech.gearsofcode.petclinic.service;
import tech.gearsofcode.petclinic.domain.Owner;
import tech.gearsofcode.petclinic.repository.OwnerRepository;
import tech.gearsofcode.petclinic.web.dto.OwnerCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional
@Component
public class OwnerService {
	@Autowired
	OwnerRepository ownerRepository;
	public void insert (Owner owner){
		ownerRepository.insert(owner);
	}



	public void delete (Owner owner){
		ownerRepository.delete(owner);
	} 



	public void update (Owner owner){
		ownerRepository.update(owner);
	}



	public Owner findById(int id){
		return ownerRepository.findById(id);
	}



	public List<Owner> findByCriteria(OwnerCriteria ownerCriteria){
		return ownerRepository.findByCriteria(ownerCriteria);
	}



	public Long getTotalRecords(OwnerCriteria ownerCriteria){
		return ownerRepository.getTotalRecords(ownerCriteria);
	}



	public List<Owner> findAll(){
		return ownerRepository.findAll();
	}
}
