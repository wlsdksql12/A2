package com.gdu.vo;

import lombok.Data;

@Data
public class Ceo {
	private String ceo_id;			// 사업자 아이디
	private String ceo_name;		// 사업자 이름
	private String ceo_email;		// 사업자 이메일
	private String ceo_phonenum;	        // 사업자 휴대번호
	private String ceo_jumin;		// 사업자 주민등록번호
	private String ceo_license;		// 사업자 등록증 여부
	private String password;		// 사업자 비밀번호
	private String create_date;		// 사업자 정보 생성일
	private String update_date;		// 사업자 정보 수정일
}
