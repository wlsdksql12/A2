package com.gdu.cast.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.cast.mapper.CeoMapper;

public class CeoChartController {
	@Autowired CeoMapper ceoMapper;
	
	// 체험 수익
	@GetMapping("/getExperienceMonth")
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
