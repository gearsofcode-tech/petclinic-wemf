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
import tech.gearsofcode.petclinic.domain.Specialty;
import tech.gearsofcode.petclinic.web.dto.SpecialtyDTO;
import tech.gearsofcode.petclinic.web.dto.SpecialtyCriteria;
import tech.gearsofcode.petclinic.facade.*;
import tech.gearsofcode.petclinic.web.util.PagedResult;
@RestController
@RequestMapping("/specialty")
public class SpecialtyController {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private SpecialtyFacade specialtyFacade;

	@GetMapping("/find-by-id/{id}")
	public SpecialtyDTO findById(@PathVariable int id ){
		Specialty specialty = specialtyFacade.findById(id);
		SpecialtyDTO specialtyDTO = specialtyFacade.toDTO(specialty);
		return specialtyDTO;
	}
	@GetMapping("/delete/{id}")
	public void delete(@PathVariable int id ){
		Specialty specialty = specialtyFacade.findById(id);
		specialtyFacade.delete(specialty);
	}
	@PostMapping("/insert")
	public void insert(@RequestBody SpecialtyDTO specialtyDTO){
		specialtyFacade.insert(specialtyDTO);
	}
	@PostMapping("/update")
	public void update(@RequestBody SpecialtyDTO specialtyDTO){
		specialtyFacade.update(specialtyDTO);
	}
	@PostMapping("/find")
	public PagedResult<SpecialtyDTO> search(@RequestBody SpecialtyCriteria specialtyCriteria){
		PagedResult<SpecialtyDTO> result = new PagedResult<SpecialtyDTO>(specialtyCriteria.getPageSize());
		if (specialtyCriteria.getPage()==1) {
			Long totalRecords = specialtyFacade.getTotalRecords(specialtyCriteria);
			result.setTotalRecords(totalRecords);
		}
		List<Specialty> lst = specialtyFacade.findByCriteria(specialtyCriteria);
		result.setList(lst.stream().map(x -> specialtyFacade.toDTO(x)).collect(Collectors.toList()));
		return result;
	}
}
