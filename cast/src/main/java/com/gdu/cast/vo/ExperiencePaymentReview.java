package com.gdu.cast.vo;

import lombok.Data;

@Data
public class ExperiencePaymentReview {
	private int experiencePaymentReviewId;
	private int experiencePaymentId;
	private String experiencePaymentReviewContent;
	private int experienceId;
	private String createDate;
	private String dupateDate;
}
