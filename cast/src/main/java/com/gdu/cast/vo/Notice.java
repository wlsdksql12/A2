package com.gdu.cast.vo;

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
}
