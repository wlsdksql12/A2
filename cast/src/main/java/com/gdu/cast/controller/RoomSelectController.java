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
	public String removeRoomSelect(Model model, int roomSelectId) {
		RoomSelect roomSelect = roomSelectService.getroomSelectOne(roomSelectId);
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
	public String modifyRoomSelect(Model model, int roomSelectId) {
		RoomSelect roomSelect = roomSelectService.getroomSelectOne(roomSelectId);
		model.addAttribute("roomSelect", roomSelect);
		return "traveler/modifyRoomSelect";
	}
	
	// 여행작가 숙소 추천 수정
	@PostMapping("/modifyRoomSelect")
	public String modifyRoomSelect(RoomSelect roomSelect) {
		roomSelectService.modifyRoomSelect(roomSelect);
		log.debug("★★★★Hyun★★★★"+roomSelect.toString());
		return "redirect:/roomSelectOne?roomSelectId="+roomSelect.getRoomSelectId();
	}
	
	// 여행 작가 숙소 추천 상세보기
	@GetMapping("/roomSelectOne")
	public String roomSelectOne(Model model, int roomSelectId) {
		System.out.println(roomSelectId + "roomSelectId");
		RoomSelect roomSelect = roomSelectService.getroomSelectOne(roomSelectId);
		model.addAttribute("roomSelect", roomSelect);
		return "traveler/roomSelectOne";
	}
	
	// 여행작가 숙소 추천 리스트
	@GetMapping("/roomSelectList")
	public String roomSelectList(Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String searchTitle) {
			// required = true -> 값이 안넘어오면 에러, required = false -> 안넘어오면 null
		Map<String, Object> map = roomSelectService.getselectRoomSelectList(searchTitle, currentPage, ROW_PER_PAGE);
		model.addAttribute("roomSelectList", map.get("roomSelectList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchTitle", searchTitle);
		return "traveler/roomSelectList";
	}
}
