package com.gdu.cast.vo;

import lombok.Data;

@Data
public class RoomPayment {
	private int roomPaymentId;
	private int roomOrderId;
	private String roomPaymentMethod;
	private String roomPaymentMethodNumber;
	private int roomPaymentMoney;
	private String createDate;
	private String updateDate;
}
