package tech.gearsofcode.petclinic.web.controller;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.stream.Collectors;
import java.text.ParseException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tech.gearsofcode.petclinic.domain.Visit;
import tech.gearsofcode.petclinic.web.dto.VisitDTO;
import tech.gearsofcode.petclinic.web.dto.VisitCriteria;
import tech.gearsofcode.petclinic.facade.*;
import tech.gearsofcode.petclinic.web.util.PagedResult;
@RestController
@RequestMapping("/visit")
public class VisitController {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private VisitFacade visitFacade;

	@GetMapping("/find-by-id/{id}")
	public VisitDTO findById(@PathVariable int id ){
		Visit visit = visitFacade.findById(id);
		VisitDTO visitDTO = visitFacade.toDTO(visit);
		return visitDTO;
	}
	@GetMapping("/delete/{id}")
	public void delete(@PathVariable int id ){
		Visit visit = visitFacade.findById(id);
		visitFacade.delete(visit);
	}
	@PostMapping("/insert")
	public void insert(@RequestBody VisitDTO visitDTO){
		visitFacade.insert(visitDTO);
	}
	@PostMapping("/update")
	public void update(@RequestBody VisitDTO visitDTO){
		visitFacade.update(visitDTO);
	}
	@PostMapping("/find")
	public PagedResult<VisitDTO> search(@RequestBody VisitCriteria visitCriteria){
		PagedResult<VisitDTO> result = new PagedResult<VisitDTO>(visitCriteria.getPageSize());
		if (visitCriteria.getPage()==1) {
			Long totalRecords = visitFacade.getTotalRecords(visitCriteria);
			result.setTotalRecords(totalRecords);
		}
		List<Visit> lst = visitFacade.findByCriteria(visitCriteria);
		result.setList(lst.stream().map(x -> visitFacade.toDTO(x)).collect(Collectors.toList()));
		return result;
	}
}
