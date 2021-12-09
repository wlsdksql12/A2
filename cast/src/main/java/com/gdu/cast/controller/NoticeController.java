package com.gdu.cast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.cast.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	
	@GetMapping("/addNotice")
	public String addNotice() {
		return "/admin/addNotice";
	}
	
	@GetMapping("/noticeList")
	public String noticeList() {
		return"";
	}
}