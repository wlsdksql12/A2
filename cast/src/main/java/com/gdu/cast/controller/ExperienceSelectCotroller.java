package com.gdu.cast.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.ExperienceSelectService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExperienceSelectCotroller {
	@Autowired
	ExperienceSelectService experienceSelectService;
	
	// 페이지
	private final int ROW_PER_PAGE = 10;
	
	// 여행작가 숙소 추천 리스트
	@GetMapping("/experienceSelectList")
	public String roomSelectList(Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String searchTitle) {
			// required = true -> 값이 안넘어오면 에러, required = false -> 안넘어오면 null
		Map<String, Object> map = experienceSelectService.getSelectExperienceSelectList(searchTitle, currentPage, ROW_PER_PAGE);
		model.addAttribute("experienceSelectList", map.get("experienceSelectList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchTitle", searchTitle);
		System.out.println(model + "model");
		return "traveler/experienceSelectList";
	}
}
