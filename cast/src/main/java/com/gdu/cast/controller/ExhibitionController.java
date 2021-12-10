package com.gdu.cast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.ExhibitionService;
import com.gdu.cast.vo.Exhibition;

@Controller
public class ExhibitionController {
	@Autowired
	ExhibitionService exhibitionService;
	
	@GetMapping("/exhibitionList")
	public String exhibitionList() {
		return "exhibitionList";
	}
	
	// 전시소개 작성 페이지
	@GetMapping("/admin/addExhibition")
	public String addExhibition() {
		return "admin/addExhibition";
	}
	
	// 전시소개 작성 후
	@PostMapping("/admin/addExhibition")
	public String addExhibition(HttpSession session,Exhibition exhibition) {
		// session에 adminId 추출
		String adminId = (String) session.getAttribute("loginAdminId");
		// 추출한 adminId를 exhibition vo에 추가
		exhibition.setAdminId(adminId);
		// 디버깅
		System.out.println(exhibition);
		exhibitionService.addExhibition(exhibition);
		
		return "redirect:/exhibitionList";
	}
}
