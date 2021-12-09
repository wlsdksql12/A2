package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Traveler;

@Mapper
public interface TravelerMapper {
	
	// 숙소 추천 글 리스트
	List<Traveler> selectRoomSelectList(Map<String, Object> map);
	
	// 숙소 추천 전체 글 수
	int selectRoomSelectTotalCount(String searchTitle);
	
	// 여행작가 로그인
	Traveler selectTraveler(Traveler traveler);
	
	// 여행작가 회원가입
	int insertTraveler(Traveler traveler);
}
