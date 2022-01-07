package com.gdu.cast.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.gdu.cast.mapper.AdminChartMapper;
import com.gdu.cast.service.AdminQnaService;
import com.gdu.cast.service.AdminService;
import com.gdu.cast.service.ExperienceOrderService;
import com.gdu.cast.service.JoinRequestService;
import com.gdu.cast.service.RoomOrderService;
import com.gdu.cast.vo.Admin;
import com.gdu.cast.vo.ExperiencePayment;
import com.gdu.cast.vo.JoinCeo;
import com.gdu.cast.vo.JoinTraveler;
import com.gdu.cast.vo.RoomPayment;

@Controller
public class AdminController {
	@Autowired AdminService adminService;
	@Autowired AdminQnaService adminQnaService;
	@Autowired JoinRequestService joinRequestService;
	@Autowired ExperienceOrderService experienceOrderService; 
	@Autowired RoomOrderService roomOrderService;
	@Autowired AdminChartMapper adminChartMapper;
	private final int ROW_PER_PAGE = 5;
	
	// 관리자 메인페이지
	@GetMapping("/admin/adminIndex")
	public String adminIndex(Model model, @RequestParam(defaultValue = "1") int currentPage) {
		
		Map<String, Object> newCustomer = adminService.selectNewCustomer();
		Map<String, Object> newTraveler = adminService.selectNewTraveler();
		Map<String, Object> newCeo = adminService.selectNewCeo();
		int newNotQnaComment = adminService.selectNewNotQnaComment();
		Map<String, Object> map = adminQnaService.selectNotQnaComment(currentPage, ROW_PER_PAGE);
		// 현재 날짜 구하기
		LocalDate nowDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
		int year = nowDate.getYear(); // 현재날짜의 년도
		int[] yearList = {year, year-1, year-2};
		// 여행작가 회원가입 요청 리스트 4개
		List<JoinTraveler> joinTravelerList = joinRequestService.getTravelerJoinRequestList4();
		System.out.println(joinTravelerList.toString());
		int orderCount =  adminService.selectOrderCount();
		// 여행작가 회원가입 요청 리스트 4개
		List<JoinCeo> joinCeoList = joinRequestService.getCeoJoinRequestList4();
		System.out.println(joinCeoList.toString());
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ" + newCustomer.get("count") + "ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ" + newCustomer.get("TotalCount") + "ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ" + newTraveler + "ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ" + newCeo + "ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
		int yearTotalPay = adminService.selectTotalPay();
		model.addAttribute("orderCount", orderCount);
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
		model.addAttribute("yearList", yearList);
		model.addAttribute("yearTotalPay", yearTotalPay);
		
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
	
	// 관리자 예약 리스트
	@GetMapping("/admin/orderList")
	public String getOrderList(Model model) {
		model.addAttribute("experienceOrderList", experienceOrderService.getAdminExperienceOrder());
		model.addAttribute("roomOrderList", roomOrderService.getAdminRoomOrder());
		return"/admin/adminOrderList";
	}
	
	// 관리자 결제 리스트
	@GetMapping("/admin/paymentList")
	public String getPaymentList(Model model) {
		model.addAttribute("experiencePaymentList", experienceOrderService.getAdminExperiencePayment());
		model.addAttribute("roomPaymentList", roomOrderService.getAdminRoomPayment());
		return"/admin/adminPaymentList";
	}
	
	// 관리자 숙소 예약&결제 상세보기
	@GetMapping("/admin/roomPaymentOne")
	public String getAdminRoomPaymentOne(Model model, int roomOrderId) {
		RoomPayment roomPaymentOne = roomOrderService.getAdminRoomPaymentOne(roomOrderId);
		model.addAttribute("roomPaymentOne", roomPaymentOne);
		return "/admin/adminRoomPaymentOne";
	}
	
	// 관리자 체험 예약&결제 상세보기
	@GetMapping("/admin/experiencePaymentOne")
	public String getAdminExperiencePaymentOne(Model model, int experienceOrderId) {
		ExperiencePayment experiencePaymentOne = experienceOrderService.getAdminExperiencePaymentOne(experienceOrderId);
		model.addAttribute("experiencePaymentOne", experiencePaymentOne);
		return "/admin/adminExperiencePaymentOne";
	}
}
