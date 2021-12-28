package com.gdu.cast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.SettingCustomerService;
import com.gdu.cast.vo.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SettingCustomerController {
	@Autowired SettingCustomerService settingCustomerService;
	
	//셋팅 페이지 호출
	@GetMapping("/setting")
	   public String setting(Customer customer) {
	      return "/customer/settingCustomer";
	   }
	   
	//비밀번호 수정
	   @GetMapping("/updatePw")
	   public String getUpdatePw(Model model,Customer customer) {
		   
	      return "/customer/updateCustomer";
	   }
	   
	   //비밀번호 수정
	   @PostMapping("/updatePw")
	   public String postUpdatePw(String customerId, String customerPw, String newCustomerPw) {
	    
		   settingCustomerService.getUpdatePwCustomer(customerId, customerPw,newCustomerPw);
	      return "redirect:/customer/customerIndex?customerId="+customerId+"&currentPage=1";

	   }
	   
	   //회원 탈퇴 페이지
	   @PostMapping("/deleteCustomer")
	   public String getDeleteCustomer(Customer customer, HttpSession session) {
		   String customerId = (String) session.getAttribute("loginCustomerId");
		   if(settingCustomerService.getselectCustomerPw(customerId, customer.getCustomerPw()) != 1) {

		   return "redirect:/shop";
		   }
		   		//(체험, 숙소)관심상품 삭제
		   		settingCustomerService.getdeleteCustomerWishList(customerId);
			   //customer회원탈퇴 테이블에 저장
			   settingCustomerService.getInsertDeleteId(customer.getCustomerId());
			   //customer 로그인기록 삭제
			   settingCustomerService.getdeleteCustomerLogin(customer.getCustomerId());
			   // customer 테이블 삭제
			   settingCustomerService.getDeleteCustomer(customer.getCustomerId(), customer.getCustomerPw());
			  //세션 종료
			   session.invalidate();
		   
		   return "redirect:/loginSelect";
	   }
	   
}
