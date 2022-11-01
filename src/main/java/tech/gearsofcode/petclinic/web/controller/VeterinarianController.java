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
import tech.gearsofcode.petclinic.domain.Veterinarian;
import tech.gearsofcode.petclinic.web.dto.VeterinarianDTO;
import tech.gearsofcode.petclinic.web.dto.VeterinarianCriteria;
import tech.gearsofcode.petclinic.facade.*;
import tech.gearsofcode.petclinic.web.util.PagedResult;
import tech.gearsofcode.petclinic.domain.Specialty;
import tech.gearsofcode.petclinic.web.dto.SpecialtyDTO;
import java.util.List;
@RestController
@RequestMapping("/veterinarian")
public class VeterinarianController {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private VeterinarianFacade veterinarianFacade;

	@GetMapping("/find-by-id/{id}")
	public VeterinarianDTO findById(@PathVariable int id ){
		Veterinarian veterinarian = veterinarianFacade.findById(id);
		VeterinarianDTO veterinarianDTO = veterinarianFacade.toDTO(veterinarian);
		return veterinarianDTO;
	}
	@GetMapping("/delete/{id}")
	public void delete(@PathVariable int id ){
		Veterinarian veterinarian = veterinarianFacade.findById(id);
		veterinarianFacade.delete(veterinarian);
	}
	@PostMapping("/insert")
	public void insert(@RequestBody VeterinarianDTO veterinarianDTO){
		veterinarianFacade.insert(veterinarianDTO);
	}
	@PostMapping("/update")
	public void update(@RequestBody VeterinarianDTO veterinarianDTO){
		veterinarianFacade.update(veterinarianDTO);
	}
	@PostMapping("/find")
	public PagedResult<VeterinarianDTO> search(@RequestBody VeterinarianCriteria veterinarianCriteria){
		PagedResult<VeterinarianDTO> result = new PagedResult<VeterinarianDTO>(veterinarianCriteria.getPageSize());
		if (veterinarianCriteria.getPage()==1) {
			Long totalRecords = veterinarianFacade.getTotalRecords(veterinarianCriteria);
			result.setTotalRecords(totalRecords);
		}
		List<Veterinarian> lst = veterinarianFacade.findByCriteria(veterinarianCriteria);
		result.setList(lst.stream().map(x -> veterinarianFacade.toDTO(x)).collect(Collectors.toList()));
		return result;
	}
}
