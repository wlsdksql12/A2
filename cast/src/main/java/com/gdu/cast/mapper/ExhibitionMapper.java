package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Exhibition;

@Mapper
public interface ExhibitionMapper {
	// 전시소개 추가
	void insertExhibition(Exhibition exhibition);
	
	// 전시소개 리스트 글갯수
	int selectExhibitionTotalCount(String searchTitle);
	
	// 전시소개 리스트 출력
	List<Exhibition> selectExhibitionList(Map<String, Object> map);
	
	// 전시소개 상세보기
	Exhibition selectExhibitionOne(int exhibitionNo);	
}
