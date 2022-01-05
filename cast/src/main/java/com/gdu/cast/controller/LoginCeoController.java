package com.gdu.cast.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.mapper.CeoMapper;
import com.gdu.cast.service.CeoService;
import com.gdu.cast.service.JoinRequestService;
import com.gdu.cast.vo.Ceo;
import com.gdu.cast.vo.Experience;
import com.gdu.cast.vo.ExperienceWishList;
import com.gdu.cast.vo.Hotel;

@Controller
public class LoginCeoController {
	@Autowired
	CeoService ceoService;
	@Autowired
	JoinRequestService joinRequestService;
	@Autowired
	CeoMapper ceoMapper;
	
	// 사업자 메인 페이지
	@GetMapping("/ceo/ceoIndex")
	public String ceoIndex(Model model, HttpSession session, String ceoId) {
		
		// 메인페이지에 체험리스트
		List<Experience> experienceList = ceoService.getselectExperienceIndex(ceoId);
		model.addAttribute("experienceList",experienceList);
		
		// 메인페이지에 호텔리스트
		List<Hotel> hotelList = ceoService.getselectHotelIndex(ceoId);
		model.addAttribute("hotelList", hotelList);
		
		ExperienceWishList experienceWishList = ceoService.selectExpWish(ceoId);
		model.addAttribute("experienceWishList", experienceWishList);
		String state = joinRequestService.getCeoJoinRequestResult((String)session.getAttribute("loginCeoId"));
		session.setAttribute("state", state);
		System.out.println(state + " <<< LoginCeoController");
		System.out.println(experienceWishList);
		return "ceo/ceoIndex";
	}
	
	// 로그인 페이지
	@GetMapping("/ceoLogin")
	public String ceoLogin() {
		return "ceo/ceoLogin";
	}
	
	// 로그인 페이지
	@PostMapping("/ceoLogin")
	public String loginCeo(HttpSession session, Ceo ceo) {
		Ceo loginCeo = ceoService.loginCeo(ceo);
		
		if(loginCeo == null) {
		return "redirect:/ceoLogin";
		}
		
		session.setAttribute("loginCeoId", loginCeo.getCeoId());
		
		return "redirect:/ceoIndex";
	}
	
	// 로그아웃
	@GetMapping("/ceoLogout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/loginSelect";
	}
	
	//
	@GetMapping("/ceo/getExperienceMonth")
	public Map<String, Object> getExperienceMonth(int year, HttpSession session) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("year", year);
		paramMap.put("ceoId", ceoId);
		
		System.out.println(year + "year");
		System.out.println(ceoId + "ceoId");
		
		Map<String, Object> returnmap = ceoMapper.selectExperienceMonth(paramMap);
		return returnmap;
	}
}
