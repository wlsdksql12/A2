package com.gdu.cast.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.cast.service.ExhibitionService;
import com.gdu.cast.service.MainSelectService;
import com.gdu.cast.vo.Exhibition;
import com.sun.tools.javac.util.Log;

@Controller
public class IndexController {
	@Autowired ExhibitionService exhibitionService;
	@Autowired MainSelectService mainSelectService;
	// localhost로 주소검색해도 "index" Controller가 실행이 되도록 함
	@GetMapping(value={"/","/index"})
	public String index(HttpSession session, Model model) {
		
		System.out.println("loginCustomerId"+session.getAttribute("loginCustomerId"));
		System.out.println("loginAdminId"+session.getAttribute("loginAdminId"));
		System.out.println("loginTravelerId"+session.getAttribute("loginTravelerId"));
		System.out.println("loginCeoId"+session.getAttribute("loginCeoId"));
		
		// 메인페이지 전시소개 리스트
		List<Exhibition> exhibitionList = exhibitionService.getExhibitionList1();
		
		model.addAttribute("exhibitionList", exhibitionList);
		model.addAttribute("loginCustomerId", session.getAttribute("loginCustomerId"));
		model.addAttribute("loginTravelerId",session.getAttribute("loginTravelerId"));
		model.addAttribute("loginAdminId",session.getAttribute("loginAdminId"));
		model.addAttribute("loginCeoId",session.getAttribute("loginCeoId"));
		
		return "index";
	}
	@GetMapping("/shop")
	public String shop(Model model, String themeSmallName) {
		Map<String, Object> map = mainSelectService.selectTheme();
		Map<String, Object> ThemeSmallmap = mainSelectService.selectThemeSmall();
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ"+map.get("selectThemeList")+"ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
		System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆"+ThemeSmallmap.get("selectThemeSmallList")+"★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println("★☆★☆★☆★☆★☆★☆★☆"+themeSmallName+"★☆★☆★☆★☆★☆★☆★☆ThemeShopList");
		model.addAttribute("selectThemeList", map.get("selectThemeList"));
		model.addAttribute("selectThemeSmallList", ThemeSmallmap.get("selectThemeSmallList"));
		Map<String, Object> themeSmallListmap = mainSelectService.selectThemeShopList(themeSmallName);
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ"+themeSmallListmap.get("selectThemeShopList")+"ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁselectThemeShopList");
		model.addAttribute("selectThemeShopList", themeSmallListmap.get("selectThemeShopList"));
		return "shop";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	@GetMapping("/shopsingle")
	public String shopsingle() {
		return "shop-single";
	}

}
