package com.gdu.cast.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Traveler;

@Mapper
public interface TravelerMapper {
	
	// 여행작가 내정보 보기
	Traveler selectTravelerMyInfo(String TravelerId);
	
	// 여행작가 로그인
	Traveler selectTraveler(Traveler traveler);
	
	// 여행작가 회원가입
	int insertTraveler(Traveler traveler);
}
