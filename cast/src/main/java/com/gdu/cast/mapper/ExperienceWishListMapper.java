package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.ExperienceWishList;

@Mapper
public interface ExperienceWishListMapper {
	// 관심상품 등록
	void insertExperienceWishList(String customerId, int experienceId);
	// 관심상품 등록 조건문
	List<ExperienceWishList> selectExperienceWishList(String customerId);
	// 고객페이지 관심상품 조회
	List<ExperienceWishList> selectExperienceWishListList(Map<String, Object> paramMap);
	// 고객페이지 관심상품 조회페이징
	int selectExperienceWishListTotalCount(String customerId);
	
}
