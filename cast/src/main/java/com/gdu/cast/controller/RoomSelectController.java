package com.gdu.cast.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.RoomSelectService;
import com.gdu.cast.vo.AddRoomSelect;

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
	public String addRoomSelect(Model model, String travelerId, int hotelId, HttpSession session) {
		travelerId = (String)session.getAttribute("loginTravelerId");
		model.addAttribute("travelerId", travelerId);
		model.addAttribute("hotelId", hotelId);
		log.debug("★★★★Hyun★★★★"+travelerId);
		System.out.println("★★★★Hyun★★★★"+hotelId);
		return "traveler/addRoomSelect";
	}
	
	// 여행작가 숙소 추천 추가
	@PostMapping("/addRoomSelect")
	public String addExperienceSelect(AddRoomSelect addRoomSelect) {
		roomSelectService.addRoomSelect(addRoomSelect);
		log.debug("★★★★Hyun★★★★"+addRoomSelect.toString());
		return "redirect:/mainRoomSelect";
	}
	
	// 자신이 등록한 숙소 추천 리스트 출력
	@GetMapping("/roomSelectList")
	public String roomSelectList(Model model, 
			@RequestParam(defaultValue = "1") int currentPage, String travelerId) {
		log.debug("★★★★Hyun★★★★"+travelerId);
		Map<String, Object> map = roomSelectService.getSelectRoomSelectList(travelerId, currentPage, ROW_PER_PAGE);
		model.addAttribute("roomSelectList", map.get("roomSelectList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("travelerId", travelerId);
		log.debug("★★★★Hyun★★★★"+model.toString());
		return "traveler/roomSelectList";
	}
}
