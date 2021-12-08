package com.gdu.cast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
	
	@GetMapping("/customerIndex")
	public String shopsingle() {
		return "customerIndex";
	}
}
