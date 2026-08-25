package com.matlab.service;

import java.util.List;

import com.matlab.DTO.EmployeeDTO;
import com.matlab.response.EmployeeResponse;

public interface EmployeeService {
	EmployeeResponse getEmployees(
			int page,
			int limit,
			String employeeCode,
			String employeeName,
			String department,
			String status
			);
	List<EmployeeDTO> getEmployees();
}
