package com.gdu.cast.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ExperienceSelect {
	private int experienceSelectId;
	private String travelerId;
	private int experienceId;
	private String experienceSelectTitle;
	private String experienceSelectContent;
	private String createDate;
	private String updateDate;
	private Traveler traveler;
	private List<ExperienceSelectImage> experienceSelectImage;
	private List<MultipartFile> updateExperienceSelectImage;
}
