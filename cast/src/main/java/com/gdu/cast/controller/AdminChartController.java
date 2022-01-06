package com.gdu.cast.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.cast.mapper.AdminChartMapper;

@RestController
public class AdminChartController {
	@Autowired AdminChartMapper adminChartMapper;
	
	// 관리자 메인 페이지 분기별 매출 차트
	@GetMapping("/admin/getQuarterChart")
	public Map<String, Object> getQuarterChart(int year){
		Map<String, Object> chartMap = adminChartMapper.selectAmountOfMonthByYear(year);
		return chartMap;
	}

}
