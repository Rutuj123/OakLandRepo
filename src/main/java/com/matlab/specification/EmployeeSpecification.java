package com.matlab.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

//import org.springframework.data.jpa.domain.Specification;

import com.matlab.entity.Employee;

public class EmployeeSpecification {
	/*
	 * public static Specification<Employee> filterEmployyes(String employeeCode,
	 * String employeeName, String department, String status){ return
	 * (root,query,cb)->{ List<Predicate> predicates=new ArrayList<Predicate>();
	 * if(employeeCode!=null && !employeeCode.isEmpty()) {
	 * predicates.add(cb.like(cb.lower(root.get("employeeCode")),"%"+
	 * employeeCode.toLowerCase()+"%")); } if(employeeName !=null &&
	 * !employeeName.isEmpty()) {
	 * predicates.add(cb.like(cb.lower(root.get("employeeName")),"%"+employeeName.
	 * toLowerCase()+"%")); } if(department!=null && !department.isEmpty()) {
	 * predicates.add(cb.like(cb.lower(root.get("department")),"%"+department.
	 * toLowerCase()+"%")); } if(status!=null && !status.isEmpty()) {
	 * predicates.add(cb.like(cb.lower(root.get("status")),
	 * "%"+status.toLowerCase()+"%")); } return cb.and(predicates.toArray(new
	 * Predicate[0])); }; }
	 */
}
