package com.gdu.cast.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
// 공지사항
public class Notice {
	private int noticeNo;
	private String adminId;
	private String noticeTitle;
	private String noticeContent;
	private String createDate;
	private String updateDate;
	private Admin admin;
	private List<MultipartFile> noticeImageUproad;
	private List<NoticeImage> noticeImage;
}
