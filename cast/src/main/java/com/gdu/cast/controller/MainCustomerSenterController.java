package com.gdu.cast.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.AdminQnaService;
import com.gdu.cast.service.CustomerService;
import com.gdu.cast.service.MainCustomerSenterService;
import com.gdu.cast.service.NoticeService;
import com.gdu.cast.vo.Notice;
import com.gdu.cast.vo.Qna;
import com.gdu.cast.vo.QnaComment;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class MainCustomerSenterController {
	@Autowired CustomerService customerService;
	@Autowired MainCustomerSenterService mainCustomerSenterService;
	@Autowired AdminQnaService adminQnaService;
	@Autowired NoticeService noticeService;
	
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
	
	// 메인페이지 공지사항 리스트
	@GetMapping("/mainNotice")
	public String mainNoticeList(Model model, 
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String searchTitle) {
		// 검색어 디버깅
		System.out.println(searchTitle);
		Map<String, Object> map = mainCustomerSenterService.getNoticeList(currentPage, ROW_PER_PAGE, searchTitle);
		
		System.out.println(map.get("noticeList"));
		model.addAttribute("noticeList", map.get("noticeList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchTitle", searchTitle);
		
		return"about";
	}
	
	// 메인페이지 공지사항 상세보기
	@GetMapping("/mainNoticeOne")
	public String mainNoticeOne(Model model, int noticeNo) {
		System.out.println(noticeNo);
		Notice notice = noticeService.NoticeOne(noticeNo);
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ" + notice + "ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
		model.addAttribute("noticeNo", notice.getNoticeNo());
		model.addAttribute("adminId", notice.getAdminId());
		model.addAttribute("noticeTitle", notice.getNoticeTitle());
		model.addAttribute("noticeContent", notice.getNoticeContent());
		model.addAttribute("createDate", notice.getCreateDate());
		model.addAttribute("updateDate", notice.getUpdateDate());
		return"mainNoticeOne";
	}
	
}
