package com.gdu.cast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.CeoService;
import com.gdu.cast.vo.Ceo;

@Controller
public class LoginCeoController {
	@Autowired
	CeoService ceoService;
	
	// 사업자 메인 페이지
	@GetMapping("/ceo/ceoIndex")
	public String ceoIndex() {
		return "ceo/ceoIndex";
	}
	
	// 로그인 페이지
	@GetMapping("/ceoLogin")
	public String ceoLogin() {
		return "ceo/ceoLogin";
	}
	
	// 로그인 페이지
	@PostMapping("/ceoLogin")
	public String loginCeo(HttpSession session, Ceo ceo) {
		Ceo loginCeo = ceoService.loginCeo(ceo);
		
		if(loginCeo == null) {
		return "redirect:/ceoLogin";
		}
		
		session.setAttribute("loginCeoId", loginCeo.getCeoId());
		
		return "redirect:/ceoIndex";
	}
	
	// 로그아웃
	@GetMapping("/ceoLogout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/loginSelect";
	}
}
