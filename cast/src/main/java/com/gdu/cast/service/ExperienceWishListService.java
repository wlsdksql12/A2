package com.gdu.cast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.ExperienceWishListMapper;

@Service
public class ExperienceWishListService {
	@Autowired ExperienceWishListMapper experienceWishListMapper;
	
	public void getinsertExperienceWishList(String customerId, int experienceId) {
		experienceWishListMapper.insertExperienceWishList(customerId, experienceId);
	}
	
	public int getselectExperienceWishList(String customerId) {
		return experienceWishListMapper.selectExperienceWishList(customerId);
	}
}
