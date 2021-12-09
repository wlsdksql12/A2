package com.gdu.cast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.CeoService;
import com.gdu.cast.vo.Ceo;

@Controller
public class addCeoController {
@Autowired CeoService ceoService;

	@GetMapping("/addCeo")
	public String getaddCustomer(Ceo ceo) {
		return "addCeo";
		
	}
	
	@PostMapping("/addCeo")
	public String PostaddCustomer(Ceo ceo) {
		ceoService.addCeo(ceo);
		return "redirect:/loginSelect";
	}
}
