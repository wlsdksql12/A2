package com.gdu.cast.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.IndexMapper;
import com.gdu.cast.vo.Experience;
import com.gdu.cast.vo.Hotel;

@Service
public class IndexService {
	@Autowired IndexMapper indexMapper;
	// 최근 올라온 체험 3개
	public List<Experience> getExperienceList() {
		return indexMapper.selectExpByMainPage();
	}
	// 최근 올라온 호텔 3개
	public List<Hotel> getHotelList() {
		return indexMapper.selectHotelByMainPage();
	}
	// 가장 추천이 많은 체험
	public List<Experience> getExperienceBestChoice(){
		return indexMapper.selectExpBestChoice();
	}
}
