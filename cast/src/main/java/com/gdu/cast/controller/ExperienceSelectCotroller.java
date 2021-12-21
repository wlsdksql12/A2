package com.gdu.cast.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.ExperienceSelectService;

@Controller
public class ExperienceSelectCotroller {
	@Autowired
	ExperienceSelectService experienceSelectService;
	
	// 페이지
	private final int ROW_PER_PAGE = 10;
	
	// 여행작가 체험 추천 추가
	@GetMapping("/addExperienceSelect")
	public String addExperienceSelect() {
		return "traveler/addExperienceSelect";
	}
	
	// 자신이 등록한 체험 추천 리스트 출력
	@GetMapping("/experienceSelectList")
	public String experienceSelectList(Model model,
			@RequestParam(defaultValue = "1") int currentPage, String travelerId) {
		Map<String, Object> map = experienceSelectService.getSelectExperienceSelectList(travelerId, currentPage, ROW_PER_PAGE);
		model.addAttribute("experienceSelectList", map.get("experienceSelectList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("travelerId", travelerId);
		System.out.println(model + "model");
		return "traveler/experienceSelectList";
	}
}
