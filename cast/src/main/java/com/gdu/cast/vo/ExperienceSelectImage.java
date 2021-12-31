package com.gdu.cast.vo;

import lombok.Data;

@Data
public class ExperienceSelectImage {
	private int experienceSelectImageId;
	private int experienceSelectId;
	private String imageName;
	private String imageExt;
	private long imageSize;
	private String createDate;
	private String updateDate;
}
