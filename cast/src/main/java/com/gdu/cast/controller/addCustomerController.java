package com.gdu.cast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.CustomerService;
import com.gdu.cast.vo.Customer;

@Controller
public class addCustomerController {
	@Autowired CustomerService customerService;
	
	@GetMapping("/addCustomer")
	public String getaddCustomer(Customer customer) {
		return "addCustomer";
		
	}
	
	@PostMapping("/addCustomer")
	public String PostaddCustomer(Customer customer) {
		customerService.addCustomer(customer);
		return "redirect:/loginSelect";
	}
}
