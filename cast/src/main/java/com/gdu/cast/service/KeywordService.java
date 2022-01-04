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
	public Map<String, Object> getKeywordList(String searchKeyword, int currentPage, int ROW_PER_PAGE){
		System.out.println("000000000000000000000000000"+searchKeyword+"000000000000000000000000");
		Map<String, Object> map = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		
		List<Keyword> selectShopKeywordList = keywordMapper.selectKeywordList();
		
		Map<String, Object> returnMap = new HashMap<>();
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		int totalCount = keywordMapper.selectKeywordSelectTotalCount(searchKeyword);
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		
		returnMap.put("selectShopKeywordList", selectShopKeywordList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}

}
