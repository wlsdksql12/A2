package com.gdu.cast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.NoticeService;
import com.gdu.cast.vo.Notice;


@Controller
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	
	@GetMapping("/addNotice")
	public String addNotice() {
		
		return "/admin/addNotice";
	}
	
	@PostMapping("/addNotice")
	public String addNotice(HttpSession session, Notice notice) {
		String adminId = (String) session.getAttribute("loginAdminId");
		notice.setAdminId(adminId);
		System.out.println(notice);
		noticeService.addNotice(notice);
		return"redirect:/adminIndex";
	}
	
	@GetMapping("/noticeList")
	public String noticeList() {
		return"";
	}
}