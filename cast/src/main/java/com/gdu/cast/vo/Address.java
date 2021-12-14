package com.gdu.cast.vo;

import lombok.Data;

@Data
// 주소
public class Address {
	private int addressId;
	private int postcode;
	private String roadAddress;
	private String jibunAddress;
	private String detailAddress;
	private String extraAddress;
	private String lat;
	private String lng;
}
