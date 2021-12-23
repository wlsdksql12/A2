package com.gdu.cast.vo;

import lombok.Data;

@Data
// 숙소테이블
public class Hotel {
	private int hotelId;
	private String ceoId;
	private int addressId;
	private String hotelName;
	private String hotelContent;
	private String createDate;
	private String updateDate;
	private Address address;
}
