package com.gdu.cast.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
// 전시소개
public class Exhibition {
	private int exhibitionNo;
	private String adminId;
	private String exhibitionTitle;
	private String exhibitionIntro;
	private String exhibitionContent;
	private String createDate;
	private String updateDate;
	private Admin admin;
	private List<MultipartFile> exhibitionImageUproad;
	private List<ExhibitionImage> exhibitionImage;
}
