package com.gdu.cast.vo;

import lombok.Data;

@Data
// 객실 필터
public class RoomFilter {
	private int roomId;
	private String internet;
	private String kitchen;
	private String boiler;
	private String aircon;
	private String washingMachine;
	private String breakfast;
	private String tv;
	private String hairdryer;
	private String bidet;
	private String createDate;
	private String updateDate;
}
