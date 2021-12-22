package com.gdu.cast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.TravelerMapper;
import com.gdu.cast.vo.ExperienceSelect;
import com.gdu.cast.vo.RoomSelect;
import com.gdu.cast.vo.Traveler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class TravelerService {
	
	@Autowired
	TravelerMapper travelerMapper;
	
	// 여행작가 메인 페이지 자신이 쓴 체험 추천 리스트 출력(5개)
	public List<ExperienceSelect> getselectExperienceSelectListByMain(String travelerId) {
		return travelerMapper.selectExperienceListByMain(travelerId);
	}
	
	// 여행작가 메인 페이지 자신이 쓴 숙소 추천 리스트 출력(5개)
	public List<RoomSelect> getselectRoomSelectListByMain(String travelerId) {
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
