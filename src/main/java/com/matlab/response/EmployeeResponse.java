package com.matlab.response;

import java.util.List;

import com.matlab.DTO.EmployeeDTO;

public class EmployeeResponse {
	public EmployeeResponse() {
    }
private List<EmployeeDTO> employees;
private Long totalRecords;
public List<EmployeeDTO> getEmployees(){
	return employees;
}

public void setEmployees(List<EmployeeDTO> employees) {
	this.employees=employees;
}

public Long getTotalRecords() {
	return totalRecords;
}

public void setTotalRecords(Long totalRecords) {
	this.totalRecords=totalRecords;
}
}
