package com.matlab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matlab.response.EmployeeResponse;
import com.matlab.service.EmployeeService;

@RestController
public class EmployeeController {
	
	public EmployeeController() {
	    System.out.println("EmployeeController created");
	}
	@Autowired
	EmployeeService employeeService; 
	@GetMapping("/employees/list")
	public ResponseEntity<EmployeeResponse> getEmployees(
	        @RequestParam(defaultValue = "0") int start,
	        @RequestParam(defaultValue = "15") int limit,
	        @RequestParam(required = false) String employeeCode,
	        @RequestParam(required = false) String employeeName,
	        @RequestParam(required = false) String department,
	        @RequestParam(required = false) String status) {

		System.out.println("in get employees method...");
	    int page = start / limit;
	    return ResponseEntity.ok(
	            employeeService.getEmployees(page, limit, employeeCode, employeeName, department, status)
	    );
	}
}
