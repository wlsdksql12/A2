package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.RoomSelect;
import com.gdu.cast.vo.Traveler;

@Mapper
public interface TravelerMapper {
	// 숙소 추천 추가
		void insertRoomSelect(RoomSelect roomSelect);
	
	// 숙소 추천 삭제
	int deleteRoomSelect(RoomSelect roomSelect);
		
	// 숙소 추천 수정
	int updateRoomSelect(RoomSelect roomSelect);
	
	// 숙소 추천 상세보기
	RoomSelect selectRoomSelectOne(int RoomSelectId);
	
	// 숙소 추천 리스트
	List<RoomSelect> selectRoomSelectList(Map<String, Object> map);
	
	// 숙소 추천 전체 글 수
	int selectRoomSelectTotalCount(String searchTitle);
	
	// 여행작가 로그인
	Traveler selectTraveler(Traveler traveler);
	
	// 여행작가 회원가입
	int insertTraveler(Traveler traveler);
}
