package com.gdu.cast.vo;

import lombok.Data;

@Data
public class RoomSelectImage {
	private int roomSelectImageId;
	private int roomSelectId;
	private String imageName;
	private String imageExt;
	private long imageSize;
	private String createDate;
	private String updateDate;
}
