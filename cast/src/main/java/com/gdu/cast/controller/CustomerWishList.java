package com.gdu.cast.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.cast.service.ExperienceWishListService;

@Controller
public class CustomerWishList {
	@Autowired ExperienceWishListService experienceWishListService;
	
	@GetMapping("/experienceWishList")
	public String insertExperienceWishList(HttpSession session, int experienceId) {
		String customerId = (String) session.getAttribute("loginCustomerId");
		experienceWishListService.getinsertExperienceWishList(customerId, experienceId);
		return "shop";
	}

}
