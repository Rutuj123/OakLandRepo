package com.matlab.service;

import java.util.List;
import java.util.stream.Collectors;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.matlab.DTO.EmployeeDTO;
import com.matlab.entity.Employee;
import com.matlab.mapper.EmployeeMapper;

import com.matlab.response.EmployeeResponse;
import com.matlab.specification.EmployeeSpecification;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    
	
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public EmployeeResponse getEmployees(int page, int limit, String employeeCode, String employeeName,
			String department, String status) {
		int pageIndex=page-1;
		if(pageIndex<0) {
			pageIndex=0;
		}
		Session session=sessionFactory.openSession();
		StringBuilder hql=new StringBuilder("from Employee e where 1=1 ");
		StringBuilder countHql=new StringBuilder("select count(e) from Employee e where 1=1");
		if(employeeCode != null && !employeeCode.trim().isEmpty()) {
			hql.append("and lower(e.employeeCode) like :employeeCode ");
			countHql.append("and lower(e.employeeCode) like :employeeCode ");
		}
		if(employeeName !=null && !employeeName.trim().isEmpty()) {
			hql.append(" and lower(e.employeeName) like :employeeName ");
			countHql.append("and lower(e.employeeName) like :employeeName ");
		}
		if(department !=null && !department.trim().isEmpty()) {
			hql.append("and lower(e.department) like :department ");
			countHql.append("and lower(e.department) like :department ");
		}
		if(status !=null && !status.trim().isEmpty()) {
			hql.append("and lower(e.status) like :status ");
			countHql.append("and lower(e.status) like :status ");
		}
		hql.append("order by e.employeeName ");
		Query<Employee> query=session.createQuery(hql.toString(),Employee.class);
		Query<Long> countQuery=session.createQuery(countHql.toString(),Long.class);
		if(employeeCode!=null && !employeeCode.trim().isEmpty()) {
			String val="%"+employeeCode.toLowerCase().trim()+"%";
			query.setParameter("employeeCode", val);
			countQuery.setParameter("employeeCode", val);
		}
		if(employeeName!=null && !employeeName.trim().isEmpty()) {
			String val="%"+employeeName.toLowerCase()+"%";
			query.setParameter("employeeName", val);
			countQuery.setParameter("employeeName", val);
		}
		if(department !=null && !department.trim().isEmpty()) {
			String val="%"+department.toLowerCase()+"%";
			query.setParameter("department", val);
			countQuery.setParameter("department", val);
					
		}
		if(status!=null && !status.trim().isEmpty()) {
			String val="%"+status.toLowerCase()+"%";
			query.setParameter("status", val);
			countQuery.setParameter("status", val);
		}
		
		query.setFirstResult(pageIndex * limit);
		query.setMaxResults(limit);
		List<Employee> list=query.list();
		Long totalRecords=(Long)countQuery.uniqueResult();
		List<EmployeeDTO> employeeDTOList=list.stream()
				     .map(EmployeeMapper::convertToDTO)
				       .collect(Collectors.toList());
		EmployeeResponse resp=new EmployeeResponse();
		resp.setEmployees(employeeDTOList);
		resp.setTotalRecords(totalRecords);
		return resp;
	}

	@Override
	public List<EmployeeDTO> getEmployees() {
		Session ses=sessionFactory.openSession();
		List<Employee> list=ses.createQuery("from Employee",Employee.class).list();
		return list.stream().map(EmployeeMapper::convertToDTO).collect(Collectors.toList());
	}

}
