package com.gdu.cast.vo;

import lombok.Data;

@Data
// 호텔이미지
public class HotelImage {
	private int hotelImageId;
	private int hotelId;
	private String imageExt;
	private String imageName;
	private long imageSize;
	private String createDate;
	private String updateDate;
}
