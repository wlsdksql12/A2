package com.gdu.cast.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.JoinRequestService;
import com.gdu.cast.vo.JoinCeo;
import com.gdu.cast.vo.JoinTraveler;
import com.gdu.cast.vo.Notice;
import com.gdu.cast.vo.Traveler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class JoinRequestController {
	@Autowired
	JoinRequestService joinRequestService;
	
	private final int ROW_PER_PAGE = 10;
	
	// 여행작가 가입 요청 리스트
	@GetMapping("/admin/travelerJoinRequestList")
	public String travelerJoinRequestList(Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String state,
			@RequestParam(required = false) String searchTitle) {
		// 페이지 수, 검색어 디버깅
		System.out.println(currentPage + " <-----JoinRequestController");
		System.out.println(state + " <-----JoinRequestController");
		System.out.println(searchTitle + " <-----JoinRequestController");
		// 여행작가 가입 요청 가져오기
		Map<String, Object> map = joinRequestService.getTravelerJoinRequestList(currentPage, ROW_PER_PAGE, state, searchTitle);
		System.out.print(map.get("joinTravelerList") + " <-----JoinRequestController");
		
		// 여행작가 가입 요청에 리턴 값
		model.addAttribute("joinTravelerList", map.get("joinTravelerList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("state", state);
		model.addAttribute("searchTitle", searchTitle);
		
		return"/admin/travelerJoinRequestList";	
	}
	
	// 여행작가 가입 리스트에서 상세보기
	@GetMapping("/admin/travelerSelectOne")
	public String getTravelerOne(Model model, int joinTravelerId) {
		System.out.println(joinTravelerId + " <-----JoinRequestController");
		JoinTraveler joinTraveler = joinRequestService.getTravelerOne(joinTravelerId);
		log.debug(joinTraveler.toString());
		model.addAttribute("joinTraveler",joinTraveler);
		return"/admin/travelerSelectOne";
	}
	
	// 여행작가 상세보기에서 가입 승인 시
	@GetMapping("/admin/updateTravelerJoinRequest")
	public String updateTravelerJoinRequest(int joinTravelerId,String adminId, String state) {
		// 디버깅
		System.out.println(joinTravelerId + " <-----JoinRequestController");
		System.out.println(adminId + " <-----JoinRequestController");
		System.out.println(state + " <-----JoinRequestController");
		joinRequestService.updateTravelerJoinRequest(joinTravelerId, adminId, state);
		return"redirect:/admin/travelerJoinRequestList";
	}
	
	// 가입 요청 중이면 보여지는 페이지 이동
	@GetMapping("/requesting")
	public String requesting(int result) {
		System.out.println(result + " <-----JoinRequestController");
		if(result == 1) {
			return"joinRequesting";
		}
		return"joinRequestCancel";
	}

	//---------------------사업자------------------------
	
	// 사업자 가입 요청 리스트
	@GetMapping("/admin/ceoJoinRequestList")
	public String ceoJoinRequestList(Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String state,
			@RequestParam(required = false) String searchTitle) {
		// 페이지 수, 검색어 디버깅
		System.out.println(currentPage + " <-----JoinRequestController");
		System.out.println(state + " <-----JoinRequestController");
		System.out.println(searchTitle + " <-----JoinRequestController");
		// 사업자 가입 요청 가져오기
		Map<String, Object> map = joinRequestService.getCeoJoinRequestList(currentPage, ROW_PER_PAGE, state, searchTitle);
		System.out.print(map.get("joinCeoList") + " <-----JoinRequestController");
		
		// 사업자 가입 요청페이지 리턴 값
		model.addAttribute("joinCeoList", map.get("joinCeoList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("state", state);
		model.addAttribute("searchTitle", searchTitle);
		
		return"/admin/ceoJoinRequestList";	
	}
	
	// 사업자 가입 리스트에서 상세보기
	@GetMapping("/admin/ceoSelectOne")
	public String getCeoOne(Model model, int joinCeoId) {
		System.out.println(joinCeoId + " <-----JoinRequestController");
		JoinCeo joinCeo = joinRequestService.getCeoOne(joinCeoId);
		log.debug(joinCeo.toString());
		model.addAttribute("joinCeo",joinCeo);
		return"/admin/ceoSelectOne";
	}
	
	// 사업자 상세보기에서 가입 승인 시
	@GetMapping("/admin/updateCeoJoinRequest")
	public String updateCeoJoinRequest(int joinCeoId,String adminId, String state) {
		// 디버깅
		System.out.println(joinCeoId + " <-----JoinRequestController");
		System.out.println(adminId + " <-----JoinRequestController");
		System.out.println(state + " <-----JoinRequestController");
		joinRequestService.updateCeoJoinRequest(joinCeoId, adminId, state);
		return"redirect:/admin/ceoJoinRequestList";
	}
	
	// 사업자 가입 재요청
	@GetMapping("/ceo/ceoReJoinRequest")
	public String ceoReJoinRequest(HttpSession session, String ceoId){
		// 가입 재요청
		joinRequestService.addCeoJoinRequest(ceoId);
		return "redirect:/ceo/ceoIndex?ceoId="+ceoId;
	}
}
