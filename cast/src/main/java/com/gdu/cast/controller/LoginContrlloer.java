package com.gdu.cast.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.AdminService;
import com.gdu.cast.service.CeoService;
import com.gdu.cast.service.CustomerService;
import com.gdu.cast.service.TravelerService;
import com.gdu.cast.vo.Admin;
import com.gdu.cast.vo.Ceo;
import com.gdu.cast.vo.Customer;
import com.gdu.cast.vo.Customer_Login;
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
			// 현재 날짜
			LocalDate todaysDate = LocalDate.now();
		        System.out.println(todaysDate+"@#@#23232323");
			long calDateDays =0;
			
			Customer customer = new Customer();
			customer.setCustomerId(Id);
			customer.setCustomerPw(Pw);
			
			Customer_Login customer_Login = new Customer_Login();
			customer_Login.setCustomerId(customer.getCustomerId());
			//로그인 기록 셀렉트
			Customer_Login customerLogin = customerService.getselectCustomerLogin(customer_Login);
			System.out.println(customerLogin.getUpdatedate()+"@#@#@#@#@#updateDate");	
			
			// 세션용
			Customer loginCustomer = customerService.getselectCustomer(customer);
			session.setAttribute("loginCustomerId", loginCustomer.getCustomerId());
		
			
			
			
			// 날짜 차이 계산
			try {
				DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
				
				Date nowDate = java.sql.Date.valueOf(todaysDate);
				System.out.println(nowDate + "@#@#nowDate@#@");
				Date beforeDate = dateFormat.parse(customerLogin.getUpdatedate());
				System.out.println(beforeDate + "@#@#beforDate@#@#@#");
				
				
				long calDate = nowDate.getTime() - beforeDate.getTime(); 
				System.out.println(calDate + "@#@#@#calDate@#@#@#");
				calDateDays = calDate / (24*60*60*1000);
				
				calDateDays = Math.abs(calDateDays);
				
				log.debug("날짜 차이 : "+ calDateDays);
				
			}catch(ParseException e) {
				
				e.printStackTrace();
			}
			// 60일 이상이라면
			if(calDateDays > 60) {
				customerService.getupdateActiveZeroDate(customer.getCustomerId());
				return "redirect:/active?customerId="+customer.getCustomerId();
			}
			// 로그인 기록 업데이트
			customerService.getupdateDate(loginCustomer.getCustomerId());
						
			if(customerService.getSelectActive(loginCustomer.getCustomerId()).equals("0")) {
				return "redirect:/loginSelect";
			}
		
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
	
	
	@GetMapping("/active")
	public String active(Model model,String customerId) {
		model.addAttribute("customerId",customerId);
		return "customer/active";
	}
}
