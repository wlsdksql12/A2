package com.gdu.cast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.ExperienceService;
import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Experience;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExperienceController {
	@Autowired
	ExperienceService experienceService;
	
	@GetMapping("/insertExp")
	public String insertExp(Model model, int addressId) {
		
		model.addAttribute("addressId" , addressId);
		
		return "/ceo/insertExp";
	}
	
	@PostMapping("/insertExp")
	public String insertExp(HttpSession session, Experience experience) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		experience.setCeoId(ceoId);
		System.out.println(ceoId + " << ceoId");
		experienceService.insertExp(experience);
		
		log.debug("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+ceoId);
		log.debug("=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-"+experience.toString());
		
		return "/ceo/ceoIndex";
	}
	
	@GetMapping("/insertAddress")
	public String insertAddress() {
		return "/ceo/insertAddress";
	}
	
	@PostMapping("/insertAddress")
	public String insertAddress(HttpSession session, Address address, Experience experience) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		experience.setCeoId(ceoId);
		
		experienceService.insertAddress(address);
		
		return "redirect:/insertExp?addressId="+address.getAddressId() + "&ceoId=" + experience.getCeoId();
	}
}
