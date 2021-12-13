package com.gdu.cast.controller;

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
	      return "redirect:/customerIndex?customerId="+customerId+"&currentPage=1";

	   }
	   
	   //회원탈퇴 페이지
	   @PostMapping("/deleteCustomer")
	   public String getDeleteCustomer(Customer customer) {
		   settingCustomerService.getInsertDeleteId(customer.getCustomerId());
		   settingCustomerService.getDeleteCustomer(customer.getCustomerId(), customer.getCustomerPw());
		   return "redirect:/loginSelect";
	   }
}
