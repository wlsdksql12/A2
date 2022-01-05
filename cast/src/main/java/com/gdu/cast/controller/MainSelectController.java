package com.gdu.cast.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.MainSelectCommentService;
import com.gdu.cast.service.MainSelectService;
import com.gdu.cast.vo.ExperienceSelect;
import com.gdu.cast.vo.ExperienceSelectComment;
import com.gdu.cast.vo.ExperienceSelectImage;
import com.gdu.cast.vo.RoomSelect;
import com.gdu.cast.vo.RoomSelectComment;
import com.gdu.cast.vo.RoomSelectImage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainSelectController {
	
	@Autowired MainSelectService mainSelectService;
	@Autowired MainSelectCommentService mainSelectCommentService;
	
	// 페이지
	private final int ROW_PER_PAGE = 10;
	private final int row_per_page = 5;
	
	
	// 여행작가 체험 추천 삭제
	@GetMapping("/removeExperienceSelect")
	public String removeExperienceSelect(ExperienceSelect experienceSelect) {
		mainSelectService.removeExperienceSelect(experienceSelect);
		return "redirect:/mainExperienceSelect";
	}
	
	// 여행작가 숙소 추천 삭제
	@GetMapping("/removeRoomSelect")
	public String removeRoomSelect(RoomSelect roomSelect) {
		mainSelectService.removeRoomSelect(roomSelect);
		return "redirect:/mainRoomSelect";
	}
	
	// 여행작가 체험 추천 수정
	@GetMapping("/modifyExperienceSelect")
	public String modifyExperienceSelect(Model model, int experienceSelectId, String travelerId, HttpSession session) {
		travelerId = (String)session.getAttribute("loginTravelerId");
		ExperienceSelect experienceSelect = mainSelectService.getexperienceSelectOne(experienceSelectId);
		model.addAttribute("experienceSelect", experienceSelect);
		return "traveler/modifyExperienceSelect";
	}
	
	// 여행작가 체험 추천 수정
	@PostMapping("/modifyExperienceSelect")
	public String modifyExperienceSelect(ExperienceSelect experienceSelect) {
		mainSelectService.modifyExperienceSelect(experienceSelect);
		log.debug("★★★★Hyun★★★★"+experienceSelect.toString());
		return "redirect:/mainExperienceSelectOne?experienceSelectId="+experienceSelect.getExperienceSelectId();
	}
	
	// 여행작가 숙소 추천 수정
	@GetMapping("/modifyRoomSelect")
	public String modifyRoomSelect(Model model, int roomSelectId, String travelerId, HttpSession session) {
		travelerId = (String)session.getAttribute("loginTravelerId");
		RoomSelect roomSelect = mainSelectService.getroomSelectOne(roomSelectId);
		model.addAttribute("roomSelect", roomSelect);
		return "traveler/modifyRoomSelect";
	}
	
	// 여행작가 숙소 추천 수정
	@PostMapping("/modifyRoomSelect")
	public String modifyRoomSelect(RoomSelect roomSelect) {
		mainSelectService.modifyRoomSelect(roomSelect);
		log.debug("★★★★Hyun★★★★"+roomSelect.toString());
		return "redirect:/mainRoomSelectOne?roomSelectId="+roomSelect.getRoomSelectId();
	}
	
	// 여행 작가 체험 추천 상세보기 및 댓글 리스트 출력(페이징)
	@GetMapping("/mainExperienceSelectOne")
	public String experienceSelectOne(Model model, int experienceSelectId, @RequestParam(defaultValue = "1") int currentPage) {
		System.out.println(experienceSelectId + " <- experienceSelectId");
		ExperienceSelect experienceSelect = mainSelectService.getexperienceSelectOne(experienceSelectId);
		List<ExperienceSelectImage> experienceSelectImageList = mainSelectService.getselectExperienceSelectImageList(experienceSelectId);
		Map<String, Object> map = mainSelectCommentService.getexperienceSelectComment(currentPage, row_per_page,experienceSelectId);
		
		model.addAttribute("experienceSelectImageList", experienceSelectImageList);
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
	public String roomSelectOne(Model model, int roomSelectId , @RequestParam(defaultValue = "1") int currentPage) {
		System.out.println(roomSelectId + "roomSelectId");
		RoomSelect roomSelect = mainSelectService.getroomSelectOne(roomSelectId);
		
		Map<String, Object> list = mainSelectCommentService.getroomSelectComment(currentPage, row_per_page, roomSelectId);
		List<RoomSelectImage> roomSelectImageList = mainSelectService.getselectRoomSelectImageList(roomSelectId);
		
		model.addAttribute("roomSelectImageList", roomSelectImageList);
		model.addAttribute("selectCommentList", list.get("selectCommentList"));
		model.addAttribute("startPage", list.get("startPage"));
		model.addAttribute("lastPage", list.get("lastPage"));
		model.addAttribute("totalPage", list.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
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
		
		return "redirect:/mainExperienceSelectOne?experienceSelectId="+experienceSelectComment.getExperienceSelectId();
		
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
		
		return "redirect:/mainExperienceSelectOne?experienceSelectId=" + experienceSelectComment.getExperienceSelectId() + "&currentPage="+currentPage;
		
	}
	// 메인 체험 댓글 삭제
	@GetMapping("/deleteMainExperienceSelectComment")
	public String deleteMainExperienceSelectComment(int currentPage, ExperienceSelect experienceSelect) {
		mainSelectCommentService.getExperienceSelectDeletecomment(experienceSelect);
		return "redirect:/mainExperienceSelectOne?experienceSelectId=" + experienceSelect.getExperienceSelectId() + "&currentPage="+currentPage;
	}
	
	//메인 숙소 댓글 update
	@GetMapping("/updateMainRoomSelectComment")
	public String getupdateMainRoomSelectComment(Model model,int roomSelectCommentId, int currentPage, String customerId, int roomSelectId) {
		model.addAttribute("roomSelectCommentId", roomSelectCommentId);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("customerId", customerId);
		model.addAttribute("roomSelectId", roomSelectId);
		return "updateMainRoomSelectComment";
	}
	
	//메인 숙소 댓글 update
	@PostMapping("/updateMainRoomSelectComment")
	public String postUpdateMainRoomSelectComment(int currentPage, RoomSelectComment roomSelectComment) {

		mainSelectCommentService.getRoomSelectUpdatecomment(roomSelectComment);
		
		return "redirect:/mainRoomSelectOne?roomSelectId=" + roomSelectComment.getRoomSelectId() + "&currentPage="+currentPage;
		
	}
	// 메인 체험 댓글 삭제
	@GetMapping("/deleteMainRoomSelectComment")
	public String deleteMainRoomSelectComment(int currentPage,RoomSelect roomSelect) {
		mainSelectCommentService.getRoomSelectDeletecomment(roomSelect);
		return "redirect:/mainRoomSelectOne?roomSelectId="+roomSelect.getRoomSelectId()+ "&currentPage="+currentPage;
	}
	
	//메인 숙소 상세보기 댓글 추가
	@GetMapping("/addMainRoomSelectComment")
	public String getaddMainRoomSelectComment(Model model,String customerId, int roomSelectId, int currentPage) {
		model.addAttribute("customerId",customerId);
		model.addAttribute("roomSelectId",roomSelectId);
		model.addAttribute("currentPage",currentPage);
		return "addMainRoomSelectComment";
	}
	
	//메인 숙소 상세보기 댓글 추가
	@PostMapping("/addMainRoomSelectComment")
	public String postaddMainRoomSelectComment(Model model, RoomSelectComment roomSelectComment) {
		mainSelectCommentService.getRoomSelectInsertComment(roomSelectComment);
		
		return "redirect:/mainRoomSelectOne?roomSelectId="+roomSelectComment.getRoomSelectId();
		
	}
}