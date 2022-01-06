package com.gdu.cast.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.cast.mapper.CeoMapper;

@RestController
public class CeoChartController {
	@Autowired CeoMapper ceoMapper;
	
	// 메인 페이지 체험 차트
	@GetMapping("/getExpTotalInOfMonthByYear")
	public Map<String, Object> getCeoExpTotalInOfMonthByYear(int year, HttpSession session){
		String ceoId = (String) session.getAttribute("loginCeoId");
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("year", year);
		paramMap.put("ceoId", ceoId);
		
		System.out.println(year + "year");
		System.out.println(ceoId+"ceoId");
		
		Map<String, Object> returnmap = ceoMapper.selectExperienceMonth(paramMap);
		System.out.println("@@@@@@@@@@@@"+returnmap.toString());
		return returnmap;
	}
	// 메인 페이지 숙소 차트
	@GetMapping("/getRoomTotalInOfMonthByYear")
	public Map<String, Object> getRoomTotalInOfMonthByYear(int year, HttpSession session){
		String ceoId = (String) session.getAttribute("loginCeoId");
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("year", year);
		paramMap.put("ceoId", ceoId);
		
		System.out.println(year + "year");
		System.out.println(ceoId+"ceoId");
		
		Map<String, Object> returnmap = ceoMapper.selectRoomMonth(paramMap);
		System.out.println("@@@@@@@@@@@@"+returnmap.toString());
		return returnmap;
	}
}
