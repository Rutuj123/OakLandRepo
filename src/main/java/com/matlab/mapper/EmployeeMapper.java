package com.matlab.mapper;

import com.matlab.DTO.EmployeeDTO;
import com.matlab.entity.Employee;

public class EmployeeMapper {

public static EmployeeDTO convertToDTO(Employee employee) {
	EmployeeDTO dto=new EmployeeDTO();
	 dto.setId(employee.getId());
	    dto.setEmployeeCode(employee.getEmployeeCode());
	    dto.setEmployeeName(employee.getEmployeeName());
	    dto.setUserType(employee.getUserType());
	    dto.setPhone(employee.getPhone());
	    dto.setDepartment(employee.getDepartment());
	    dto.setStatus(employee.getStatus());
	    dto.setJoiningDate(employee.getJoiningDate());
	    return dto;
}	
}
