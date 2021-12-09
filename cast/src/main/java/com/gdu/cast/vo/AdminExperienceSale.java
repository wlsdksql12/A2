package com.gdu.cast.vo;

import lombok.Data;

@Data
// 관리자_체험_중계료
public class AdminExperienceSale {
	private int adminExperienceSaleId;
	private int experiencePayment;
	private String month;
	private int countPay;
	private int salePay;
	private String createDate;
	private String updateDate;
}
