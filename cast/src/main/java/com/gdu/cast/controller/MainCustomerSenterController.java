package com.gdu.cast.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.cast.service.MainCustomerSenterService;



@Controller
public class MainCustomerSenterController {
	@Autowired MainCustomerSenterService mainCustomerSenterService;
	
	private final int ROW_PER_PAGE = 10;
	
	@GetMapping("/mainQna")
	public String mainQnaList(Model model, int currentPage) {
		Map<String, Object> map = mainCustomerSenterService.getselectQna(currentPage, ROW_PER_PAGE);
		model.addAttribute("qnaList", map.get("qnaList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		return "qnaAbout";
		
	}
	
	
}
