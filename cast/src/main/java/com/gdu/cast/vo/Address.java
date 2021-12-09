package com.gdu.cast.vo;

import lombok.Data;

@Data
// 주소
public class Address {
	private int addressId;
	private String zipcode;
	private String sido;
	private String sigungu;
	private String eubmyeon;
	private String roadcode;
	private String roadname;
	private String buildingcode1;
	private String buildingcode2;
}
