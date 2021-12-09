package com.gdu.cast.vo;

import lombok.Data;

@Data
// 관리자_숙소_중계료
public class AdminRoomSale {
	private int adminRoomSaleId;
	private int roomPayment;
	private String month;
	private int countPay;
	private int salePay;
	private String createDate;
	private String updateDate;
}
