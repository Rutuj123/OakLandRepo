package com.matlab.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.matlab.entity.PersonPrefix;
import com.matlab.repository.PersonPrefixRepository;
import com.matlab.util.ExcelHelper;

@Service
@Transactional
public class PersonPrefixService {
	@Autowired
	private SessionFactory sessionFactory; 
	
	public Map<String, Object> saveExcel(MultipartFile file){
		 Map<String, Object> response = new HashMap<>();
		 try {
		List<PersonPrefix> prefixList= ExcelHelper.excelToPrefix(file.getInputStream());
		Session ses=sessionFactory.openSession();
		for(int i=0;i<prefixList.size();i++) {
			ses.save(prefixList.get(i));
		}
		response.put("inserted", prefixList.size());
	     }catch (Exception e) {
			 e.printStackTrace();
			   response.put("errors", "Error While Uploading file");
		}
	        return response;
	}
	 public List<PersonPrefix> getAllUsers() {
		 Session ses=sessionFactory.openSession();
		
	        return ses.createQuery("from PersonPrefix", PersonPrefix.class).list();
	    }
}
