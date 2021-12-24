package com.gdu.cast.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.KeywordMapper;

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
}
