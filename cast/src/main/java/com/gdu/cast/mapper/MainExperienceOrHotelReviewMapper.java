package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.ExperiencePaymentReview;
import com.gdu.cast.vo.ExperiencePaymentReviewImage;

@Mapper
public interface MainExperienceOrHotelReviewMapper {
	//리뷰 리스트 출력
	List<ExperiencePaymentReview> experiencePaymentReview(Map<String, Object> map);
	// 리뷰 리스트 페이징
	int selectExperienceReviewTotalCount();
	// 결제한 사람만 리뷰를 추가할 수 있게...
	String selectCustomerPayment(int experienceId);
	
}
