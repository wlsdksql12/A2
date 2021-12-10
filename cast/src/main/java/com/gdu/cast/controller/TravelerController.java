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
import com.gdu.cast.vo.RoomSelect;
import com.gdu.cast.vo.Traveler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TravelerController {
	@Autowired
	TravelerService travelerService;
	
	private final int ROW_PER_PAGE = 10;
	
	// 여행작가 숙소 추천 추가
	@GetMapping("/addRoomSelect")
	public String addRoomSelect() {
		return "traveler/addRoomSelect";
	}
	
	// 여행작가 숙소 추천 삭제
	@GetMapping("/removeRoomSelect")
	public String removeRoomSelect(Model model, int RoomSelectId) {
		RoomSelect roomSelect = travelerService.getroomSelectOne(RoomSelectId);
		model.addAttribute("roomSelect", roomSelect);
		return "traveler/removeRoomSelect";
	}
	
	@PostMapping("/removeRoomSelect")
	public String removeRoomSelect(RoomSelect roomSelect) {
		travelerService.removeRoomSelect(roomSelect);
		return "redirect:/roomSelectList?travelerId="+roomSelect.getTravelerId()+"&currentPage=1";
	}
	
	// 여행작가 숙소 추천 수정
	@GetMapping("/modifyRoomSelect")
	public String modifyRoomSelect(Model model, int roomSelectId) {
		RoomSelect roomSelect = travelerService.getroomSelectOne(roomSelectId);
		model.addAttribute("roomSelect", roomSelect);
		return "traveler/modifyRoomSelect";
	}
	
	// 여행작가 숙소 추천 수정
	@PostMapping("/modifyRoomSelect")
	public String modifyRoomSelect(RoomSelect roomSelect) {
		travelerService.modifyRoomSelect(roomSelect);
		log.debug("★★★★Hyun★★★★"+roomSelect.toString());
		return "redirect:/roomSelectOne?roomSelectId="+roomSelect.getRoomSelectId()+"&travelerId="+roomSelect.getTravelerId();
	}
	
	// 여행 작가 숙소 추천 상세보기
	@GetMapping("/roomSelectOne")
	public String roomSelectOne(Model model, int roomSelectId) {
		System.out.println(roomSelectId + "roomSelectId");
		RoomSelect roomSelect = travelerService.getroomSelectOne(roomSelectId);
		model.addAttribute("roomSelect", roomSelect);
		return "traveler/roomSelectOne";
	}
	
	// 여행작가 숙소 추천 리스트
	@GetMapping("/roomSelectList")
	public String roomSelectList(Model model,
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
