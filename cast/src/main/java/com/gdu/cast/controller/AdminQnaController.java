package com.gdu.cast.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.gdu.cast.service.AdminQnaService;
import com.gdu.cast.vo.Qna;
import com.gdu.cast.vo.QnaComment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminQnaController {
	@Autowired AdminQnaService adminQnaService;
	private final int ROW_PER_PAGE = 5;
	@GetMapping("/admin/qnaList")
	public String qnaList(Model model, @RequestParam(defaultValue = "1") int currentPage) {
		
		Map<String, Object> map = adminQnaService.selectQna(currentPage, ROW_PER_PAGE);
		System.out.println(map.get("qnaList"));
		model.addAttribute("qnaList", map.get("qnaList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		
		return "/admin/qnaList";
	}
	
	@GetMapping("/admin/qnaComment")
	public String qnaComment(Model model, int qnaId) {
		model.addAttribute("qnaId", qnaId);
		return "/admin/qnaComment";
	}
	
	@PostMapping("/admin/qnaComment")
	public String qnaComment(HttpSession session, QnaComment qnaComment, Model model) {
		String adminId = (String) session.getAttribute("loginAdminId");
		qnaComment.setAdminId(adminId);
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ" + qnaComment + "ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
		
		adminQnaService.insertQnaComment(qnaComment);
		
		return "redirect:/mainQnaListOne?qnaId="+qnaComment.getQnaId();
		
	}
	
	@GetMapping("/admin/deleteQnaComment")
	public String deleteQnaComment(int qnaId, Model model) {
		System.out.println(qnaId + "<-------qnaId");
		model.addAttribute("qnaId", qnaId);
		return "/admin/deleteQnaComment";
	}
	
	@PostMapping("/admin/deleteQnaComment")
	public String deleteQnaComment(Qna qna) {
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ" + qna + "ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
		adminQnaService.deleteQnaComment(qna);
		return "redirect:/mainQnaListOne?qnaId="+qna.getQnaId();
		
	}
	
	@GetMapping("/admin/updateQnaComment")
	public String updateQnaComment(int qnaId, Model model) {
		System.out.println(qnaId + "<-------qnaId");
		model.addAttribute("qnaId", qnaId);
		return "/admin/updateQnaComment";
	}
	
	@PostMapping("/admin/updateQnaComment")
	public String updateQnaComment(QnaComment qnaComment) {
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ" + qnaComment + "ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
		adminQnaService.updateQnaComment(qnaComment);
		return "redirect:/mainQnaListOne?qnaId="+qnaComment.getQnaId();
		
	}
	
}
