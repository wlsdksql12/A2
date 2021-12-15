package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.ExperienceSelect;
import com.gdu.cast.vo.RoomSelect;

@Mapper
public interface MainSelectMapper {
	
	// 메인 페이지의 체험 추천 리스트 
	List<ExperienceSelect> selectExperienceList(Map<String, Object> map);
	
	// 메인 페이지의 체험 추천 전체 글 수
	int selectExperienceTotalCount(String searchTitle);

	// 메인 페이지의 숙소 추천 리스트
	List<RoomSelect> selectRoomSelectList(Map<String, Object> map);
	
	// 메인 페이지의 숙소 추천 전체 글 수
	int selectRoomSelectTotalCount(String searchTitle);
	
}
