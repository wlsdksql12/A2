package com.gdu.cast.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Traveler;

@Mapper
public interface TravelerMapper {
	
	/*
	// 여행작가 메인 페이지 자신이 쓴 체험 추천 리스트 출력(5개)
	List<ExperienceSelect> selectExperienceListByMain(Map<String, Object> map);
	
	// 여행작가 메인 페이지 자신이 쓴 숙소 추천 리스트 출력(5개)
	List<RoomSelect> selectRoomSelectListByMain(Map<String, Object> map);
	*/
	
	// 여행작가 내정보 수정
	int updateTravelerMyInfo(Traveler traveler);
	
	// 여행작가 내정보 보기
	Traveler selectTravelerMyInfo(String TravelerId);
	
	// 여행작가 로그인
	Traveler selectTraveler(Traveler traveler);
	
	// 여행작가 회원가입
	int insertTraveler(Traveler traveler);
}
