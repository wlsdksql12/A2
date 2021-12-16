package com.gdu.cast.vo;

import lombok.Data;

@Data
// 체험테이블
public class Experience {
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
	
	private Address address;
}
