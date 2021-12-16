package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.JoinTraveler;

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
}
