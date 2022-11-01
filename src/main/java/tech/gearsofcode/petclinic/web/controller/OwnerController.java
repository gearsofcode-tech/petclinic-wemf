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
import tech.gearsofcode.petclinic.domain.Owner;
import tech.gearsofcode.petclinic.web.dto.OwnerDTO;
import tech.gearsofcode.petclinic.web.dto.OwnerCriteria;
import tech.gearsofcode.petclinic.facade.*;
import tech.gearsofcode.petclinic.web.util.PagedResult;
import tech.gearsofcode.petclinic.domain.Pet;
import tech.gearsofcode.petclinic.web.dto.PetDTO;
import java.util.List;
@RestController
@RequestMapping("/owner")
public class OwnerController {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private OwnerFacade ownerFacade;

	@GetMapping("/find-by-id/{id}")
	public OwnerDTO findById(@PathVariable int id ){
		Owner owner = ownerFacade.findById(id);
		OwnerDTO ownerDTO = ownerFacade.toDTO(owner);
		return ownerDTO;
	}
	@GetMapping("/delete/{id}")
	public void delete(@PathVariable int id ){
		Owner owner = ownerFacade.findById(id);
		ownerFacade.delete(owner);
	}
	@PostMapping("/insert")
	public void insert(@RequestBody OwnerDTO ownerDTO){
		ownerFacade.insert(ownerDTO);
	}
	@PostMapping("/update")
	public void update(@RequestBody OwnerDTO ownerDTO){
		ownerFacade.update(ownerDTO);
	}
	@PostMapping("/find")
	public PagedResult<OwnerDTO> search(@RequestBody OwnerCriteria ownerCriteria){
		PagedResult<OwnerDTO> result = new PagedResult<OwnerDTO>(ownerCriteria.getPageSize());
		if (ownerCriteria.getPage()==1) {
			Long totalRecords = ownerFacade.getTotalRecords(ownerCriteria);
			result.setTotalRecords(totalRecords);
		}
		List<Owner> lst = ownerFacade.findByCriteria(ownerCriteria);
		result.setList(lst.stream().map(x -> ownerFacade.toDTO(x)).collect(Collectors.toList()));
		return result;
	}
}
