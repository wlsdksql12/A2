package com.gdu.cast.vo;

import lombok.Data;

@Data
// 객실이미지
public class RoomImage {
	private int roomImageId;
	private int roomId;
	private long imageSize;
	private String imageExt;
	private String imageName;
	private String createDate;
	private String updateDate;
}
