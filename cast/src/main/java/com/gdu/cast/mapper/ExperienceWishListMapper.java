package com.gdu.cast.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExperienceWishListMapper {
	void insertExperienceWishList(String customerId, int experienceId);
}
