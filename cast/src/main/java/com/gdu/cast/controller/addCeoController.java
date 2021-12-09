package com.gdu.cast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.cast.mapper.CeoMapper;
import com.gdu.cast.vo.Ceo;
import com.gdu.cast.vo.Customer;

@RestController
@Controller
public class addCeoController {
@Autowired CeoMapper ceoMapper;

	@GetMapping("/addCeo")
	public String getaddCustomer(Ceo ceo) {
		return "addCeo";
		
	}
	
	@PostMapping("/addCeo")
	public String PostaddCustomer(Ceo ceo) {
		ceoService.addCustomer(ceo);
		return "loginSelect";
	}
}
