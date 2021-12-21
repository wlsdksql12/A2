package com.gdu.cast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.vo.ExperienceOrder;

@Controller
public class CustomerOrderController {
	
	@GetMapping("/addExperienceOrder")
	public String getaddOrder(HttpSession session, Model model, @RequestParam(defaultValue = "1") int experienceId) {
	System.out.println(experienceId + "EXID");
	String customerId = (String) session.getAttribute("loginCustomerId");
	model.addAttribute("experienceId",experienceId);
	model.addAttribute("customerId",customerId);
	
	return "addExperienceOrder";
	}
	
	@PostMapping("/addExperienceOrder")
	public String PostaddOrder(ExperienceOrder experienceOrder) {
		System.out.println(experienceOrder.toString() +"experienceOrder.toString()");
		return null;
		
	}
}
