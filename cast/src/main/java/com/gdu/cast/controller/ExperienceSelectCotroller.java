package com.gdu.cast.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.ExperienceSelectService;
import com.gdu.cast.vo.AddExperienceSelect;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExperienceSelectCotroller {
	@Autowired
	ExperienceSelectService experienceSelectService;
	
	// 페이지
	private final int ROW_PER_PAGE = 5;
	
	// 여행작가 체험 추천 추가
	@GetMapping("/addExperienceSelect")
	public String addExperienceSelect(Model model, String travelerId, int experienceId, HttpSession session) {
		travelerId = (String)session.getAttribute("loginTravelerId");
		model.addAttribute("travelerId", travelerId);
		model.addAttribute("experienceId", experienceId);
		log.debug("★★★★Hyun★★★★"+travelerId);
		System.out.println("★★★★Hyun★★★★"+experienceId);
		return "traveler/addExperienceSelect";
	}
	
	// 여행작가 체험 추천 추가
	@PostMapping("/addExperienceSelect")
	public String addExperienceSelect(AddExperienceSelect addexperienceSelect) {
		experienceSelectService.addExperienceSelect(addexperienceSelect);
		log.debug("★★★★Hyun★★★★"+addexperienceSelect.toString());
		return "redirect:/mainExperienceSelect";
	}
	
	// 자신이 등록한 체험 추천 리스트 출력
	@GetMapping("/experienceSelectList")
	public String experienceSelectList(Model model,
			@RequestParam(defaultValue = "1") int currentPage, String travelerId) {
		log.debug("★★★★Hyun★★★★"+travelerId);
		Map<String, Object> map = experienceSelectService.getSelectExperienceSelectList(travelerId, currentPage, ROW_PER_PAGE);
		model.addAttribute("experienceSelectList", map.get("experienceSelectList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("travelerId", travelerId);
		log.debug("★★★★Hyun★★★★"+model.toString());
		return "traveler/experienceSelectList";
	}
}
