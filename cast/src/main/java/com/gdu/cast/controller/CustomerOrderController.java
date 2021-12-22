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

import com.gdu.cast.service.ExperienceOrderService;
import com.gdu.cast.vo.ExperienceOrder;
import com.gdu.cast.vo.ExperiencePayment;

@Controller
public class CustomerOrderController {
	@Autowired ExperienceOrderService experienceOrderService;
	
	private final int ROW_PER_PAGE = 10;
	
	// 예약 입력
	@GetMapping("/addExperienceOrder")
	public String getaddOrder(HttpSession session, Model model, @RequestParam(defaultValue = "1") int experienceId) {
	System.out.println(experienceId + "EXID");
	String customerId = (String) session.getAttribute("loginCustomerId");
	model.addAttribute("experienceId",experienceId);
	model.addAttribute("customerId",customerId);
	
	return "addExperienceOrder";
	}
	
	// 예약 입력
	@PostMapping("/addExperienceOrder")
	public String PostaddOrder(ExperienceOrder experienceOrder, int experienceId) {
		
		return "redirect:/addExperiencePayment?experienceId="+experienceId + "&customerId="+ experienceOrder.getCustomerId() + "&experienceOrderPeople="+experienceOrder.getExperienceOrderPeople()
		+ "&experienceOrderStartDate="+experienceOrder.getExperienceOrderStartDate() + "&experienceOrderEndDate="+experienceOrder.getExperienceOrderEndDate();
	}
	// 결제 입력
	@GetMapping("/addExperiencePayment")
	public String getaddPayment(Model model, ExperienceOrder experienceOrder, int experienceId) {
		System.out.println(experienceOrder.toString() +"experienceOrder.toString()");
		int experiencePrice = experienceOrderService.getexperienceSelectPrice(experienceId);
		String experienceSelectName = experienceOrderService.getexperienceSelectName(experienceId);
		model.addAttribute("experienceSelectName",experienceSelectName);
		model.addAttribute("experiencePrice",experiencePrice * experienceOrder.getExperienceOrderPeople());
		model.addAttribute("experienceOrderPeople", experienceOrder.getExperienceOrderPeople());
		model.addAttribute("ExperienceOrderStartDate",experienceOrder.getExperienceOrderStartDate());
		model.addAttribute("ExperienceOrderEndDate", experienceOrder.getExperienceOrderEndDate());
		model.addAttribute("CustomerId", experienceOrder.getCustomerId());
		
		return "addExperiencePayment";
	}
	
	@PostMapping("/addExperiencePayment")
	public String postaddPayment(String experiencePaymentMethod,String experiencePaymentMethodNumber,int experienceOrderPeople, int experiencePaymentMoney, String experienceName, String customerId, String experienceOrderEndDate, String experienceOrderStartDate) {
		int Order = experienceOrderService.getexperienceInsertOrder(experienceOrderPeople, experienceName,customerId,experienceOrderEndDate,experienceOrderStartDate);
		System.out.println(Order+"@#@#Order@#@#");
		experienceOrderService.getexperienceInsertPayment(Order,experiencePaymentMethod, experiencePaymentMethodNumber, experiencePaymentMoney);
		return "redirect:/shop";
	}
	
	@GetMapping("/CustomerOrderList")
	public String OrderList(Model model, HttpSession session, @RequestParam(defaultValue = "1") int currentPage) {
		String customerId = (String) session.getAttribute("loginCustomerId");
		Map<String,Object> map = experienceOrderService.getCustomerIndexExperienceOrder(customerId, currentPage, ROW_PER_PAGE);
		System.out.println(map.get("experienceOrderList").toString() + "@#@#map.get(\"experienceOrderList\")@#@#@#");
		model.addAttribute("experienceOrderList", map.get("experienceOrderList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage",currentPage);
		return "customer/experienceOrder";
	}
	
	
}
