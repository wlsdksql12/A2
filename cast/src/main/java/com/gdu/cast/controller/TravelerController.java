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
import com.gdu.cast.service.JoinRequestService;
import com.gdu.cast.service.RoomSelectService;
import com.gdu.cast.service.TravelerService;
import com.gdu.cast.vo.Traveler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TravelerController {
	
	@Autowired
	TravelerService travelerService;
	
	@Autowired
	RoomSelectService roomSelectService;
	
	@Autowired
	ExperienceSelectService experienceSelectService;
	
	// 12.15
	@Autowired
	JoinRequestService joinRequestService;
	
	// 페이지
	private final int ROW_PER_PAGE = 5;
	
	// 여행작가 메인 페이지 자신이 쓴 숙소/체험 추천 리스트 출력
	@GetMapping("/travelerIndex")
	public String SelectListMain(Model model,
			@RequestParam(defaultValue = "1") int currentPage, String travelerId) {
		log.debug(travelerId);
		
		// 숙소 리스트 출력
		Map<String, Object> roomMap = roomSelectService.getSelectRoomSelectList(travelerId, currentPage, ROW_PER_PAGE);
		model.addAttribute("roomSelectList", roomMap.get("roomSelectList"));
		model.addAttribute("startPage", roomMap.get("startPage"));
		model.addAttribute("lastPage", roomMap.get("lastPage"));
		model.addAttribute("totalPage", roomMap.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("travelerId", travelerId);
		
		// 체험 리스트 출력
		Map<String, Object> experienceMap = experienceSelectService.getSelectExperienceSelectList(travelerId, currentPage, ROW_PER_PAGE);
		model.addAttribute("experienceSelectList", experienceMap.get("experienceSelectList"));
		model.addAttribute("startPage", experienceMap.get("startPage"));
		model.addAttribute("lastPage", experienceMap.get("lastPage"));
		model.addAttribute("totalPage", experienceMap.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("travelerId", travelerId);
		
		System.out.println(model + "model");
		return "traveler/travelerIndex";
	}
	
	// 여행작가 내정보 수정
	@GetMapping("/modifyTravelerMyInfo")
	public String modifyTravelerMyInfo(Model model, HttpSession session, String travelerId) {
		travelerId = (String)session.getAttribute("loginTravelerId");
		Traveler traveler = travelerService.getTravelerMyInfo(travelerId);
		model.addAttribute("traveler", traveler);
		return "traveler/modifyTravelerMyInfo";
	}
	
	// 여행작가 내정보 수정
	@PostMapping("/modifyTravelerMyInfo")
	public String modifyTravelerMyInfo(Traveler traveler) {
		travelerService.modifyTravelerMyInfo(traveler);
		log.debug("★★★★Hyun★★★★"+traveler.toString()); 
		return "redirect:/modifyTravelerMyInfo?travelerId="+traveler.getTravelerId();
	}
	
	// 여행작가 프로필
	@GetMapping("/travelerMyInfo")
	public String getTravelerMyInfo(Model model, HttpSession session, String travelerId) {
		travelerId = (String)session.getAttribute("loginTravelerId");
		Traveler traveler = travelerService.getTravelerMyInfo(travelerId);
		model.addAttribute("traveler", traveler);
		return "traveler/travelerMyInfo";
	}
	
	/* 여행작가 메인 페이지
	@GetMapping("/travelerIndex")
	public String travelerIndex() {
		return "traveler/travelerIndex";
	} 
	*/
	// 여행작가 메인 버튼
	@GetMapping("/button")
	public String button() {
		return "traveler/button";
	}
	
	// 여행작가 로그아웃
	@GetMapping("/travelerLogout")
	public String travelerLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	
	// 여행작가 로그인
	@GetMapping("/travelerLogin")
	public String travelerLogin() {
		return "traveler/travelerLogin";
	}
	
	// 여행작가 로그인
	@PostMapping("/travelerLogin")
	public String travelerLogin(HttpSession session, Traveler traveler) {
		log.debug(traveler.getTravelerId());
		log.debug(traveler.getTravelerPw());
		Traveler loginTraveler = travelerService.getSelectTraveler(traveler);
		if(loginTraveler == null) {
			// login 실패!
			return "redirect:/travelerLogin";
		}
		session.setAttribute("loginTravelerId", loginTraveler.getTravelerId());
		log.debug((String) session.getAttribute("loginTravelerId"));
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
		
		// 여행작가 회원가입 시 여행작가 회원가입 요청 리스트에 추가
		joinRequestService.addTravelerJoinRequest(traveler.getTravelerId());
		
		return "redirect:/index";
	}
}
