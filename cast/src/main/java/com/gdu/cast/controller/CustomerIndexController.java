package com.gdu.cast.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.mapper.CustomerMapper;
import com.gdu.cast.service.AdminQnaService;
import com.gdu.cast.service.CustomerService;
import com.gdu.cast.vo.Customer;
import com.gdu.cast.vo.Experience;
import com.gdu.cast.vo.Hotel;
import com.gdu.cast.vo.Qna;
import com.gdu.cast.vo.QnaComment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerIndexController {
	@Autowired CustomerService customerService;
	@Autowired AdminQnaService adminQnaService;
	
	private final int ROW_PER_PAGE = 5;
	private final int row_per_page = 10;
	
	// 고객 페이지
	@GetMapping("/qnaList")
	public String qnaList(Model model, String customerId, int currentPage) {
		log.debug(customerId);
		
		List<Qna> list = adminQnaService.getQnaAlarm(customerId);
		log.debug(list.toString() + "@#$@##@$@list@#$@#$@#");
		model.addAttribute("list", list);
		
		Map<String, Object> map = customerService.getselectQna(customerId, currentPage, row_per_page);
		model.addAttribute("qnaList", map.get("qnaList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);

		return "customer/qnaList";
	}
	
	// 고객페이지 메인 qna 5개
	@GetMapping("/customer/customerIndex")
	public String shopsingle(Model model, String customerId, int currentPage) {
		log.debug(customerId);
		// 내가 작성한 추천 댓글의 총 수
		int selectCount = customerService.getselectCustomerCommentCount(customerId);
		
		// 내가 쓴 qna 5개 리스트
		Map<String, Object> map = customerService.getselectQna(customerId, currentPage, ROW_PER_PAGE);
		// 체험 5개 등록 리스트
		List<Experience> experienceList = customerService.getselectCustomerIndexExperienceList();
		// 숙소 5개 등록 리스트
		List<Hotel> hotelList = customerService.getselectCustomerIndexHoelList();
		
		model.addAttribute("selectCount", selectCount);
		model.addAttribute("hotelList", hotelList);
		model.addAttribute("experienceList", experienceList);
		model.addAttribute("qnaList", map.get("qnaList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		
		List<Qna> list = adminQnaService.getQnaAlarm(customerId);
		log.debug(list.toString() + "@#$@##@$@list@#$@#$@#");
		model.addAttribute("list", list);
		
		return "customer/customerIndex";
	}
	
	//qna상세보기
	@GetMapping("/customer/qnaListOne")
	public String qnaOne(Model model, int qnaId, String customerId, QnaComment qnaComment, @RequestParam(defaultValue = "1") int currentPage) {
	
		
		List<Qna> list = adminQnaService.getQnaAlarm(customerId);
		log.debug(list.toString() + "@#$@##@$@list@#$@#$@#");
		model.addAttribute("list", list);
		
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
		model.addAttribute("currentPage" , currentPage);
		if(qnaComment != null) {
			model.addAttribute("qnaCommentContent", qnaComment.getQnaCommentContent());
		}
		return "customer/qnaListOne";
		
	}
	

	
	
	//qna수정
	@GetMapping("/updateQna")
	public String updateQna(Model model,int qnaId, String customerId, int currentPage) {
		List<Qna> list = adminQnaService.getQnaAlarm(customerId);
		log.debug(list.toString() + "@#$@##@$@list@#$@#$@#");
		model.addAttribute("list", list);
		
		
		model.addAttribute("qnaId", qnaId);
		model.addAttribute("customerId", customerId);
		model.addAttribute("currentPage", currentPage);
		return "customer/updateQna";
	}
	//qna수정
	@PostMapping("/updateQna")
	public String updateQna(Qna qna, int currentPage) {
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
		
		return "redirect:/customer/qnaListOne?qnaId="+qna.getQnaId()+"&customerId="+qna.getCustomerId()+"&currentPage="+currentPage;
		
	}
	
	//고객 qna 삭제
	@GetMapping("/deleteQna")
	public String deleteQna(Qna qna) {
		customerService.deleteQnaOne(qna);
		log.debug(qna + "<-- qnad@@@@@@@@@@@@@@@@@@");
		return "redirect:/customer/customerIndex?customerId="+qna.getCustomerId()+"&currentPage=1";
		
	}
	
	
	

	
	
}
