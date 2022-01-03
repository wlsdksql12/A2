package com.gdu.cast.vo;

import lombok.Data;

@Data
// 전시소개 이미지 테이블
public class ExhibitionImage {
	private int exhibitionImageNo;
	private int exhibitionNo;
	private String imageName;
	private String imageExt;
	private long imageSize;
	private String createDate;
	private String updateDate;
}
