package com.gdu.cast.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.RoomSelectService;
import com.gdu.cast.vo.RoomSelect;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RoomSelectController {
	
	@Autowired
	RoomSelectService roomSelectService;
	
	// 페이지
	private final int ROW_PER_PAGE = 10;
	
	// 여행작가 숙소 추천 추가
	@GetMapping("/addRoomSelect")
	public String addRoomSelect() {
		return "traveler/addRoomSelect";
	}
	
	// 여행작가 숙소 추천 삭제
	@GetMapping("/removeRoomSelect")
	public String removeRoomSelect(Model model, int roomSelectId, String travelerId) {
		RoomSelect roomSelect = roomSelectService.getroomSelectOne(roomSelectId, travelerId);
		model.addAttribute("roomSelect", roomSelect);
		return "traveler/removeRoomSelect";
	}
	
	// 여행작가 숙소 추천 삭제
	@PostMapping("/removeRoomSelect")
	public String removeRoomSelect(RoomSelect roomSelect) {
		roomSelectService.removeRoomSelect(roomSelect);
		return "redirect:/roomSelectList";
	}
	
	// 여행작가 숙소 추천 수정
	@GetMapping("/modifyRoomSelect")
	public String modifyRoomSelect(Model model, int roomSelectId, String travelerId) {
		RoomSelect roomSelect = roomSelectService.getroomSelectOne(roomSelectId, travelerId);
		model.addAttribute("roomSelect", roomSelect);
		return "traveler/modifyRoomSelect";
	}
	
	// 자신이 등록한 숙소 추천 수정
	@PostMapping("/modifyRoomSelect")
	public String modifyRoomSelect(RoomSelect roomSelect) {
		roomSelectService.modifyRoomSelect(roomSelect);
		log.debug("★★★★Hyun★★★★"+roomSelect.toString());
		return "redirect:/roomSelectOne?travelerId="+roomSelect.getTravelerId()+"&roomSelectId="+roomSelect.getRoomSelectId();
	}
	
	// 자신이 등록한 숙소 추천 상세보기
	@GetMapping("/roomSelectOne")
	public String roomSelectOne(Model model, int roomSelectId, String travelerId) {
		System.out.println(roomSelectId + "roomSelectId");
		System.out.println(travelerId + "travelerId");
		RoomSelect roomSelect = roomSelectService.getroomSelectOne(roomSelectId, travelerId);
		model.addAttribute("roomSelect", roomSelect);
		return "traveler/roomSelectOne";
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
