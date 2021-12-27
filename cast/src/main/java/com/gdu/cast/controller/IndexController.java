package com.gdu.cast.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.ExhibitionService;
import com.gdu.cast.service.KeywordService;
import com.gdu.cast.service.MainSelectService;
import com.gdu.cast.vo.Exhibition;
import com.gdu.cast.vo.Keyword;
import com.sun.tools.javac.util.Log;

@Controller
public class IndexController {
	@Autowired ExhibitionService exhibitionService;
	@Autowired MainSelectService mainSelectService;
	@Autowired KeywordService keywordService;
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
	public String shop(Model model, @RequestParam(defaultValue = "F1") String themeSmallName, @RequestParam(defaultValue = "전체보기") String shopCategory) {
		// 테마 대,중 출력
		Map<String, Object> map = mainSelectService.selectTheme();
		// 테마 소 리스트 출력
		Map<String, Object> ThemeSmallmap = mainSelectService.selectThemeSmall();
		// 테마 소에 해당하는 체험 리스트 출력
		Map<String, Object> themeSmallExperienceListmap = mainSelectService.selectThemeShopExperienceList(themeSmallName);
		// 테마 소에 해당하는 숙소 리스트 출력
		Map<String, Object> themeSmallHotelListmap = mainSelectService.selectThemeShopHotelList(themeSmallName);
		// shop 페이지 키워드 리스트 출력
		List<Keyword> keywordList = keywordService.getKeywordList();
		
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ"+map.get("selectThemeList")+"ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁmap.get(selectThemeList)");
		System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆"+ThemeSmallmap.get("selectThemeSmallList")+"★☆★☆★☆★☆★☆★☆★☆★☆ThemeSmallmap.get(selectThemeSmallList)");
		System.out.println("★☆★☆★☆★☆★☆★☆★☆"+themeSmallName+"★☆★☆★☆★☆★☆★☆★☆ThemeShopList");
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ"+themeSmallExperienceListmap.get("selectThemeShopExperienceList")+"ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁselectThemeShopExperienceList");
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ"+themeSmallHotelListmap.get("selectThemeShopHotelList")+"ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁselectThemeShopHotelList");
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ"+shopCategory+"ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁshopCategory");
		model.addAttribute("selectThemeList", map.get("selectThemeList"));
		model.addAttribute("selectThemeSmallList", ThemeSmallmap.get("selectThemeSmallList"));
		model.addAttribute("selectThemeShopExperienceList", themeSmallExperienceListmap.get("selectThemeShopExperienceList"));
		model.addAttribute("selectThemeShopHotelList", themeSmallHotelListmap.get("selectThemeShopHotelList"));
		model.addAttribute("keywordList",keywordList);
		model.addAttribute("shopCategory",shopCategory);
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
