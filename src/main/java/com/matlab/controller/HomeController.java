package com.matlab.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

@GetMapping("/home")	
public String home() {
	System.out.println("in controller..");
return "home";
}

@GetMapping("/tab/index")	
public String index() {
	System.out.println("in index..");
	Optional<String> opt=Optional.ofNullable(null);
	String t=opt.orElse("hjhj");
	return "index";
}


@GetMapping("/tab/xlsUpload")	
public String xlsUpload() {
	System.out.println("in xlsUpload..");
	return "file";
}
}
