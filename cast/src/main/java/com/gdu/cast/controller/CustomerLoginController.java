package com.gdu.cast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.CustomerService;
import com.gdu.cast.vo.Admin;
import com.gdu.cast.vo.Customer;

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
		customerService.getaddCustomer(customer);
		return "redirect:/loginSelect";
	}
	
	//로그
	@GetMapping("/customerLogin")
	public String getcustomerLogin() {
		return "customer/customerLogin";
	}
	//로그인
	@PostMapping("/customerLogin")
	public String postCustomerLogin(HttpSession session, Customer customer) {
		log.debug(customer.getCustomerId());
		log.debug(customer.getCustomerPw());
		Customer loginCustomer = customerService.getselectCustomer(customer);
		log.debug(loginCustomer + "<-- loginCustomer");
		if(loginCustomer == null) {
			return "redirect:/customer/CustomerLogin";
		}
		session.setAttribute("loginCustomerId", loginCustomer.getCustomerId());
		System.out.println(session.getAttribute("loginCustomerid"));
		return "redirect:/index?customerId="+loginCustomer.getCustomerId();
	}
	
}
