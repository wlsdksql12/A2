package com.gdu.cast.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.MemberListService;

@Controller
public class MemberListController {
	@Autowired
	MemberListService memberListService;
	
	// 각 페이지 화면에 보일 갯수
	final int ROW_PER_PAGE = 10;
	
	// 고객 리스트 출력
	@GetMapping("/admin/customerList")
	public String customerList(Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String searchTitle) {
		// 페이지 수, 검색어 디버깅
		System.out.println(currentPage + " <-----MemberListController");
		System.out.println(searchTitle + " <-----MemberListController");
		
		// 고객 리스트 가져오기
		Map<String, Object> map = memberListService.getCustomerList(currentPage, ROW_PER_PAGE, searchTitle);
		System.out.print(map.get("customerList") + " <-----MemberListController");
		
		// 고객 리스트 페이지에 리턴 값
		model.addAttribute("customerList", map.get("customerList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchTitle", searchTitle);
		return"admin/customerList";
	}
	
	// 고객 리스트에서 비활성화 버튼 클릭 시 
	@GetMapping("/admin/customerDisable")
	public String customerDisable(String customerId) {
		memberListService.updateActiveZeroDate(customerId);
		return"redirect:/admin/customerList";
	}
	
	// 고객 리스트에서 활성화 버튼 클릭 시
	@GetMapping("/admin/customerActive")
	public String customerActive(String customerId) {
		memberListService.updateActiveOneDate(customerId);
		return"redirect:/admin/customerList";
	}
	
	// 사업자 리스트 출력
	@GetMapping("/admin/ceoList")
	public String ceoList(Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String searchTitle) {
		// 페이지 수, 검색어 디버깅
		System.out.println(currentPage + " <-----MemberListController");
		System.out.println(searchTitle + " <-----MemberListController");

		// 사업자 리스트 가져오기
		Map<String, Object> map = memberListService.getCeoList(currentPage, ROW_PER_PAGE, searchTitle);
		System.out.print(map.get("ceoList") + " <-----MemberListController");
		
		// 사업자 리스트 페이지에 리턴 값
		model.addAttribute("ceoList", map.get("ceoList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchTitle", searchTitle);
		return"admin/ceoList";
	}
	
	// 사업자 리스트 출력
	@GetMapping("/admin/travelerList")
	public String travelerList(Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String searchTitle) {
		// 페이지 수, 검색어 디버깅
		System.out.println(currentPage + " <-----MemberListController");
		System.out.println(searchTitle + " <-----MemberListController");

		// 여행작가 리스트 가져오기
		Map<String, Object> map = memberListService.getTravelerList(currentPage, ROW_PER_PAGE, searchTitle);
		System.out.print(map.get("ceoList") + " <-----MemberListController");
		System.out.println(map.get("startPage") + " <-----MemberListController");
		System.out.println(map.get("lastPage") + " <-----MemberListController");
		System.out.println(map.get("totalPage") + " <-----MemberListController");
		// 사업자 리스트 페이지에 리턴 값
		model.addAttribute("travelerList", map.get("travelerList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchTitle", searchTitle);
		return"admin/travelerList";
	}
}
