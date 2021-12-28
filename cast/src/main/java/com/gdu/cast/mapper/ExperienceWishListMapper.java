package com.gdu.cast.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.ExperienceWishList;

@Mapper
public interface ExperienceWishListMapper {
	void insertExperienceWishList(String customerId, int experienceId);
	List<ExperienceWishList> selectExperienceWishList(String customerId);
}
