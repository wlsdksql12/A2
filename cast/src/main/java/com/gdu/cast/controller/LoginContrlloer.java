package com.gdu.cast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.AdminService;
import com.gdu.cast.service.CeoService;
import com.gdu.cast.service.CustomerService;
import com.gdu.cast.service.TravelerService;
import com.gdu.cast.vo.Admin;
import com.gdu.cast.vo.Ceo;
import com.gdu.cast.vo.Customer;
import com.gdu.cast.vo.Traveler;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class LoginContrlloer {

	@Autowired CustomerService customerService;
	@Autowired CeoService ceoService;
	@Autowired AdminService adminService;
	@Autowired TravelerService travelerService;
	
	
	@GetMapping("/loginSelect")
	public String loginSelect() {
		return "loginSelect";
	}
	
	@PostMapping("/index")
	public String postCustomerLogin(HttpSession session, String login, String Id, String Pw) {
		
		
		if(login.equals("adminLogin")) {
			
			Admin admin = new Admin();
			admin.setAdminId(Id);
			admin.setAdminPw(Pw);
			Admin loginAdmin = adminService.getSelectAdmin(admin);
			session.setAttribute("loginAdminId", loginAdmin.getAdminId());

			return "redirect:/index?adminId="+loginAdmin.getAdminId();
		}
		else if(login.equals("travelerLogin")) {
			Traveler traveler = new Traveler();
			traveler.setTravelerId(Id);
			traveler.setTravelerPw(Pw);
			Traveler loginTraveler = travelerService.getSelectTraveler(traveler);
			session.setAttribute("loginTravelerId", loginTraveler.getTravelerId());

			return "redirect:/index";
			
		}else if(login.equals("customerLogin")) {
			Customer customer = new Customer();
			customer.setCustomerId(Id);
			customer.setCustomerPw(Pw);
			Customer loginCustomer = customerService.getselectCustomer(customer);
			session.setAttribute("loginCustomerId", loginCustomer.getCustomerId());
			// 로그인 정보가 다르면 다시 로그인 창으로 소환!

			return "redirect:/index?customerId="+loginCustomer.getCustomerId();
		}
		else if(login.equals("ceoLogin")) {
			Ceo ceo = new Ceo();
			ceo.setCeoId(Id);
			ceo.setCeoPw(Pw);
			Ceo loginCeo = ceoService.loginCeo(ceo);
			session.setAttribute("loginCeoId", loginCeo.getCeoId());
			// 로그인 정보가 다르면 다시 로그인 창으로 소환!

			return "redirect:/index?ceoId="+ loginCeo.getCeoId();
		}
		return "/loginSelect";
		
		

	

	
		
		
	}
}
