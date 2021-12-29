package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.MainExperienceOrHotelReviewMapper;
import com.gdu.cast.vo.ExperiencePaymentReview;

@Service
public class MainExperienceOrHotelReviewService {
	@Autowired MainExperienceOrHotelReviewMapper mainExperienceOrHotelReviewMapper;
	
	public Map<String, Object> getexperiencePaymentReview(int currentPage, int row_per_page,int experienceId){
		   Map<String, Object> paramMap = new HashMap<>();
			
		   int beginRow = 0;
			int displayPage = 10;
			int startPage = 0;
			int lastPage = 0;
		   beginRow = (currentPage-1)*row_per_page;
		   paramMap.put("beginRow", beginRow); 
		   paramMap.put("ROW_PER_PAGE", row_per_page);
		   paramMap.put("experienceId", experienceId);
		   List<ExperiencePaymentReview> ExperienceReviewList = mainExperienceOrHotelReviewMapper.experiencePaymentReview(paramMap);
		   
		   startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		   
		   
		   
		   int totalCount = mainExperienceOrHotelReviewMapper.selectExperienceReviewTotalCount();
			System.out.println(totalCount + " <---selectCommentTotalCount");
			lastPage = startPage + displayPage - 1;
			int totalPage = totalCount / row_per_page;
			if(totalCount % row_per_page != 0) {
				totalPage += 1;
			}
			if(lastPage > totalPage) {
				lastPage = totalPage;
			}
			
			// 리턴값
			Map<String, Object> returnMap = new HashMap<>();
			returnMap.put("ExperienceReviewList", ExperienceReviewList);
			returnMap.put("startPage", startPage);
			returnMap.put("lastPage", lastPage);
			returnMap.put("totalPage", totalPage);
			
			return returnMap;
	}
}
