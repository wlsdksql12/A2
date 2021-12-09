package com.gdu.cast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {
	@GetMapping("/addNotice")
	public String addNotice() {
		return "/admin/addNotice";
	
	}
}