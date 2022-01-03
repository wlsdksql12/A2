package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Exhibition;
import com.gdu.cast.vo.ExhibitionImage;

@Mapper
public interface ExhibitionMapper {
	// 전시소개 추가
	void insertExhibition(Exhibition exhibition);
	
	// 전시소개 리스트 글갯수
	int selectExhibitionTotalCount(String searchTitle);
	
	// 전시소개 리스트 출력
	List<Exhibition> selectExhibitionList(Map<String, Object> map);
	
	// 전시소개 상세보기
	List<Exhibition> selectExhibitionOne(int exhibitionNo);
	
	// 전시소개 수정
	void updateExhibition(Exhibition exhibition);
	
	// 전시소개 삭제
	void deleteExhibition(Exhibition exhibition);
	
	// 전시소개 리스트 출력
	List<Exhibition> selectExhibitionList1();
	
	// exhibitionNo 가져오기
	int selectExhibitionNo();
	
	// 전시소개 이미지 추가
	void insertExhibitionImage(ExhibitionImage exhibitionImage);
}
