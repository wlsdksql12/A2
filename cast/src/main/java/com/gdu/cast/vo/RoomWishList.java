package com.gdu.cast.vo;

import lombok.Data;

@Data
public class RoomWishList {
	private String customerId;
	private int hotelId;
	private String createDate;
	private String updateDate;
	private Hotel hotel;

}
