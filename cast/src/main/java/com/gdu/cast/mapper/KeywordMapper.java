package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Keyword;

@Mapper
public interface KeywordMapper {
	// 체험 키워드 등록
	void insertExperienceKeyword(Map<String, Object> map);
	// 호텔 키워드 등록
	void insertHotelKeyword(Map<String, Object> map);
	// shop 페이지 키워드 리스트 출력
	List<Keyword> selectKeywordList();
}
