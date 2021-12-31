package com.gdu.cast.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.cast.mapper.CustomerChartMapper;

@RestController
public class CustomerChartController {
	@Autowired CustomerChartMapper customerChartMapper;
	
	// 고객 메인 페이지 체험 차트
	@GetMapping("/getTotalInOfMonthByYear")
	public Map<String, Object> getTotalInOfMonthByYear(int year, String experiencePaymentMethod, HttpSession session){
		String customerId = (String) session.getAttribute("loginCustomerId");
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("year", year);
		paramMap.put("experiencePaymentMethod", experiencePaymentMethod);
		paramMap.put("customerId", customerId);
		
		System.out.println(year + "year");
		System.out.println(customerId+"customerId");
		
		Map<String, Object> returnmap = customerChartMapper.selectTotalInOfMonthByYear(paramMap);
		return returnmap;
	}
	
	// 고객 메인 페이지 숙소 차트
	@GetMapping("/getHotelTotalInOfMonthByYear")
	public Map<String, Object> getselectHotelTotalInOfMonthByYear(int year, HttpSession session){
		
		String customerId = (String) session.getAttribute("loginCustomerId");
		
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("year", year);
		paramMap.put("customerId", customerId);
		
		System.out.println(year + "year");
		System.out.println(customerId+"customerId");
		
		Map<String, Object> returnmap = customerChartMapper.selectHotelTotalInOfMonthByYear(paramMap);
		return returnmap;
	}
	
	
	@GetMapping("/getExperienceMonthByYear")
	public Map<String, Object> getExperienceMonthByYear(int year, String experiencePaymentMethod, HttpSession session){
		String customerId = (String) session.getAttribute("loginCustomerId");
		
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("year", year);
		paramMap.put("customerId", customerId);
		paramMap.put("experiencePaymentMethod", experiencePaymentMethod);
		
		System.out.println(year + "year");
		System.out.println(customerId+"customerId");
		
		Map<String, Object> returnmap = customerChartMapper.selectExperienceMonthByYear(paramMap);
		return returnmap;
	}
	
	@GetMapping("/getRoomMonthByYear")
	public Map<String, Object> getRoomMonthByYear(int year, String roomPaymentMethod, HttpSession session){
		String customerId = (String) session.getAttribute("loginCustomerId");
		
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("year", year);
		paramMap.put("customerId", customerId);
		paramMap.put("roomPaymentMethod", roomPaymentMethod);
		
		System.out.println(year + "year");
		System.out.println(customerId+"customerId");
		
		Map<String, Object> returnmap = customerChartMapper.selectRoomMonthByYear(paramMap);
		return returnmap;
	}
	
	
}
