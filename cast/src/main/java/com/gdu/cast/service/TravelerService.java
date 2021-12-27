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
		return travelerMapper.selectTravelerId(travelerId);
	}
	
	// 회원 탈퇴(delete_id 테이블에 id 값 입력)
	public void getAddDeleteTravelerId(String travlerId) {
		travelerMapper.insertDeleteTravelerId(travlerId);
	}
	
	// 회원 탈퇴(traveler 테이블 데이터 삭제)
	public void getRemoveTraveler(String travelerId, String travelerPw) {
		travelerMapper.deleteTraveler(travelerId, travelerPw);
	}
	
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
