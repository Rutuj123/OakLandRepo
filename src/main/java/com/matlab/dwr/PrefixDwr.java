package com.matlab.dwr;

import java.util.List;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.matlab.entity.PersonPrefix;
import com.matlab.service.PrefixService;

@Component("prefixDwr")
@RemoteProxy
public class PrefixDwr {

@Autowired	
private PrefixService prefixService;

@RemoteMethod
public String savePrefix(String prefix,String gender,String prefixOf) {
	PersonPrefix p=new PersonPrefix();
	p.setPrefix(prefix);
	p.setGender(gender);
	p.setPrefixOf(prefixOf);
	prefixService.save(p);
	return "prefix saved successfully..";
}

@RemoteMethod
public List<PersonPrefix> listPersonPrefix(){
	return prefixService.getAllPrefix();
}

@RemoteMethod
public String deletePersonPrefix(Long id){
	 prefixService.delete(id);
	 return "deleted successfulyy";
	}
}
