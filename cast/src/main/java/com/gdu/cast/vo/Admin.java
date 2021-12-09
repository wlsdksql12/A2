package com.gdu.cast.vo;

import lombok.Data;

@Data
// 관리자
public class Admin {
	private String adminId;
	private String adminPw;
	private String adminName;
	private String createDate;
	private String updateDate;
}
