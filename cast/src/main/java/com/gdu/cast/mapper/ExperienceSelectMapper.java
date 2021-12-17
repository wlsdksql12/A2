package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.ExperienceSelect;

@Mapper
public interface ExperienceSelectMapper {
	
	// 체험 추천 추가
	void insertExperienceSelect(ExperienceSelect experienceSelect);
	
	// 체험 추천 삭제
	int deleteExperienceSelect(ExperienceSelect experienceSelect);
	
	// 체험 추천 수정
	int updateExperienceSelect(ExperienceSelect experienceSelect);
	
	// 체험 추천 상세보기
	ExperienceSelect selectExperienceSelectOne(int experienceSelectId);
	
	// 자신이 쓴 체험 추천 리스트 
	List<ExperienceSelect> selectExperienceList(Map<String, Object> map);
	
	// 자신이 쓴 체험 추천 전체 글 수
	int selectExperienceTotalCount(String travelerId);
}
