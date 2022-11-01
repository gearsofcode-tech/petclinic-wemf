package tech.gearsofcode.petclinic.web.util;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
public class PagedResult<T> {
	private String operationDate;
	private String operationTime;
	private Long totalPages;
	private Long totalRecords;
	private Integer pageSize;
	private List<T> list;
	public PagedResult(Integer pageSize) {
		LocalDateTime now = LocalDateTime.now();
		operationDate = now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		operationTime = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		this.pageSize = pageSize;
	}



	public String getOperationDate() {
		return operationDate;
	}



	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}



	public String getOperationTime() {
		return operationTime;
	}



	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}



	public Long getTotalPages() {
		return totalPages;
	}



	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}



	public Long getTotalRecords() {
		return totalRecords;
	}



	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
		Long totalPages = (long) Math.ceil(totalRecords.doubleValue() / pageSize);
		if (totalPages < 1) {
			totalPages = 1l;
		}
	}



	public List<T> getList() {
		return list;
	}



	public void setList(List<T> list) {
		this.list = list;
	}
}
