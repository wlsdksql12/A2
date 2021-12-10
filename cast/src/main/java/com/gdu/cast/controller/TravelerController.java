package com.gdu.cast.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.TravelerService;
import com.gdu.cast.vo.Traveler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TravelerController {
	@Autowired
	TravelerService travelerService;
	
	private final int ROW_PER_PAGE = 10;
	
	// 여행작가 숙소 추천 리스트
	@GetMapping("/roomSelectList")
	public String noticeList(Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String searchTitle) {
			// required = true -> 값이 안넘어오면 에러, required = false -> 안넘어오면 null
		Map<String, Object> map = travelerService.getselectRoomSelectList(searchTitle, currentPage, ROW_PER_PAGE);
		model.addAttribute("roomSelectList", map.get("roomSelectList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchTitle", searchTitle);
		return "traveler/roomSelectList";
	}
	
	// 여행작가 페이지 템플릿
	@GetMapping("/travelerIndex")
	public String travelerIndex() {
		return "traveler/travelerIndex";
	}
	// 여행작가 로그인
	@GetMapping("/travelerLogin")
	public String login() {
		return "traveler/travelerLogin";
	}
	
	// 여행작가 로그인
	@PostMapping("/travelerLogin")
	public String login(HttpSession session, Traveler traveler) {
		log.debug(traveler.getTravelerId());
		log.debug(traveler.getTravelerPw());
		Traveler loginTraveler = travelerService.getSelectTraveler(traveler);
		if(loginTraveler == null) {
			// login 실패!
			return "redirect:/travelerLogin";
		}
		session.setAttribute("loginTraveler", loginTraveler);
		log.debug((String) session.getAttribute("loginTravelerId"));
		return "redirect:/travelerIndex";
	}
	
	// 여행작가 로그아웃
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/index";
	}
	
	// 여행작가 회원가입
	@GetMapping("/addTraveler")
	public String addTraveler() {
		return "traveler/addTraveler";
	}
	
	// 여행작가 회원가입
	@PostMapping("/addTraveler")
	public String addBoard(Traveler traveler) {
		travelerService.addTraveler(traveler);
		log.debug("★★★★Hyun★★★★"+traveler.toString());
		return "redirect:/travelerIndex";
	}
}
