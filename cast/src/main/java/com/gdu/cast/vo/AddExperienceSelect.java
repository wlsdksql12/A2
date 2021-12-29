package com.gdu.cast.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AddExperienceSelect {
	private int experienceSelectId;
	private String travelerId;
	private int experienceId;
	private String experienceSelectTitle;
	private String experienceSelectContent;
	private String createDate;
	private String updateDate;
	private MultipartFile experienceSelectImage;
}
