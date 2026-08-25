package com.matlab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.matlab.DTO.PersonPrefixDto;
import com.matlab.service.PersonPrefixService;
import com.matlab.service.PrefixServiceForRest;

@RestController
@RequestMapping("/api/prefix")
@CrossOrigin(origins="*")
public class PrefixController {

@Autowired	
PrefixServiceForRest prefixServiceForRest;	
@Autowired
PersonPrefixService personPrefixService;

public String savePrefixToRest(@RequestBody PersonPrefixDto personPrefixDto) {
	return prefixServiceForRest.createPrefix(personPrefixDto);
}

@PostMapping("/upload-excel")
public ResponseEntity<?> uploadExcel(@RequestParam("file") MultipartFile file) throws Exception {
	System.out.println("in upload-excel..");
    return ResponseEntity.ok(personPrefixService.saveExcel(file));
}

@GetMapping
public ResponseEntity<?> getUsers() {
    return ResponseEntity.ok(personPrefixService.getAllUsers());
}
}
