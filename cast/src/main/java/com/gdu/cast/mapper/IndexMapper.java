package com.gdu.cast.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Experience;
import com.gdu.cast.vo.Hotel;

@Mapper
public interface IndexMapper {
	// 최근 올라온 체험 3개
	List<Experience> selectExpByMainPage();
	// 최근 올라온 호텔 3개
	List<Hotel> selectHotelByMainPage();
	
}
