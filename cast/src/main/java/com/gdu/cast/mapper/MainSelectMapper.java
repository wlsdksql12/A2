package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.ExperienceSelect;
import com.gdu.cast.vo.ExperienceSelectImage;
import com.gdu.cast.vo.RoomSelect;
import com.gdu.cast.vo.RoomSelectImage;
import com.gdu.cast.vo.ThemeMiddle;
import com.gdu.cast.vo.ThemeSmall;
import com.gdu.cast.vo.ThemeSmallExperience;
import com.gdu.cast.vo.ThemeSmallHotel;

@Mapper
public interface MainSelectMapper {
	
	// 메인 페이지 이미지 수정
	int updateRoomSelectImage(RoomSelectImage roomSelectImage);
	
	// 메인 페이지 체험 추천 이미지 삭제
	int deleteExperienceSelectImage(ExperienceSelect experienceSelect);
	
	// 메인 페이지 숙소 추천 이미지 삭제
	int deleteRoomSelectImage(RoomSelect roomSelect);
	
	// 메인 페이지 숙소 추천 이미지
	List<RoomSelectImage> selectRoomImageList(int roomSelectId);
	
	// 메인 페이지 체험 추천 이미지
	List<ExperienceSelectImage> selectExperienceImageList(int experienceSelectId);
	
	// 메인 페이지 체험 추천 삭제
	int deleteExperienceSelect(ExperienceSelect experienceSelect);
	
	// 메인 페이지 체험 추천 수정
	int updateExperienceSelect(ExperienceSelect experienceSelect);
	
	// 메인 페이지 숙소 추천 삭제
	int deleteRoomSelect(RoomSelect roomSelect);
		
	// 메인 페이지 숙소 추천 수정
	int updateRoomSelect(RoomSelect roomSelect);
	
	// 메인 페이지 체험 추천 상세보기
	ExperienceSelect selectExperienceSelectOne(int experienceSelectId);
	
	// 메인페이지의 숙소 추천 상세보기
	RoomSelect selectRoomSelectOne(int RoomSelectId);
	
	// 메인 페이지의 체험 추천 리스트 
	List<ExperienceSelect> selectExperienceList(Map<String, Object> map);
	
	// 메인 페이지의 체험 추천 전체 글 수
	int selectExperienceTotalCount(String searchTitle);

	// 메인 페이지의 숙소 추천 리스트
	List<RoomSelect> selectRoomSelectList(Map<String, Object> map);
	
	// 메인 페이지의 숙소 추천 전체 글 수
	int selectRoomSelectTotalCount(String searchTitle);
	
	
	List<ThemeMiddle> selectThemeList();
	
	List<ThemeSmall> selectThemeSmallList();
	
	List<ThemeSmallExperience> selectThemeShopExperienceList(Map<String, Object> map);
	
	List<ThemeSmallHotel> selectThemeShopHotelList(Map<String, Object> map);
	
	int selectExperienceSelectTotalCount(Map<String, Object> map);
	
	int selectHotelSelectTotalCount(Map<String, Object> map);
}
