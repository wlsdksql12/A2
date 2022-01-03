package com.gdu.cast.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ExperiencePaymentReview {
	private int experiencePaymentReviewId;
	private int experiencePaymentId;
	private String experiencePaymentReviewContent;
	private int experienceId;
	private String createDate;
	private String updateDate;
	private ExperiencePaymentReviewImage experiencePaymentReviewImage;
	private List<MultipartFile> multiExperiencepaymentReviewImage;
	private ExperienceOrder experienceOrder;
	private ExperiencePayment experiencePayment;
}
