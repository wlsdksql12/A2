package com.gdu.cast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberListController {
	
	@GetMapping("/admin/customerList")
	public String customerList() {
		return"/admin/customerList";
	}
}
