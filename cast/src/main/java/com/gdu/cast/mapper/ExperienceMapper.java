package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Experience;

@Mapper
public interface ExperienceMapper {
	// 체험 등록
	int insertExp(Experience experience);
	// 주소 추가
	int insertExpAddress(Address address);
	// 체험 리스트 출력
	List<Experience> selectExperienceList(Map<String, Object> map);
	// 체험 상세보기
	Experience selectExperienceOne(int experienceId);
	// 체험 전체 글 수
	int selectExperienceList(String searchTitle);
}
