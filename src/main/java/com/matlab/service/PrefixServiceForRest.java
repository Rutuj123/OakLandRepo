package com.matlab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.matlab.DTO.PersonPrefixDto;

@Service
public class PrefixServiceForRest {
	@Autowired
	RestTemplate restTemplate;	
	
	public String createPrefix(PersonPrefixDto dto) {
		try {
		HttpHeaders headers=new HttpHeaders();
		//PersonPrefixDto prefix=new PersonPrefixDto();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<PersonPrefixDto> entity=new HttpEntity<>(dto,headers);
		String url="http://localhost:8081/api/prefix";
		restTemplate.postForObject(url, entity, String.class);
		System.out.println("after rest api call is done");
        return "prefix created successfully";
		}catch (Exception e) {
			 return "Faile to create Prefix";
		}
	}
}
