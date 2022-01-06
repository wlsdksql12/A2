package com.gdu.cast.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminChartMapper {
	// 관리자 메인 페이지 차트
	Map<String, Object> selectAmountOfMonthByYear(int year);
}
