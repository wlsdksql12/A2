package com.gdu.cast.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gdu.cast.mapper.MainExperienceOrHotelReviewMapper;
import com.gdu.cast.vo.ExperiencePaymentReview;
import com.gdu.cast.vo.ExperiencePaymentReviewImage;
import com.gdu.cast.vo.ExperienceSelectImage;

@Transactional
@Service
public class MainExperienceOrHotelReviewService {
	@Autowired MainExperienceOrHotelReviewMapper mainExperienceOrHotelReviewMapper;
	// 메인 체험 리스트 후기 리스트 출력.
	public Map<String, Object> getexperiencePaymentReview(int currentPage, int row_per_page,int experienceId){
		System.out.println( currentPage  +"currentPage"); 
		System.out.println( row_per_page  +"row_per_page");   
		System.out.println( experienceId  +"experienceId");   
		
		
		
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
	
	// 체험결제 아이디 매개변수
	public int getselectCustomerPaymentId(String experienceName, String customerId) {
		return mainExperienceOrHotelReviewMapper.selectCustomerPaymentId(experienceName,customerId);
		
	}

	// 리뷰 내용 추가
	public void getinsertExperiencePaymentReview(String experiencePaymentReviewContent, int experiencePaymentId, int experienceId) {
		ExperiencePaymentReview experiencePaymentReview = new ExperiencePaymentReview();
		experiencePaymentReview.setExperiencePaymentReviewContent(experiencePaymentReviewContent);
		experiencePaymentReview.setExperiencePaymentId(experiencePaymentId);
		experiencePaymentReview.setExperienceId(experienceId);
		mainExperienceOrHotelReviewMapper.insertExperiencePaymentReview(experiencePaymentReview);
	}
}
