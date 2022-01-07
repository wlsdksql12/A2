package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.TravelerMapper;
import com.gdu.cast.vo.Experience;
import com.gdu.cast.vo.ExperienceSelect;
import com.gdu.cast.vo.ExperienceSelectComment;
import com.gdu.cast.vo.Hotel;
import com.gdu.cast.vo.RoomSelect;
import com.gdu.cast.vo.RoomSelectComment;
import com.gdu.cast.vo.Traveler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class TravelerService {
	
	@Autowired
	TravelerMapper travelerMapper;
	
	// 자신이 등록한 체험 추천 댓글 알람
	public List<ExperienceSelect> getExperienceSelectAlarm(String travlerId) {
		log.debug("★★★★Hyun★★★★"+travlerId);
		
		return travelerMapper.selectExperienceSelectAlram(travlerId);
	}
	
	// 자신이 등록한 숙소 추천 댓글 알람
	public List<RoomSelect> getRoomSelectAlarm(String travlerId) {
		log.debug("★★★★Hyun★★★★"+travlerId);
		
		return travelerMapper.selectRoomSelectAlarm(travlerId);
	}
	
	// 최근 체험 등록 리스트(5개)
	public List<Experience> getSelectExperienceListByMain() {
		return travelerMapper.selectExperienceListByMain();
	}
	
	// 최근 호텔 등록 리스트(5개)
	public List<Hotel> getSelectHotelListByMain() {
		return travelerMapper.selectHotelListByMain();
	}
	
	// 자신이 등록한 체험 추천 글의 댓글 리스트
	public Map<String, Object> getSelectExperienceSelectCommentList(String travelerId, int currentPage, int ROW_PER_PAGE) {
		
		// 1) 매개변수 가공
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow); 
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("travelerId", travelerId);
		log.debug("★★★★Hyun★★★★"+paramMap);
		
		// 체험 추천 글의 댓글 리스트
		List<ExperienceSelectComment> experienceSelectCommentList = travelerMapper.selectExperienceSelectCommentList(paramMap);
		log.debug("★★★★Hyun★★★★"+experienceSelectCommentList.toString());
		
		// 2) 리턴값 가공
		Map<String, Object> returnMap = new HashMap<>();
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		int totalCount = travelerMapper.selectExperienceSelectCommentTotalCount(travelerId);
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		returnMap.put("travelerId", travelerId);
		returnMap.put("experienceSelectCommentList", experienceSelectCommentList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		log.debug("★★★★Hyun★★★★"+returnMap.toString());
		
		return returnMap;
	}
	
	// 자신이 등록한 숙소 추천 글의 댓글 리스트
	public Map<String, Object> getSelectRoomSelectCommentList(String travelerId, int currentPage, int ROW_PER_PAGE) {
		
		// 1) 매개변수 가공
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow); 
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("travelerId", travelerId);
		log.debug("★★★★Hyun★★★★"+travelerId);
		
		// 숙소 추천 글의 댓글 리스트
		List<RoomSelectComment> roomSelectCommentList = travelerMapper.selectRoomSelectCommentList(paramMap);
		log.debug("★★★★Hyun★★★★"+roomSelectCommentList.toString());
		
		// 2) 리턴값 가공
		Map<String, Object> returnMap = new HashMap<>();
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		int totalCount = travelerMapper.selectRoomSelectCommentTotalCount(travelerId);
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		returnMap.put("travelerId", travelerId);
		returnMap.put("roomSelectCommentList", roomSelectCommentList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		log.debug("★★★★Hyun★★★★"+returnMap.toString());
		
		return returnMap;
	}
	
	// 여행작가 메인 페이지 자신이 등록한 체험 추천 리스트 댓글 출력(5개)
	public List<ExperienceSelectComment> getselectExperienceSelectCommentListByMain(String travelerId) {
		log.debug("★★★★Hyun★★★★"+travelerId);
		return travelerMapper.selectExperienceSelectCommentListByMain(travelerId);
	}
	
	// 여행작가 메인 페이지 자신이 등록한 숙소 추천 리스트 댓글 출력(5개)
	public List<RoomSelectComment> getselectRoomSelectCommentListByMain(String travelerId) {
		log.debug("★★★★Hyun★★★★"+travelerId);
		return travelerMapper.selectRoomSelectCommentListByMain(travelerId);
	}
	
	// 여행작가 비밀번호 변경
	public int modifyTravelerPw(String travelerId, String travelerPw, String newTravelerPw) {
		log.debug("★★★★Hyun★★★★"+travelerId);
		log.debug("★★★★Hyun★★★★"+travelerPw);
		log.debug("★★★★Hyun★★★★"+newTravelerPw);
		return travelerMapper.updateTravelerPw(travelerId, travelerPw, newTravelerPw);
	}
	
	// 회원 탈퇴 한 아이디의 중복값
	public int getSelectDeleteTravelerId(String travelerId) {
		log.debug("★★★★Hyun★★★★"+travelerId);
		int row = travelerMapper.selectDeleteTravelerId(travelerId);
		return row;
	}
	
	// 회원 가입 시 아이디 중복 검사
	public String getSelectTravelerId(String travelerId) {
		log.debug("★★★★Hyun★★★★"+travelerId);
		return travelerMapper.selectTravelerId(travelerId);
	}
	
	// 회원 탈퇴 시 비밀번호 조회
	public int getSelectTravelerPw(String travelerId, String travelerPw) {
		log.debug("★★★★Hyun★★★★"+travelerId);
		log.debug("★★★★Hyun★★★★"+travelerPw);
		return travelerMapper.selectTravelerPw(travelerId, travelerPw);
	}
	
	// 회원 탈퇴(delete_id 테이블에 id 값 입력)
	public void getAddDeleteTravelerId(String travelerId) {
		log.debug("★★★★Hyun★★★★"+travelerId);
		travelerMapper.insertDeleteTravelerId(travelerId);
	}
	
	// 회원 탈퇴(traveler 테이블 데이터 삭제)
	public void getRemoveTraveler(String travelerId, String travelerPw) {
		log.debug("★★★★Hyun★★★★"+travelerId);
		log.debug("★★★★Hyun★★★★"+travelerPw);
		travelerMapper.deleteTraveler(travelerId, travelerPw);
	}
	
	// 여행작가 메인 페이지 자신이 등록한 체험 추천 리스트 출력(5개)
	public List<ExperienceSelect> getselectExperienceSelectListByMain(String travelerId) {
		log.debug("★★★★Hyun★★★★"+travelerId);
		return travelerMapper.selectExperienceSelectListByMain(travelerId);
	}
	
	// 여행작가 메인 페이지 자신이 등록한 숙소 추천 리스트 출력(5개)
	public List<RoomSelect> getselectRoomSelectListByMain(String travelerId) {
		log.debug("★★★★Hyun★★★★"+travelerId);
		return travelerMapper.selectRoomSelectListByMain(travelerId);
	}
	
	// 여행작가 내정보 수정
	public void modifyTravelerMyInfo(Traveler traveler) {
		log.debug("★★★★Hyun★★★★"+traveler.toString());
		travelerMapper.updateTravelerMyInfo(traveler);
	}
	
	// 여행작가 내정보 보기
	public Traveler getTravelerMyInfo(String travlerId) {
		log.debug("★★★★Hyun★★★★"+travlerId);
		return travelerMapper.selectTravelerMyInfo(travlerId);
	}
	
	// 여행작가 로그인
	public Traveler getSelectTraveler(Traveler traveler) {
		log.debug("★★★★Hyun★★★★"+traveler.toString());
		return travelerMapper.selectTraveler(traveler);
	}
	
	// 여행작가 회원가입
	public void addTraveler(Traveler traveler) {
		log.debug("★★★★Hyun★★★★"+traveler.toString());
		travelerMapper.insertTraveler(traveler);
	}
}
