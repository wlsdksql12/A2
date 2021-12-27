package com.gdu.cast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerWishList {
	
	@GetMapping("/experienceWishList")
	public String insertExperienceWishList() {
		
		return "shop";
	}

}
