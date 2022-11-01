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
import tech.gearsofcode.petclinic.domain.Pet;
import tech.gearsofcode.petclinic.web.dto.PetDTO;
import tech.gearsofcode.petclinic.web.dto.PetCriteria;
import tech.gearsofcode.petclinic.facade.*;
import tech.gearsofcode.petclinic.web.util.PagedResult;
import tech.gearsofcode.petclinic.domain.PetType;
import tech.gearsofcode.petclinic.web.dto.PetTypeDTO;
import tech.gearsofcode.petclinic.domain.Visit;
import tech.gearsofcode.petclinic.web.dto.VisitDTO;
import java.util.List;
@RestController
@RequestMapping("/pet")
public class PetController {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private PetFacade petFacade;

	@GetMapping("/find-by-id/{id}")
	public PetDTO findById(@PathVariable int id ){
		Pet pet = petFacade.findById(id);
		PetDTO petDTO = petFacade.toDTO(pet);
		return petDTO;
	}
	@GetMapping("/delete/{id}")
	public void delete(@PathVariable int id ){
		Pet pet = petFacade.findById(id);
		petFacade.delete(pet);
	}
	@PostMapping("/insert")
	public void insert(@RequestBody PetDTO petDTO){
		petFacade.insert(petDTO);
	}
	@PostMapping("/update")
	public void update(@RequestBody PetDTO petDTO){
		petFacade.update(petDTO);
	}
	@PostMapping("/find")
	public PagedResult<PetDTO> search(@RequestBody PetCriteria petCriteria){
		PagedResult<PetDTO> result = new PagedResult<PetDTO>(petCriteria.getPageSize());
		if (petCriteria.getPage()==1) {
			Long totalRecords = petFacade.getTotalRecords(petCriteria);
			result.setTotalRecords(totalRecords);
		}
		List<Pet> lst = petFacade.findByCriteria(petCriteria);
		result.setList(lst.stream().map(x -> petFacade.toDTO(x)).collect(Collectors.toList()));
		return result;
	}
}
