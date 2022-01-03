package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.ExperiencePaymentReview;
import com.gdu.cast.vo.ExperiencePaymentReviewImage;

@Mapper
public interface MainExperienceOrHotelReviewMapper {
	List<ExperiencePaymentReview> experiencePaymentReview(Map<String, Object> map);
	
	int selectExperienceReviewTotalCount();
	
}
