package com.gdu.cast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CeoController {
	@GetMapping("/selectExpHotel")
	public String selectExpHotel() {
		return "ceo/selectExpHotel";
	}
}
