package com.gdu.cast.vo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Customer {
	private String customerId;
	private String customerName;
	private String customerJumin;
	private String customerEmail;
	private String customerPw;
	private String customerPhoneNum;
	private String Active;
	private String createDate;
	private String updateDate;
	
}
