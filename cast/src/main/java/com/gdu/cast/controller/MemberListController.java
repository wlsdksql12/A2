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
	
	// 고객 리스트 출력
	@GetMapping("/admin/customerList")
	public String customerList(Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String searchTitle) {
		System.out.println(currentPage + " <-----MemberListController");
		System.out.println(searchTitle + " <-----MemberListController");
		final int ROW_PER_PAGE = 10;
		Map<String, Object> map = memberListService.getCustomerList(currentPage, ROW_PER_PAGE, searchTitle);
		System.out.print(map.get("customerList") + " <-----MemberListController");
		
		model.addAttribute("customerList", map.get("customerList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchTitle", searchTitle);
		return"admin/customerList";
	}
	
	// 사업자 리스트 출력
	@GetMapping("/admin/ceoList")
	public String ceoList(Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String searchTitle) {
		System.out.println(currentPage + " <-----MemberListController");
		System.out.println(searchTitle + " <-----MemberListController");
		final int ROW_PER_PAGE = 10;
		Map<String, Object> map = memberListService.getCeoList(currentPage, ROW_PER_PAGE, searchTitle);
		System.out.print(map.get("ceoList") + " <-----MemberListController");
		
		model.addAttribute("ceoList", map.get("ceoList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchTitle", searchTitle);
		return"admin/ceoList";
	}
}
