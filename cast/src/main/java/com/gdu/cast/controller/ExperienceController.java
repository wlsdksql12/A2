package com.gdu.cast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.ExperienceService;
import com.gdu.cast.vo.Experience;

@Controller
public class ExperienceController {
	@Autowired
	ExperienceService experienceService;
	
	@GetMapping("/insertExp")
	public String insertExp() {
		
		return "/ceo/insertExp";
	}
	
	@PostMapping("/insertExp")
	public String insertExp(HttpSession session, Experience experience) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		experience.setCeoId(ceoId);
		System.out.println(ceoId + " << ceoId");
		experienceService.insertExp(experience);
		
		return "redirect:/ceoIndex";
	}
}
