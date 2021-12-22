package com.gdu.cast.vo;

import lombok.Data;

@Data
public class ExperienceOrder {
	private int experienceOrderId;
	private String experienceName;
	private String customerId;
	private int experienceOrderPeople;
	private String experienceOrderStartDate;
	private String experienceOrderEndDate;
	private String createDate;
	private String updateDate;
}
