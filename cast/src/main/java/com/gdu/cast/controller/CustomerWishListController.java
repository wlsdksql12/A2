package com.gdu.cast.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.ExperienceWishListService;
import com.gdu.cast.service.RoomWishListService;
import com.gdu.cast.vo.ExperienceWishList;

@Controller
public class CustomerWishListController {
	@Autowired ExperienceWishListService experienceWishListService;
	@Autowired RoomWishListService roomWishListService;
	
	private final int ROW_PER_PAGE = 10;
	// shop 페이지에서 관심상품 등록
	@GetMapping("/experienceWishList")
	public String insertExperienceWishList(HttpSession session, int experienceId) {
		
		String customerId = (String) session.getAttribute("loginCustomerId");
		// 비회원이라면 샵으로 이동.
		if(customerId == null) {
			return "redirect:/loginSelect";
		}

		experienceWishListService.getinsertExperienceWishList(customerId, experienceId);
		
		return "redirect:/shop";
	}
	
	// 고객페이지에서 본인이 등록한 체험관심상품 조회
	@GetMapping("/customerExperienceWishList")
	public String selectExperienceWishList(Model model, HttpSession session,@RequestParam(defaultValue = "1") int currentPage ) {
		String customerId = (String) session.getAttribute("loginCustomerId");
		Map<String, Object> map = experienceWishListService.getselectExperienceWishListList(customerId, currentPage, ROW_PER_PAGE);
		model.addAttribute("wishList", map.get("wishList"));
		model.addAttribute("lastPage",map.get("lastPage"));
		
		return "customer/customerExperienceWishList";
		
	}
	// 숙소 관심 상품 등록
	@GetMapping("/roomWishList")
	public String insertRoomWishList(HttpSession session, int hotelId) {
		
		String customerId = (String) session.getAttribute("loginCustomerId");
		// 비회원이라면 샵으로 이동.
		if(customerId == null) {
			return "redirect:/loginSelect";
		}

		roomWishListService.getinsertRoomWishList(customerId, hotelId);
		return "redirect:/shop";
	}
	// 고객페이지에서 본인이 등록한 호텔관심상품 조회
	@GetMapping("/customerRoomWishList")
	public String selectRoomWishList(Model model, HttpSession session, @RequestParam(defaultValue = "1") int currentPage) {
		String customerId = (String) session.getAttribute("loginCustomerId");
		Map<String, Object> map = roomWishListService.getselectRoomWishListList(customerId, currentPage, ROW_PER_PAGE);
		model.addAttribute("wishList", map.get("wishList"));
		model.addAttribute("lastPage",map.get("lastPage"));
		return "customer/customerRoomWishList";
		
	}
}
