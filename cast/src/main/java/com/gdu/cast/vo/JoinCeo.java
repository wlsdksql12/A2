package com.gdu.cast.vo;

import lombok.Data;

@Data
// 사업자 회원가입 요청
public class JoinCeo {
	private int joinCeoId;
	private String ceoId;
	private String active;
	private String createDate;
	private String updateDate;
}
