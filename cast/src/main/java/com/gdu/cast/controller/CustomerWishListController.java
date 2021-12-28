package com.gdu.cast.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.ExperienceWishListService;

@Controller
public class CustomerWishListController {
	@Autowired ExperienceWishListService experienceWishListService;
	
	private final int ROW_PER_PAGE = 10;
	// shop 페이지에서 관심상품 등록
	@GetMapping("/experienceWishList")
	public String insertExperienceWishList(HttpSession session, int experienceId) {
		
		String customerId = (String) session.getAttribute("loginCustomerId");
		// 비회원이라면 샵으로 이동.
		if(customerId == null) {
			return "redirect:/shop";
		}
		experienceWishListService.getinsertExperienceWishList(customerId, experienceId);
		return "redirect:/shop";
	}
	
	// 고객페이지에서 본인이 등록한 관심상품 조회
	@GetMapping("/customerExperienceWishList")
	public String selectExperienceWishList(Model model, HttpSession session,@RequestParam(defaultValue = "1") int currentPage ) {
		String customerId = (String) session.getAttribute("loginCustomerId");
		Map<String, Object> map = experienceWishListService.getselectExperienceWishListList(customerId, currentPage, ROW_PER_PAGE);
		model.addAttribute("wishList", map.get("wishList"));
		model.addAttribute("lastPage",map.get("lastPage"));
		
		return "customer/customerExperienceWishList";
		
	}
	
	
	
}
