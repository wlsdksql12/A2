package com.gdu.cast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.ExperienceWishListMapper;
import com.gdu.cast.vo.ExperienceWishList;

@Service
public class ExperienceWishListService {
	@Autowired ExperienceWishListMapper experienceWishListMapper;
	
	public void getinsertExperienceWishList(String customerId, int experienceId) {
		experienceWishListMapper.insertExperienceWishList(customerId, experienceId);
	}
	
	public List<ExperienceWishList> getselectExperienceWishList(String customerId) {
		return experienceWishListMapper.selectExperienceWishList(customerId);
	}
}
