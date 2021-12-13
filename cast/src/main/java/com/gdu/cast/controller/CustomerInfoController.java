package com.gdu.cast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.CustomerService;
import com.gdu.cast.vo.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerInfoController {
	@Autowired CustomerService customerService;
	
	// 내정보 보기
	@GetMapping("/myinfo")
	public String getMyInfo(Model model, HttpSession session) {
		
		String customerId = (String) session.getAttribute("loginCustomerId");
		Customer customer = customerService.getselectInfo(customerId);
		model.addAttribute("customerId", customer.getCustomerId());
		model.addAttribute("customerName", customer.getCustomerName());
		model.addAttribute("customerJumin", customer.getCustomerEmail());
		model.addAttribute("customerPhoneNum", customer.getCustomerPhoneNum());
		
		return "customer/myInfo";
		
	}
	
	//내정보 수정
	@GetMapping("/updateInfo")
	public String getupdateInfo(Model model, String customerId) {
		model.addAttribute("customerId", customerId);
		return "customer/updateInfo";
	}
	
	// 내정보 수정
	@PostMapping("/updateInfo")
	public String postupdateInfo(Customer customer) {
		customerService.getupdateInfo(customer);
		log.debug(customerService.getupdateInfo(customer)+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		return "redirect:/myinfo?customerId="+customer.getCustomerId();
		
	}
	
	// 로그아웃
	@GetMapping("/logOut")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/loginSelect";
	}
}
