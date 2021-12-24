package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.KeywordMapper;
import com.gdu.cast.vo.Keyword;

@Service
public class KeywordService {
	@Autowired
	KeywordMapper keywordMapper;
	
	// 체험 키워드 등록
	public void insertExperienceKeyword(String keyword, int experienceId) {
		System.out.println(keyword + "키워드");
		System.out.println(experienceId + "experienceId");
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("experienceId", experienceId);
		System.out.println(map.toString());
		keywordMapper.insertExperienceKeyword(map);
	}
	
	// 호텔 키워드 등록
	public void insertHotelKeyword(String keyword, int hotelId) {
		System.out.println(keyword + "키워드");
		System.out.println(hotelId + "hotelId");
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("hotelId", hotelId);
		System.out.println(map.toString());
		keywordMapper.insertHotelKeyword(map);
	}
	
	// shop페이지 키워드 리스트 출력
	public List<Keyword> getKeywordList(){
		return keywordMapper.selectKeywordList();
	}
}
