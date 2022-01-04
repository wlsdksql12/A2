package com.gdu.cast.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class RoomPaymentReview {
	private int roomPaymentReviewId;
	private int roomPaymentId;
	private int hotelId;
	private String roomPaymentReviewContent;
	private String createDate;
	private String updateDate;
	private List<RoomPaymentReviewImage> roomPaymentReviewImage;
	private List<MultipartFile> roomPaymentReviewImageUpload;
	private RoomOrder roomOrder;
	private RoomPayment roomPayment;
}
