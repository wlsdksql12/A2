package com.gdu.cast.vo;

import lombok.Data;

@Data
// 공지사항 이미지
public class NoticeImage {
	private int noticeImageId;
	private int noticeNo;
	private String imageName;
	private String imageExt;
	private long imageSize;
	private String createDate;
	private String updateDate;
}
