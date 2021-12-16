package com.gdu.cast.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.MainSelectCommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainSelectCommetController {
	@Autowired MainSelectCommentService mainSelectCommentService;
	
	private final int ROW_PER_PAGE = 5;
	//메인페이지 qna리스트
	@GetMapping("/mainSelectCommentList")
	public String mainQnaList(Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			int experienceSelectId) {
		Map<String, Object> map = mainSelectCommentService.getexperienceSelectComment(currentPage, ROW_PER_PAGE,experienceSelectId);
		model.addAttribute("selectCommentList", map.get("selectCommentList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);

		return "mainQna";
		
	}
}
