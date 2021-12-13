package com.gdu.cast.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/insertExpAddress")
	public String insertAddress() {
		return "/ceo/insertExpAddress";
	}
	
	@PostMapping("/insertExpAddress")
	public String insertAddress(HttpSession session, Address address, Experience experience) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		experience.setCeoId(ceoId);
		
		experienceService.insertExpAddress(address);
		
		return "redirect:/insertExp?addressId="+address.getAddressId() + "&ceoId=" + experience.getCeoId();
	}
	
	@GetMapping("/experienceList")
	public String noticeList(Model model, HttpSession session,
			@RequestParam(defaultValue = "1") int currentPage) {
		final int ROW_PER_PAGE = 10;
		Map<String, Object> map = experienceService.getExperienceList(currentPage, ROW_PER_PAGE);
		System.out.println(session);
		System.out.println(session.getAttribute("loginCeoId"));
		model.addAttribute("experienceList", map.get("experienceList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("loginCeoId", session.getAttribute("loginCeoId"));
		System.out.println(session.getAttribute("loginCeoId") + " 공지사항리스트 세션값");
		return "experienceList";
	}
}
