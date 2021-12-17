package com.gdu.cast.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.MainSelectCommentService;
import com.gdu.cast.service.MainSelectService;
import com.gdu.cast.vo.Experience;
import com.gdu.cast.vo.ExperienceSelect;
import com.gdu.cast.vo.ExperienceSelectComment;
import com.gdu.cast.vo.RoomSelect;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainSelectController {
	
	@Autowired MainSelectService mainSelectService;
	@Autowired MainSelectCommentService mainSelectCommentService;
	// 페이지
	private final int ROW_PER_PAGE = 10;
	private final int row_per_page = 5;
	
	// 여행 작가 체험 추천 상세보기 및 댓글 리스트 출력(페이징)
	@GetMapping("/mainExperienceSelectOne")
	public String experienceSelectOne(Model model, int experienceSelectId, @RequestParam(defaultValue = "1") int currentPage) {
		System.out.println(experienceSelectId + " <- experienceSelectId");
		ExperienceSelect experienceSelect = mainSelectService.getexperienceSelectOne(experienceSelectId);
		Map<String, Object> map = mainSelectCommentService.getexperienceSelectComment(currentPage, row_per_page,experienceSelectId);
		
		model.addAttribute("selectCommentList", map.get("selectCommentList"));
		
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("experienceSelect", experienceSelect);
		return "mainExperienceSelectOne";
	}
	
	// 메인 페이지의 숙소 추천 상세보기
	@GetMapping("/mainRoomSelectOne")
	public String roomSelectOne(Model model, int roomSelectId) {
		System.out.println(roomSelectId + "roomSelectId");
		RoomSelect roomSelect = mainSelectService.getroomSelectOne(roomSelectId);
		model.addAttribute("roomSelect", roomSelect);
		return "mainRoomSelectOne";
	}
	
	// 메인 페이지의 체험 추천 리스트
	@GetMapping("/mainExperienceSelect")
	public String experienceSelectList(Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String searchTitle) {
			// required = true -> 값이 안넘어오면 에러, required = false -> 안넘어오면 null
		Map<String, Object> map = mainSelectService.getSelectExperienceSelectList(searchTitle, currentPage, ROW_PER_PAGE);
		model.addAttribute("experienceSelectList", map.get("experienceSelectList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchTitle", searchTitle);
		System.out.println(model + "model");
		return "mainExperienceSelect";
	}
	
	// 메인 페이지의 숙소 추천 리스트
	@GetMapping("/mainRoomSelect")
	public String roomSelectList(Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String searchTitle) {
			// required = true -> 값이 안넘어오면 에러, required = false -> 안넘어오면 null
		Map<String, Object> map = mainSelectService.getSelectRoomSelectList(searchTitle, currentPage, ROW_PER_PAGE);
		model.addAttribute("roomSelectList", map.get("roomSelectList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchTitle", searchTitle);
		return "mainRoomSelect";
	}
	
	////메인 체험 상세보기 댓글 추가
	@GetMapping("/addMainExperienceSelectComment")
	public String getaddMainExperienceSelectComment(Model model,String customerId, int experienceSelectId, int currentPage) {
		model.addAttribute("customerId",customerId);
		model.addAttribute("experienceSelectId",experienceSelectId);
		model.addAttribute("currentPage",currentPage);
		return "addMainExperienceSelectComment";
	}
	
	//메인 체험 상세보기 댓글 추가
	@PostMapping("/addMainExperienceSelectComment")
	public String postaddMainExperienceSelectComment(Model model, ExperienceSelectComment experienceSelectComment) {
		System.out.println(experienceSelectComment.getCustomerId()+ "@#@#@#experienceSelectComment2#@#@#");
		mainSelectCommentService.getExperienceSelectInsertComment(experienceSelectComment);
		
		return "redirect:/mainExperienceSelectOne?experienceSelectId="+experienceSelectComment.experienceSelectId;
		
	}
	
	//메인 체험 댓글 update
	@GetMapping("/updateMainExperienceSelectComment")
	public String getupdateMainExperienceSelectComment(Model model,int experienceSelectCommentId, int currentPage, String customerId, int experienceSelectId) {
		model.addAttribute("experienceSelectCommentId", experienceSelectCommentId);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("customerId", customerId);
		model.addAttribute("experienceSelectId", experienceSelectId);
		return "updateMainExperienceSelectComment";
	}
	//메인 체험 댓글 update
	@PostMapping("/updateMainExperienceSelectComment")
	public String postUpdateMainExperienceSelectComment( int currentPage,ExperienceSelectComment experienceSelectComment) {
		System.out.println(experienceSelectComment.getExperienceSelectContent() + "@#!@#!@#!@#!@#content!@#");
		mainSelectCommentService.getExperienceSelectUpdatecomment(experienceSelectComment);
		
		return "redirect:/mainExperienceSelectOne?experienceSelectId=" + experienceSelectComment.experienceSelectId + "&currentPage="+currentPage;
		
	}
	// 메인 체험 댓글 삭제
	@GetMapping("/deleteMainExperienceSelectComment")
	public String deleteMainExperienceSelectComment(int currentPage,ExperienceSelectComment experienceSelectComment) {
		mainSelectCommentService.getExperienceSelectDeletecomment(experienceSelectComment);
		return "redirect:/mainExperienceSelectOne?experienceSelectId=" + experienceSelectComment.experienceSelectId + "&currentPage="+currentPage;
	}
	
}