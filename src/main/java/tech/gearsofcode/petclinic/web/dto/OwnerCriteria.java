package tech.gearsofcode.petclinic.web.dto;
public class OwnerCriteria {
	private Integer pageSize;
	private Integer page;
	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
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
