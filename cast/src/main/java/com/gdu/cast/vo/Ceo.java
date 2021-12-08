package com.gdu.cast.vo;

import lombok.Data;

@Data
public class Ceo {
	private String ceoId;			// 사업자 아이디
	private String ceoName;		// 사업자 이름
	private String ceoEmail;		// 사업자 이메일
	private String ceoPhonenum;	        // 사업자 휴대번호
	private String ceoJumin;		// 사업자 주민등록번호
	private String ceoLicense;		// 사업자 등록증 여부
	private String password;		// 사업자 비밀번호
	private String createDate;		// 사업자 정보 생성일
	private String updateDate;		// 사업자 정보 수정일
	
}
