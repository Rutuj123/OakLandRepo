package com.matlab.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matlab.entity.PersonPrefix;
import com.matlab.repository.PrefixRepository;
@Service("prefixService")
@Transactional
public class PrefixService {
	 @Autowired
	    private PrefixRepository prefixRepository;

	    public String test() {
	        return "DWR Working";
	    }

	    public void save(PersonPrefix prefix) {
	        prefixRepository.save(prefix);
	    }

	    public List<PersonPrefix> getAllPrefix() {
	        return prefixRepository.getAllPrefix();
	    }

	    public void delete(Long id) {
	        prefixRepository.delete(id);
	    }
}
