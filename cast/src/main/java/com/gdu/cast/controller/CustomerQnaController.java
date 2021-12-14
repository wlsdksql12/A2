package com.gdu.cast.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.mapper.CustomerMapper;
import com.gdu.cast.service.AdminQnaService;
import com.gdu.cast.service.CustomerService;
import com.gdu.cast.vo.Customer;
import com.gdu.cast.vo.Qna;
import com.gdu.cast.vo.QnaComment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerQnaController {
	@Autowired CustomerService customerService;
	@Autowired AdminQnaService adminQnaService;
	
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
	//qna상세보기
	@GetMapping("/qnaListOne")
	public String qnaOne(Model model, int qnaId, String customerId, QnaComment qnaComment) {
		log.debug(qnaId + "<-0------------------QnaId");
		Qna qna = customerService.getSelectQnaOne(qnaId);
		qnaComment = adminQnaService.selectQnaComment(qnaId);
		model.addAttribute("customerId", customerId);
		model.addAttribute("qnaId",qna.getQnaId());
		model.addAttribute("qnaTitle",qna.getQnaTitle());
		model.addAttribute("qnaContent",qna.getQnaContent());
		model.addAttribute("qnaCategory", qna.getQnaCategory());
		model.addAttribute("createDate", qna.getCreateDate());
		model.addAttribute("updateDate",qna.getUpdateDate());
		if(qnaComment != null) {
			model.addAttribute("qnaCommentContent", qnaComment.getQnaCommentContent());
		}
		return "customer/qnaListOne";
		
	}
	//qna수정
	@GetMapping("/updateQna")
	public String updateQna(Model model,int qnaId, String customerId) {
		model.addAttribute("qnaId", qnaId);
		model.addAttribute("customerId", customerId);
		return "customer/updateQna";
	}
	//qna수정
	@PostMapping("/updateQna")
	public String updateQna(Qna qna) {
		System.out.println(qna+"!@#qna!@#");
		log.debug(qna.toString());
		customerService.getupdateQnaOne(qna);

		/*
		Qna qna = new Qna();
		qna.setQnaId(qnaId);
		qna.setQnaTitle(qnaTitle);
		qna.setQnaCategory(qnaCategory);
		qna.setQnaContent(qnaContent);
		*/
		
		return "redirect:/qnaListOne?qnaId="+qna.getQnaId()+"&customerId="+qna.getCustomerId();
		
	}
	
	//qna 삭제
	@GetMapping("deleteQna")
	public String deleteQna(Qna qna) {
		
		customerService.deleteQnaOne(qna);
		log.debug(qna + "<-- qnad@@@@@@@@@@@@@@@@@@");
		return "redirect:/customerIndex?customerId="+qna.getCustomerId()+"&currentPage=1";
		
	}
	
}
