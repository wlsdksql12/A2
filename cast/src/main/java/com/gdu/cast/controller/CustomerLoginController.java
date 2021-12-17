package com.gdu.cast.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.CustomerService;
import com.gdu.cast.vo.Customer;
import com.gdu.cast.vo.Delete_Id;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerLoginController {
	@Autowired CustomerService customerService;
	// 고객 회원가입 페이지
	@GetMapping("/customersingup")
	public String getCustomerSignUp() {
		return "signUp";
	}
	
	//고객 회원가입 추가
	@GetMapping("/addCustomer")
	public String getaddCustomer(Customer customer) {
		return "addCustomer";
	}
	
	//고객 회원가입 추가
	@PostMapping("/addCustomer")
	public String PostaddCustomer(Customer customer) {
		
		if(customerService.getselectDeleteId().equals(customer.getCustomerId())) {
			return "redirect:/deleteId";
		}
		//customer테이블에 입력
		customerService.getaddCustomer(customer);
		//customerLogin (로그인 기록) 생성
		customerService.getinsertCustomerLogin(customer.getCustomerId());
		return "redirect:/loginSelect";
		
		
	}
	
}
