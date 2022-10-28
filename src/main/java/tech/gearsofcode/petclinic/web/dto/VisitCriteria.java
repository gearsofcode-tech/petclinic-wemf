package tech.gearsofcode.petclinic.web.dto;
public class VisitCriteria {
	private Integer pageSize;
	private Integer page;
	private String description;
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
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
