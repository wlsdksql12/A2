package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.ExperienceSelect;

@Mapper
public interface ExperienceSelectMapper {
	
	// 체험 추천 리스트 
	List<ExperienceSelect> selectExperienceList(Map<String, Object> map);
	
	// 체험 추천 전체 글 수
	int selectExperienceTotalCount(String searchTitle);
}
