package com.gdu.cast.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KeywordMapper {
	// 체험 키워드 등록
	void insertExperienceKeyword(Map<String, Object> map);
}
