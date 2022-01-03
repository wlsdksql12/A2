package com.gdu.cast.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AddExperience {
	private int experienceId;
	private String ceoId;
	private int addressId;
	private String experienceName;
	private String experienceContent;
	private int experiencePrice;
	private String experienceStartdate;
	private String experienceEnddate;
	private int experiencePerson;
	private String createDate;
	private String updateDate;
	
	private List<MultipartFile> experienceImage;
}
