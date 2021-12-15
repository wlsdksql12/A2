package com.gdu.cast.vo;

import lombok.Data;

@Data
// 객실
public class Room {
	private int roomId;
	private int hotelId;
	private String roomName;
	private String roomContent;
	private String roomStartdate;
	private String roomEnddate;
	private int roomPrice;
	private String createDate;
	private String updateDate;
}
