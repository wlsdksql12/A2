package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.TravelerMapper;
import com.gdu.cast.vo.RoomSelect;
import com.gdu.cast.vo.Traveler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class TravelerService {
		@Autowired
		TravelerMapper travelerMapper;
		
	// 여행작가 숙소 추천 추가
	public void addRoomSelect(RoomSelect roomSelect) {
		travelerMapper.insertRoomSelect(roomSelect);
	}
	
	// 여행작가 숙소 추천 삭제
	public void removeRoomSelect(RoomSelect roomSelect) {
		log.debug("★★★★Hyun★★★★"+roomSelect.toString());
		travelerMapper.deleteRoomSelect(roomSelect);
	}
	
	// 여행작가 숙소 추천 수정
	public void modifyRoomSelect(RoomSelect roomSelect) {
		log.debug("★★★★Hyun★★★★"+roomSelect.toString());
		travelerMapper.updateRoomSelect(roomSelect);
	}

	// 여행작가 숙소 추천 상세보기
	public RoomSelect getroomSelectOne(int RoomSelectId) {
		RoomSelect roomSelect = travelerMapper.selectRoomSelectOne(RoomSelectId);
		return roomSelect;
	}
		
	// 여행작가 숙소 추천 리스트
	public Map<String, Object> getselectRoomSelectList(String searchTitle, int currentPage, int ROW_PER_PAGE) {
		
		// 1) 매개변수 가공
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow); 
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("searchTitle", searchTitle);
		log.debug(searchTitle);
		
		// 여행작가 숙소 추천 리스트
		List<RoomSelect> roomSelectList = travelerMapper.selectRoomSelectList(paramMap);
		
		// 2) 리턴값 가공
		Map<String, Object> returnMap = new HashMap<>();
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		int totalCount = travelerMapper.selectRoomSelectTotalCount(searchTitle);
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		returnMap.put("roomSelectList", roomSelectList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
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
