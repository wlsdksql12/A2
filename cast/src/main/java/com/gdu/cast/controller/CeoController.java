package com.gdu.cast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.CeoService;
import com.gdu.cast.vo.Ceo;


@Controller
public class CeoController {
	@Autowired
		CeoService ceoService;
	
	// 사업체 추가시 호텔과 체험 선택
	@GetMapping("/ceo/selectExpHotel")
	public String selectExpHotel() {
		return "ceo/selectExpHotel";
	}
	
	// 사업가 내정보 보기
	@GetMapping("/ceo/selectCeo")
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
	@GetMapping("/ceo/updateCeo")
	public String getupdateCeo(Model model, Ceo ceo) {
		model.addAttribute("ceoId", ceo.getCeoId());
		model.addAttribute("ceoEmail", ceo.getCeoEmail());
		model.addAttribute("ceoPhonenum", ceo.getCeoPhonenum());
		model.addAttribute("ceoLicense", ceo.getCeoLicense());
		return "ceo/updateCeo";
	}
	
	@PostMapping("/ceo/updateCeo") 
	public String postupdateCeo(Ceo ceo) {
		ceoService.getupdateCeo(ceo);
		return "redirect:/selectCeo?ceoId="+ceo.getCeoId()+"&ceoEmail="+ceo.getCeoEmail();
	}
	
	// 비밀번호 수정
	@GetMapping("/ceo/updateCeoPw") 
	public String settingCeo(Ceo ceo) {
		return "ceo/updateCeoPw";
	}
	
	@PostMapping("/ceo/updateCeoPw")
	public String postUpdateCeoPw(HttpSession session, String ceoPw, String newCeoPw) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		ceoService.getUpdateCeoPw(ceoId, ceoPw, newCeoPw);
		return "redirect:/selectCeo?ceoId="+ceoId;
	}
}
