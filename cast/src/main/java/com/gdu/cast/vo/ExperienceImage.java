package com.gdu.cast.vo;

import lombok.Data;

@Data
// 체험이미지
public class ExperienceImage {
	private int experienceImageId;
	private int experienceId;
	private String imageExt;
	private long imageSize;
	private String imageName;
	private String createDate;
	private String updateDate;
}
