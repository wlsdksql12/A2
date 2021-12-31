package com.gdu.cast.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerChartMapper {
		// 고객 메인페이지 체험 월별 결제 차트
	   Map<String, Object> selectTotalInOfMonthByYear(Map<String, Object> map);
	   // 고객 메인페이지 숙소 월별 결제 차트
	   Map<String, Object> selectHotelTotalInOfMonthByYear(Map<String, Object> map);
	   // 고객 체험 차트페이지
	   Map<String, Object> selectExperienceMonthByYear(Map<String, Object> map);
	   // 고객 숙소 차트 페이지
	   Map<String, Object> selectRoomMonthByYear(Map<String, Object> map);
}