package com.gdu.cast.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.ExperienceSelectService;
import com.gdu.cast.vo.ExperienceSelect;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	// 여행작가 체험 추천 삭제
	@GetMapping("/removeExperienceSelect")
	public String removeExperienceSelect(Model model, int experienceSelectId) {
		ExperienceSelect experienceSelect = experienceSelectService.getexperienceSelectOne(experienceSelectId);
		System.out.println(experienceSelectId+"<-- experienceSelectId");
		model.addAttribute("experienceSelect", experienceSelect);
		System.out.println(experienceSelect+"< -- experienceSelect");
		return "traveler/removeExperienceSelect";
	}
	
	// 여행작가 체험 추천 삭제
	@PostMapping("/removeExperienceSelect")
	public String removeExperienceSelect(ExperienceSelect experienceSelect) {
		experienceSelectService.removeExperienceSelect(experienceSelect);
		return "redirect:/experienceSelectList";
	}
	
	// 여행작가 체험 추천 수정
	@GetMapping("/modifyExperienceSelect")
	public String modifyExperienceSelect(Model model, int experienceSelectId) {
		ExperienceSelect experienceSelect = experienceSelectService.getexperienceSelectOne(experienceSelectId);
		model.addAttribute("experienceSelect", experienceSelect);
		return "traveler/modifyExperienceSelect";
	}
	
	// 여행작가 체험 추천 수정
	@PostMapping("/modifyExperienceSelect")
	public String modifyExperienceSelect(ExperienceSelect experienceSelect) {
		experienceSelectService.modifyExperienceSelect(experienceSelect);
		log.debug("★★★★Hyun★★★★"+experienceSelect.toString());
		return "redirect:/roomSelectOne?experienceSelectId="+experienceSelect.getExperienceId();
	}
	
	// 여행 작가 체험 추천 상세보기
	@GetMapping("/experienceSelectOne")
	public String experienceSelectOne(Model model, int experienceSelectId) {
		System.out.println(experienceSelectId + " <- experienceSelectId");
		ExperienceSelect experienceSelect = experienceSelectService.getexperienceSelectOne(experienceSelectId);
		model.addAttribute("experienceSelect", experienceSelect);
		return "traveler/experienceSelectOne";
	}
	
	// 여행작가 체험 추천 리스트
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
