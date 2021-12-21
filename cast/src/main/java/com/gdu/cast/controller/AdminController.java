package com.gdu.cast.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.AdminQnaService;
import com.gdu.cast.service.AdminService;
import com.gdu.cast.service.JoinRequestService;
import com.gdu.cast.vo.Admin;
import com.gdu.cast.vo.JoinCeo;
import com.gdu.cast.vo.JoinTraveler;

@Controller
public class AdminController {
	@Autowired AdminService adminService;
	@Autowired AdminQnaService adminQnaService;
	@Autowired JoinRequestService joinRequestService;
	
	private final int ROW_PER_PAGE = 5;
	
	// 관리자 메인페이지
	@GetMapping("/admin/adminIndex")
	public String adminIndex(Model model, @RequestParam(defaultValue = "1") int currentPage) {
		
		Map<String, Object> newCustomer = adminService.selectNewCustomer();
		Map<String, Object> newTraveler = adminService.selectNewTraveler();
		Map<String, Object> newCeo = adminService.selectNewCeo();
		int newNotQnaComment = adminService.selectNewNotQnaComment();
		Map<String, Object> map = adminQnaService.selectNotQnaComment(currentPage, ROW_PER_PAGE);
		// 차트에 사용할 임시 데이터
		int[] data = {0,3000000,5000000,15000000,8000000,20000000,15000000,25000000,20000000,30000000,25000000,45000000};
		// 여행작가 회원가입 요청 리스트 4개
		List<JoinTraveler> joinTravelerList = joinRequestService.getTravelerJoinRequestList4();
		System.out.println(joinTravelerList.toString());
		
		// 여행작가 회원가입 요청 리스트 4개
		List<JoinCeo> joinCeoList = joinRequestService.getCeoJoinRequestList4();
		System.out.println(joinCeoList.toString());
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ" + newCustomer.get("count") + "ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ" + newCustomer.get("TotalCount") + "ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ" + newTraveler + "ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ" + newCeo + "ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
		model.addAttribute("data", data);
		model.addAttribute("joinTravelerList",joinTravelerList);
		model.addAttribute("joinCeoList",joinCeoList);
		model.addAttribute("newCustomer", newCustomer.get("count"));
		model.addAttribute("TotalCustomer", newCustomer.get("TotalCount"));
		model.addAttribute("newTraveler", newTraveler.get("count"));
		model.addAttribute("TotalTraveler", newTraveler.get("TotalCount"));
		model.addAttribute("newCeo", newCeo.get("count"));
		model.addAttribute("TotalCeo", newCeo.get("TotalCount"));
		model.addAttribute("newNotQnaComment", newNotQnaComment);
		model.addAttribute("notQnaCommentList", map.get("notQnaCommentList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		
		return "admin/adminIndex";
	}
	
	// 관리자 로그인페이지
	@GetMapping("/adminLogin")
	public String adminLogin() {
		return "admin/adminLogin";
	}
	
	// 관리자 로그인
	@PostMapping("/adminLogin")
	// 비밀번호 (password)처리...
	public String postCustomerSignUp(HttpSession session, Admin admin) {
		System.out.println(admin.getAdminId() + "<-adminContrlloer");
		System.out.println(admin.getAdminPw() + "<-adminContrlloer");
		Admin loginAdmin = adminService.getSelectAdmin(admin);
		System.out.println(loginAdmin + "<-adminContrlloer"); // 관리자 id, 관리자 이름
		if(loginAdmin == null) {
			return "redirect:/adminLogin";
		}
		session.setAttribute("loginAdminId", loginAdmin.getAdminId());
		session.setAttribute("loginAdminName", loginAdmin.getAdminName());
		System.out.println(session.getAttribute("loginAdminId") + " <---AdminController");
		System.out.println(session.getAttribute("loginAdminName") + " <---AdminController");
		return "redirect:/admin/adminIndex";
	}
	
}
