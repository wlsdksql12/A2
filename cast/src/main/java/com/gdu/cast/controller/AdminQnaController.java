package com.gdu.cast.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.cast.service.AdminQnaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminQnaController {
	@Autowired AdminQnaService adminQnaService;
	private final int ROW_PER_PAGE = 5;
	int	currentPage = 1;
	@GetMapping("/QnaList")
	public String shopsingle(Model model) {
		
		Map<String, Object> map = adminQnaService.selectQna(currentPage, ROW_PER_PAGE);
		System.out.println(map.get("qnaList"));
		model.addAttribute("qnaList", map.get("qnaList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		
		
		return "admin/qnaList";
	}
}
