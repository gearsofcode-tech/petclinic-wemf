package tech.gearsofcode.petclinic.web.dto;
public class PetTypeCriteria {
	private Integer pageSize;
	private Integer page;
	private String name;
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getPageSize(){
		return pageSize;
	} 



	public void setPageSize(Integer size){
		this.pageSize = size;
	}



	public Integer getPage(){
		return page;
	}



	public void setPage(Integer page){
		this.page = page;
	}	
}
