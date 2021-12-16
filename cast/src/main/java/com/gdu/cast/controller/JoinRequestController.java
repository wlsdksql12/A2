package com.gdu.cast.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.JoinRequestService;

@Controller
public class JoinRequestController {
	@Autowired
	JoinRequestService joinRequestService;
	
	private final int ROW_PER_PAGE = 10;
	
	// 여행작가 가입 요청 리스트
	@GetMapping("/admin/travelerJoinRequestList")
	public String travelerJoinRequestList(Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String state) {
		// 페이지 수, 검색어 디버깅
		System.out.println(currentPage + " <-----JoinRequestController");
		System.out.println(state + " <-----JoinRequestController");
		
		// 여행작가 가입 요청 가져오기
		Map<String, Object> map = joinRequestService.getTravelerJoinRequestList(currentPage, ROW_PER_PAGE, state);
		System.out.print(map.get("joinTravelerList") + " <-----JoinRequestController");
		
		// 여행작가 가입 요청에 리턴 값
		model.addAttribute("joinTravelerList", map.get("joinTravelerList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("state", state);
		
		return"/admin/travelerJoinRequestList";	
	}
}
