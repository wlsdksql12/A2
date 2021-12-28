package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.ExperienceWishListMapper;
import com.gdu.cast.vo.ExperienceWishList;
import com.gdu.cast.vo.Qna;

@Service
public class ExperienceWishListService {
	@Autowired ExperienceWishListMapper experienceWishListMapper;
	// 관심상품 등록
	public void getinsertExperienceWishList(String customerId, int experienceId) {
		experienceWishListMapper.insertExperienceWishList(customerId, experienceId);
	}
	// 관심상품 등록 조건문
	public List<ExperienceWishList> getselectExperienceWishList(String customerId) {
		return experienceWishListMapper.selectExperienceWishList(customerId);
	}
	
	// 등록한 체험 관심상품 조회
	public Map<String, Object> getselectExperienceWishListList(String customerId, int currentPage, int ROW_PER_PAGE){
		   Map<String, Object> paramMap = new HashMap<>();
		   
		   int beginRow = (currentPage-1)*ROW_PER_PAGE;
		   paramMap.put("customerId", customerId);
		   paramMap.put("beginRow", beginRow); 
		   paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		
		   List<ExperienceWishList> wishList = experienceWishListMapper.selectExperienceWishListList(paramMap);
			Map<String, Object> returnMap = new HashMap<>();
			int lastPage = 0;
			int totalCount = experienceWishListMapper.selectExperienceWishListTotalCount(customerId);
			lastPage = totalCount / ROW_PER_PAGE;
			if(totalCount%ROW_PER_PAGE != 0) {
				lastPage += 1;
			}
			returnMap.put("wishList", wishList);
			returnMap.put("lastPage", lastPage);
			
			return returnMap;
	}
}
