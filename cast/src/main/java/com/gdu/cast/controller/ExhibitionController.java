package com.gdu.cast.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.ExhibitionService;
import com.gdu.cast.vo.Exhibition;

@Controller
public class ExhibitionController {
	@Autowired
	ExhibitionService exhibitionService;
	
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
	
	// 전시소개 리스트 출력
	@GetMapping("/exhibitionList")
	public String exhibitionList(Model model, HttpSession session,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String searchTitle) {
			// required = true -> 값이 안넘어오면 에러, required = false -> 안넘어오면 null
		System.out.println(searchTitle);
		final int ROW_PER_PAGE = 10;
		Map<String, Object> map = exhibitionService.getExhibitionList(currentPage, ROW_PER_PAGE, searchTitle);
		System.out.println(session);
		System.out.println(session.getAttribute("loginAdminId"));
		model.addAttribute("exhibitionList", map.get("exhibitionList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchTitle", searchTitle);
		model.addAttribute("loginAdminId", session.getAttribute("loginAdminId"));
		System.out.println(session.getAttribute("loginAdminId") + " 전시소개 리스트 세션값");
		return "exhibitionList";
	}
	
	//전시소개 상세 페이지
	@GetMapping("/exhibitionOne")
	public String noticeOne(Model model, int exhibitionNo) {
		// 전시소개 글 번호 디버깅
		System.out.println(exhibitionNo);
		Exhibition exhibition = exhibitionService.getExhibitionOne(exhibitionNo);
		System.out.println(exhibition + " ExhibitionController");
		model.addAttribute("exhibition", exhibition);
		return"exhibitionOne";
	}
}
