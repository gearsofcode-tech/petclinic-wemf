package tech.gearsofcode.petclinic.facade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.gearsofcode.petclinic.domain.Visit;
import tech.gearsofcode.petclinic.service.VisitService;
import tech.gearsofcode.petclinic.web.dto.VisitCriteria;
import tech.gearsofcode.petclinic.web.dto.VisitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
@Service
@Transactional
@Component
public class VisitFacade {
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	@Autowired
	private VisitService visitService;
	public void delete (Visit visit){
		visitService.delete(visit);
	} 



	public void update (VisitDTO visitDTO){
		Visit visit = findById(visitDTO.getId());
		updateModel(visit, visitDTO);
		visitService.update(visit);
	}



	public Visit findById(int id){
		return visitService.findById(id);
	}



	public List<Visit> findByCriteria(VisitCriteria visitCriteria){
		return visitService.findByCriteria(visitCriteria);
	}



	public Long getTotalRecords(VisitCriteria visitCriteria){
		return visitService.getTotalRecords(visitCriteria);
	}



	public List<Visit> findAll(){
		return visitService.findAll();
	}



	public void insert (VisitDTO visitDTO){
		Visit visit = toModel(visitDTO);
		visitService.insert(visit);
	}



	public VisitDTO toDTO(Visit visit){
		VisitDTO visitDTO = new VisitDTO(); 	
		visitDTO.setId(visit.getId());
		if (visit.getDate()!=null){
			visitDTO.setDate(sdf.format(visit.getDate()));
		}
		visitDTO.setDescription(visit.getDescription());
		return visitDTO;
	}		



	public Visit toModel(VisitDTO visitDTO){
		Visit visit = new Visit(); 
		visit.setId(visitDTO.getId());
		if (visitDTO.getDate()!=null){
			try{
			visit.setDate(sdf.parse(visitDTO.getDate()));
			}
			catch (ParseException e) {
				throw new IllegalArgumentException(String.format("Invalid date format for attribute '%s'.", "date"), e);
			}
		}
		visit.setDescription(visitDTO.getDescription());
		return visit;
	}	



	public void updateModel(Visit visit, VisitDTO dto){
		visit.setId(dto.getId());
		if (visit.getDate()!=null){
			try{
			visit.setDate(sdf.parse(dto.getDate()));
			}
			catch (ParseException e) {
				throw new IllegalArgumentException(String.format("Valor de data inválida para o atributo '%s'.", "date"), e);
			}
		}
		visit.setDescription(dto.getDescription());
	}
}
