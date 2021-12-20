package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.JoinRequestMapper;
import com.gdu.cast.vo.JoinCeo;
import com.gdu.cast.vo.JoinTraveler;
import com.gdu.cast.vo.Traveler;

@Transactional
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
	public Map<String, Object> getTravelerJoinRequestList(int currentPage, int ROW_PER_PAGE, String state, String searchTitle){
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
		paramMap.put("searchTitle", searchTitle);
		// 여행작가 가입 요청 가져오기
		List<JoinTraveler> joinTravelerList = joinRequestMapper.selectTravelerJoinRequestList(paramMap);
		System.out.println(joinTravelerList + "<----JoinRequestService");
		
		// 하단 페이지 숫자에 보이는 첫번째 숫자
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		// 여행작가 가입 요청 총 글갯수
		int totalCount = joinRequestMapper.selectTravelerJoinRequestTotalCount(state,searchTitle);
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
	
	// 관리자페이지에서 여행작가 상세보기
	public JoinTraveler getTravelerOne(int joinTravelerId) {
		System.out.println(joinTravelerId + "<----JoinRequestService");
		return joinRequestMapper.selectTravelerOne(joinTravelerId);
	}
	
	// 여행작가 가입 승인&거절
	public void updateTravelerJoinRequest(int joinTravelerId, String adminId, String state) {
		// 디버깅
		System.out.println(joinTravelerId + "<---JoinRequestService");
		System.out.println(adminId + "<---JoinRequestService");
		System.out.println(state + "<---JoinRequestService");
		
		Map<String, Object> map = new HashMap<>();
		map.put("joinTravelerId", joinTravelerId);
		map.put("adminId", adminId);
		map.put("state", state);
		
		joinRequestMapper.updateTravelerJoinRequest(map);
	}
	
	// 여행작가 로그인 시 가입 요청 결과
	public String getTravelerJoinRequestResult(String travelerId) {
		// 디버깅
		System.out.println(travelerId + "<---JoinRequestService");
		return joinRequestMapper.selectTravelerJoinRequestResult(travelerId);
	}
	
	// 여행작가 로그인 시 가입 요청 결과
	public void deleteTravelerJoinRequest(String travelerId) {
		// 디버깅
		System.out.println(travelerId + "<---JoinRequestService");
		// 선 요청 결과 삭제 후 회원가입 삭제...
		joinRequestMapper.deleteTravelerJoinRequest(travelerId);
		joinRequestMapper.deleteTravelerMembership(travelerId);
	}
	
	// -----------------------사업자----------------------------
	
	// 사업자 회원가입 시 사업자 회원가입 요청 리스트 추가
	public void addCeoJoinRequest(String ceoId) {
		joinRequestMapper.insertCeoJoinRequest(ceoId);
	}
	
	// 사업자 회원가입 요청 리스트 4개 출력
	public List<JoinCeo> getCeoJoinRequestList4(){
		return joinRequestMapper.selectCeoJoinRequestList4();
	}
	
	// 사업자 가입 요청 페이지
	public Map<String, Object> getCeoJoinRequestList(int currentPage, int ROW_PER_PAGE, String state, String searchTitle){
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
		paramMap.put("searchTitle", searchTitle);
		// 사업자 가입 요청 가져오기
		List<JoinCeo> joinCeoList = joinRequestMapper.selectCeoJoinRequestList(paramMap);
		System.out.println(joinCeoList + "<----JoinRequestService");
		
		// 하단 페이지 숫자에 보이는 첫번째 숫자
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		// 사업자 가입 요청 총 글갯수
		int totalCount = joinRequestMapper.selectCeoJoinRequestTotalCount(state, searchTitle);
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
		returnMap.put("joinCeoList", joinCeoList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
	
	// 관리자페이지에서 사업자 상세보기
	public JoinCeo getCeoOne(int joinCeoId) {
		System.out.println(joinCeoId + "<----JoinRequestService");
		return joinRequestMapper.selectCeoOne(joinCeoId);
	}
	
	// 사업자 가입 승인&거절
	public void updateCeoJoinRequest(int joinCeoId, String adminId, String state) {
		// 디버깅
		System.out.println(joinCeoId + "<---JoinRequestService");
		System.out.println(adminId + "<---JoinRequestService");
		System.out.println(state + "<---JoinRequestService");
		
		Map<String, Object> map = new HashMap<>();
		map.put("joinCeoId", joinCeoId);
		map.put("adminId", adminId);
		map.put("state", state);
		
		joinRequestMapper.updateCeoJoinRequest(map);
	}
	
	// 사업자 로그인 시 가입 요청 결과
	public String getCeoJoinRequestResult(String ceoId) {
		// 디버깅
		System.out.println(ceoId + "<---JoinRequestService");
		return joinRequestMapper.selectCeoJoinRequestResult(ceoId);
	}
	
	// 여행작가 로그인 시 가입 요청 결과
	public void deleteCeoJoinRequest(String ceoId) {
		// 디버깅
		System.out.println(ceoId + "<---JoinRequestService");
		// 선 요청 결과 삭제 후 회원가입 삭제...
		joinRequestMapper.deleteCeoJoinRequest(ceoId);
		joinRequestMapper.deleteCeoMembership(ceoId);
	}
}
