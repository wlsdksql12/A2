package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.JoinTraveler;
import com.gdu.cast.vo.Traveler;

@Mapper
public interface JoinRequestMapper {
	// 여행작가 회원가입 시 여행작가 회원가입 요청
	void insertTravelerJoinRequest(String travelerId);
	
	// 여행작가 가입 요청 중인 리스트 4개
	List<JoinTraveler> selectTravelerJoinRequestList4();
	
	// 여행작가 가입 요청 리스트
	List<JoinTraveler> selectTravelerJoinRequestList(Map<String, Object> map);

	// 여행작가 가입 요청 글갯수
	int selectTravelerJoinRequestTotalCount(String state);
	
	// 여행작가 상세보기
	JoinTraveler selectTravelerOne(int joinTravelerId);
	
	// 여행작가 가입 승인&거절
	void updateTravelerJoinRequest(Map<String, Object> map);
	
	// 여행작가 로그인 시 가입 요청 결과 조회
	String selectTravelerJoinRequestResult(String travelerId);
	
	// 여행작가 가입 거절시 요청 결과 삭제
	void deleteTravelerJoinRequest(String travelerId);
	
	// 여행작가 가입 거절시 여행작가 회원가입 삭제 
	void deleteTravelerMembership(String travelerId);
}
