package com.gdu.cast.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.cast.service.CustomerService;
import com.gdu.cast.vo.Customer;
import com.gdu.cast.vo.Qna;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerController {
	@Autowired CustomerService customerService;
	
	private final int ROW_PER_PAGE = 5;
	// 고객 페이지
	// QNA
	@GetMapping("/customerIndex")
	public String shopsingle(Model model, String customerId, int currentPage) {
		log.debug(customerId);
		
		Map<String, Object> map = customerService.getselectQna(customerId, currentPage, ROW_PER_PAGE);
		model.addAttribute("qnaList", map.get("qnaList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		return "customer/customerIndex";
	}
	@GetMapping("/qnaListOne")
	public String qnaOne(Model model, int qnaId, String customerId) {
		log.debug(qnaId + "<-0------------------QnaId");
		Qna qna = customerService.getSelectQnaOne(qnaId);
		model.addAttribute("customerId", customerId);
		model.addAttribute("qnaId",qna.getQnaId());
		model.addAttribute("qnaTitle",qna.getQnaTitle());
		model.addAttribute("qnaContent",qna.getQnaContent());
		model.addAttribute("qnaCategory", qna.getQnaCategory());
		model.addAttribute("createDate", qna.getCreateDate());
		return "customer/qnaListOne";
		
	}
	
	
}
