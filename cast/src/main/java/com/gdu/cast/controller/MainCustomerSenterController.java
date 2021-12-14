package com.gdu.cast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.cast.service.CustomerService;

@Controller
public class MainCustomerSenterController {
	@Autowired CustomerService customerService;
	
	@GetMapping("/mainQna")
	public String mainQnaList(Model model, int currentPage) {
		return null;
		
	}
	
	
}
