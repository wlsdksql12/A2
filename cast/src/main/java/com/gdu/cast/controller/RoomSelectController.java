package com.gdu.cast.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.RoomSelectService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RoomSelectController {
	
	@Autowired
	RoomSelectService roomSelectService;
	
	// 페이지
	private final int ROW_PER_PAGE = 5;
	
	// 여행작가 숙소 추천 추가
	@GetMapping("/addRoomSelect")
	public String addRoomSelect() {
		return "traveler/addRoomSelect";
	}
	
	// 자신이 등록한 숙소 추천 리스트 출력
	@GetMapping("/roomSelectList")
	public String roomSelectList(Model model, 
			@RequestParam(defaultValue = "1") int currentPage, String travelerId) {
		log.debug(travelerId);
		Map<String, Object> map = roomSelectService.getSelectRoomSelectList(travelerId, currentPage, ROW_PER_PAGE);
		model.addAttribute("roomSelectList", map.get("roomSelectList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("travelerId", travelerId);
		System.out.println(model + "model");
		return "traveler/roomSelectList";
	}
}
