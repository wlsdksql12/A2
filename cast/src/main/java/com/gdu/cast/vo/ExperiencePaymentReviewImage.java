package com.gdu.cast.vo;

import lombok.Data;

@Data
public class ExperiencePaymentReviewImage {
	private int experiencePaymentReviewImageId;
	private int experiencePaymentReviewId;
	private String imageName;
	private long imageSize;
	private String imageExt;
	private String createDate;
	private String updateDate;
}
