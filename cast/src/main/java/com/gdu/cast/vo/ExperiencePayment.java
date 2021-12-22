package com.gdu.cast.vo;

import lombok.Data;

@Data
public class ExperiencePayment {
	private int experiencePaymentId;
	private int experienceOrderId;
	private String experiencePaymentMethod;
	private String experiencePaymentMethodNumber;
	private int experiencePaymentMoney;
	private int esperiencePaymetPeople;
	private String createDate;
	private String updateDate;
	private String note;
}
