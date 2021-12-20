package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.ExperienceSelectMapper;
import com.gdu.cast.vo.ExperienceSelect;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ExperienceSelectService {
	
	@Autowired
	ExperienceSelectMapper experienceSelectMapper;
	
	// 여행작가 체험 추천 추가
	public void addExperienceSelect(ExperienceSelect experienceSelect) {
		log.debug("★★★★Hyun★★★★"+experienceSelect.toString());
		experienceSelectMapper.insertExperienceSelect(experienceSelect);
	}
	
	// 여행작가 체첨 추천 삭제
	public void removeExperienceSelect(ExperienceSelect experienceSelect) {
		log.debug("★★★★Hyun★★★★"+experienceSelect.toString());
		experienceSelectMapper.deleteExperienceSelect(experienceSelect);
	}
	
	// 자신이 등록한 체첨 추천 수정
	public void modifyExperienceSelect(ExperienceSelect experienceSelect) {
		log.debug("★★★★Hyun★★★★"+experienceSelect.toString());
		experienceSelectMapper.updateExperienceSelect(experienceSelect);
	}
	
	// 자신이 등록한 체험 추천 상세보기
	public ExperienceSelect getexperienceSelectOne(int experienceSelectId, String travelerId) {
		System.out.println(experienceSelectId + "<-- experienceSelectId");
		System.out.println(travelerId + "<-- travelerId");
		ExperienceSelect experienceSelect = experienceSelectMapper.selectExperienceSelectOne(experienceSelectId, travelerId);
		return experienceSelect;
	}
	
	// 자신이 등록한 체험 추천 리스트
	public Map<String, Object> getSelectExperienceSelectList(String travelerId, int currentPage, int ROW_PER_PAGE) {
		
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
		log.debug(travelerId);
		
		// 여행작가 체험 추천 리스트
		List<ExperienceSelect> experienceSelectList = experienceSelectMapper.selectExperienceList(paramMap);
		
		// 2) 리턴값 가공
		Map<String, Object> returnMap = new HashMap<>();
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		int totalCount = experienceSelectMapper.selectExperienceTotalCount(travelerId);
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		returnMap.put("experienceSelectList", experienceSelectList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
}
