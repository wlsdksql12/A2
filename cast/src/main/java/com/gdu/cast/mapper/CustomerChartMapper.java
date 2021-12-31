package com.gdu.cast.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerChartMapper {

	   Map<String, Object> selectTotalInOfMonthByYear(Map<String, Object> map);
	   
	   Map<String, Object> selectHotelTotalInOfMonthByYear(Map<String, Object> map);
	   
}