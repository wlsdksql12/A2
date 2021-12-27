package com.gdu.cast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.cast.service.ExperienceWishListService;

@Controller
public class CustomerWishList {
	@Autowired ExperienceWishListService experienceWishListService;
	
	@GetMapping("/experienceWishList")
	public String insertExperienceWishList() {
		return "shop";
	}

}
