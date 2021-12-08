package com.gdu.cast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping("/adminIndex")
	public String adminIndex() {
		return "admin/adminIndex";
	}
}
