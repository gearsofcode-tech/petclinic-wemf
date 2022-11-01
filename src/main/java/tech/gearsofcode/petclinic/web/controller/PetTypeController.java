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
import tech.gearsofcode.petclinic.domain.PetType;
import tech.gearsofcode.petclinic.web.dto.PetTypeDTO;
import tech.gearsofcode.petclinic.web.dto.PetTypeCriteria;
import tech.gearsofcode.petclinic.facade.*;
import tech.gearsofcode.petclinic.web.util.PagedResult;
@RestController
@RequestMapping("/pet-type")
public class PetTypeController {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private PetTypeFacade petTypeFacade;

	@GetMapping("/find-by-id/{id}")
	public PetTypeDTO findById(@PathVariable int id ){
		PetType petType = petTypeFacade.findById(id);
		PetTypeDTO petTypeDTO = petTypeFacade.toDTO(petType);
		return petTypeDTO;
	}
	@GetMapping("/delete/{id}")
	public void delete(@PathVariable int id ){
		PetType petType = petTypeFacade.findById(id);
		petTypeFacade.delete(petType);
	}
	@PostMapping("/insert")
	public void insert(@RequestBody PetTypeDTO petTypeDTO){
		petTypeFacade.insert(petTypeDTO);
	}
	@PostMapping("/update")
	public void update(@RequestBody PetTypeDTO petTypeDTO){
		petTypeFacade.update(petTypeDTO);
	}
	@PostMapping("/find")
	public PagedResult<PetTypeDTO> search(@RequestBody PetTypeCriteria petTypeCriteria){
		PagedResult<PetTypeDTO> result = new PagedResult<PetTypeDTO>(petTypeCriteria.getPageSize());
		if (petTypeCriteria.getPage()==1) {
			Long totalRecords = petTypeFacade.getTotalRecords(petTypeCriteria);
			result.setTotalRecords(totalRecords);
		}
		List<PetType> lst = petTypeFacade.findByCriteria(petTypeCriteria);
		result.setList(lst.stream().map(x -> petTypeFacade.toDTO(x)).collect(Collectors.toList()));
		return result;
	}
}
