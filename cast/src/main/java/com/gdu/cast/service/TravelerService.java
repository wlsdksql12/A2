package com.gdu.cast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.TravelerMapper;
import com.gdu.cast.vo.Traveler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class TravelerService {
	
	@Autowired
	TravelerMapper travelerMapper;
			
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
