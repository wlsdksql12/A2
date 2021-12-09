package com.gdu.cast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerSignUpController {
	
	@GetMapping("/customersingup")
	public String getCustomerSignUp() {
		return "signUp";
	}
	
	@PostMapping("/customersingup")
	public String postCustomerSignUp() {
		return null;
		
	}
	
}
