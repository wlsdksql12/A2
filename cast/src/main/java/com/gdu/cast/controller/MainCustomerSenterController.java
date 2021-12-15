package com.gdu.cast.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.cast.service.AdminQnaService;
import com.gdu.cast.service.CustomerService;
import com.gdu.cast.service.MainCustomerSenterService;
import com.gdu.cast.vo.Qna;
import com.gdu.cast.vo.QnaComment;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class MainCustomerSenterController {
	@Autowired CustomerService customerService;
	@Autowired MainCustomerSenterService mainCustomerSenterService;
	@Autowired AdminQnaService adminQnaService;
	
	private final int ROW_PER_PAGE = 10;
	
	//메인페이지 qna리스트
	@GetMapping("/mainQna")
	public String mainQnaList(Model model, int currentPage) {
		Map<String, Object> map = mainCustomerSenterService.getselectQna(currentPage, ROW_PER_PAGE);
		model.addAttribute("qnaList", map.get("qnaList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		return "mainQna";
		
	}
	
	
	//메인페이지 qna상세보기
	@GetMapping("/mainQnaListOne")
	public String mainQnaListOne(Model model, int qnaId, QnaComment qnaComment) {
		log.debug(qnaId + "<-0------------------QnaId");
		Qna qna = customerService.getSelectQnaOne(qnaId);
		System.out.println(qna.getCustomerId()+ "!@##!@#qnaCustomerId!@#!@3");
		qnaComment = adminQnaService.selectQnaComment(qnaId);
		model.addAttribute("customerId", qna.getCustomerId());
		model.addAttribute("qnaId",qna.getQnaId());
		model.addAttribute("qnaTitle",qna.getQnaTitle());
		model.addAttribute("qnaContent",qna.getQnaContent());
		model.addAttribute("qnaCategory", qna.getQnaCategory());
		model.addAttribute("createDate", qna.getCreateDate());
		model.addAttribute("updateDate",qna.getUpdateDate());
		if(qnaComment != null) {
			model.addAttribute("qnaCommentContent", qnaComment.getQnaCommentContent());
		}
		return "mainQnaListOne";
		
	}
	
	//메인 qna 삭제
	@GetMapping("/maindeleteQna")
	public String maindeleteQna(Qna qna) {
		System.out.println(qna.getQnaId()+ "qnaId@#@#@#@#");
		System.out.println(qna.getCustomerId() + "customerId@#!@#");
		customerService.deleteQnaOne(qna);
		log.debug(qna + "<-- qnad@@@@@@@@@@@@@@@@@@");
		return "redirect:/mainQna?currentPage=1";
		
	}
	
	
}
