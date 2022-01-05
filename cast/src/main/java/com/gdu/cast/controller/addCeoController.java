package com.gdu.cast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.CeoService;
import com.gdu.cast.service.JoinRequestService;
import com.gdu.cast.service.SubscriptionService;
import com.gdu.cast.vo.Ceo;
import com.gdu.cast.vo.Subscription;

@Controller
public class addCeoController {
	@Autowired CeoService ceoService;
	@Autowired JoinRequestService joinRequestService;
	@Autowired SubscriptionService subscriptionService;
	
	@GetMapping("/addCeo")
	public String getaddCustomer(Ceo ceo, Model model) {
		List<Subscription> subscriptionList = subscriptionService.SubscriptionList();
		
		System.out.println("0000000000000000000000000"+subscriptionList+"0000000000000000000000");
		model.addAttribute("subscriptionList", subscriptionList);
		return "addCeo";
		
	}
	
	@PostMapping("/addCeo")
	public String PostaddCustomer(Ceo ceo) {
		ceoService.addCeo(ceo);
		
		// 사업자 회원가입 시 사업자 회원가입 요청 리스트에 추가
		joinRequestService.addCeoJoinRequest(ceo.getCeoId());
		return "redirect:/loginSelect";
	}
}
