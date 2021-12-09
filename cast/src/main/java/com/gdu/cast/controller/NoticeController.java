package com.gdu.cast.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String noticeList(Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String searchTitle) {
			// required = true -> 값이 안넘어오면 에러, required = false -> 안넘어오면 null
		System.out.println(searchTitle);
		final int ROW_PER_PAGE = 10;
		Map<String, Object> map = noticeService.getNoticeList(currentPage, ROW_PER_PAGE, searchTitle);
		model.addAttribute("noticeList", map.get("noticeList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchTitle", searchTitle);
		return "noticeList";
	}
	
	
}