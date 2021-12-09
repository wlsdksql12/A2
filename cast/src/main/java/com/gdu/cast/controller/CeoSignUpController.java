package com.gdu.cast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CeoSignUpController {
	
	@GetMapping("/ceosingup")
	public String getCustomerSignUp() {
		return "signUp";
	}
}