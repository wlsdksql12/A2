package com.gdu.cast.vo;

import java.util.List;

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
	private List<MultipartFile> experienceSelectImage;
}
