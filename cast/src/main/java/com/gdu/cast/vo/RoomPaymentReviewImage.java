package com.gdu.cast.vo;

import lombok.Data;

@Data
public class RoomPaymentReviewImage {
	private int roomPaymentReviewImageId;
	private int roomPaymentReviewId;
	private long imageSize;
	private String imageName;
	private String imageExt;
	private String createDate;
	private String updateDate;

}
