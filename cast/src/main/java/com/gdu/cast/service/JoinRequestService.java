package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.JoinRequestMapper;
import com.gdu.cast.vo.JoinTraveler;

@Service
public class JoinRequestService {
	@Autowired
	JoinRequestMapper joinRequestMapper;
	
	// 여행작가 회원가입 시 여행작가 회원가입 요청 리스트 추가
	public void addTravelerJoinRequest(String travelerId) {
		joinRequestMapper.insertTravelerJoinRequest(travelerId);
	}
	
	// 여행작가 회원가입 요청 리스트 4개 출력
	public List<JoinTraveler> getTravelerJoinRequestList4(){
		return joinRequestMapper.selectTravelerJoinRequestList4();
	}
	
	// 여행작가 가입 요청 페이지
	public Map<String, Object> getTravelerJoinRequestList(int currentPage, int ROW_PER_PAGE, String state){
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		// 검색어 디버깅
		System.out.println(state + " <----JoinRequestService");
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow);
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("state", state);
		
		// 여행작가 가입 요청 가져오기
		List<JoinTraveler> joinTravelerList = joinRequestMapper.selectTravelerJoinRequestList(paramMap);
		System.out.println(joinTravelerList + "<----JoinRequestService");
		
		// 하단 페이지 숫자에 보이는 첫번째 숫자
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		// 여행작가 가입 요청 총 글갯수
		int totalCount = joinRequestMapper.selectTravelerJoinRequestTotalCount(state);
		System.out.println(totalCount + "<----JoinRequestService");
		// 하단 페이지 숫자에 보이는 마지막 숫자
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		
		// 리턴값
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("joinTravelerList", joinTravelerList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
}
