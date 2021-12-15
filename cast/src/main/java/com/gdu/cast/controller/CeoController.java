package com.gdu.cast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.CeoService;
import com.gdu.cast.vo.Ceo;

import lombok.extern.slf4j.Slf4j;

@Controller
public class CeoController {
	@Autowired
		CeoService ceoService;
	
	@GetMapping("/selectExpHotel")
	public String selectExpHotel() {
		return "ceo/selectExpHotel";
	}
	
	// 사업가 내정보 보기
	@GetMapping("/selectCeo")
	public String selectCeo(Model model, HttpSession session) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		Ceo ceo = ceoService.getselectCeo(ceoId);
		model.addAttribute("ceoId", ceo.getCeoId());
		model.addAttribute("ceoName", ceo.getCeoName());
		model.addAttribute("ceoEmail", ceo.getCeoEmail());
		model.addAttribute("ceoPhonenum", ceo.getCeoPhonenum());
		model.addAttribute("ceoLicense", ceo.getCeoLicense());
		model.addAttribute("createDate", ceo.getCreateDate());
		
		return "ceo/selectCeo";
	}

	// 사업가 내정보 수정
	@GetMapping("/updateCeo")
	public String getupdateCeo(Model model, String ceoId) {
		model.addAttribute("ceoId", ceoId);
		return "ceo/updateCeo";
	}
	
	@PostMapping("/updateCeo") 
	public String postupdateCeo(Ceo ceo) {
		ceoService.getupdateCeo(ceo);
		return "redirect:/selectCeo?ceoId="+ceo.getCeoId()+"&ceoEmail="+ceo.getCeoEmail();
	}
}
