package com.gdu.cast.vo;

import lombok.Data;

@Data
public class Subscription {
	private int subscriptionNo;
	private String subscriptionName;
	private int subscriptionPay;
	private String subscriptionHotel;
	private String subscriptionExperience;
	private String subscriptionExhibitionEnum;
	private String createDate;
	private String updateDate;
}
