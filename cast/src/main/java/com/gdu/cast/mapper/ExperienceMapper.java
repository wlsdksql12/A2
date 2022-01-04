package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Experience;
import com.gdu.cast.vo.ExperienceImage;

@Mapper
public interface ExperienceMapper {
	// 체험 등록
	int insertExp(Experience experience);
	// 체험 이미지 추가
	int insertExperienceImage(ExperienceImage experienceImage);
	// 체험 이미지
	List<ExperienceImage> ExperienceImageList(int experienceId);
	// 주소 추가
	int insertExpAddress(Address address);
	// 체험 리스트 출력
	List<Experience> selectExperienceList(Map<String, Object> map);
	// 체험 상세보기
	Experience selectExperienceOne(int experienceId);
	// 체험 전체 글 수
	int selectExperienceTotalCount(String searchTitle);
	// 체험수정
	int updateExperience(Experience experience);
	// 체험삭제
	int deleteExperience(Experience experience);
	// 체험추가 시 추가한 체험id 출력
	int selectExperienceId(Experience experience);
	// 테마 체험 등록
	void insertThemeExperience(Map<String, Object> map);
	
}