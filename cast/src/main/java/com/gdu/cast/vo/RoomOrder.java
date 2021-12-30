package com.gdu.cast.vo;

import lombok.Data;

@Data
public class RoomOrder {
	private int roomOrderId;
	private String customerId;
	private String roomName;
	private String hotelName;
	private String roomOrderStartDate;
	private String roomOrderEndDate;
	private String createDate;
	private String updateDate;
	private String note;
	private int roomOrderPeople;
	private RoomPayment roomPayment;
}
