package com.gdu.cast.vo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerJumin() {
		return customerJumin;
	}
	public void setCustomerJumin(String customerJumin) {
		this.customerJumin = customerJumin;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPw() {
		return customerPw;
	}
	public void setCustomerPw(String customerPw) {
		this.customerPw = customerPw;
	}

	public String getCustomerPhoneNum() {
		return customerPhoneNum;
	}
	public void setCustomerPhoneNum(String customerPhoneNum) {
		this.customerPhoneNum = customerPhoneNum;
	}
	public String getActive() {
		return Active;
	}
	public void setActive(String active) {
		Active = active;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public static org.slf4j.Logger getLog() {
		return log;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerJumin="
				+ customerJumin + ", customerEmail=" + customerEmail + ", customerPw=" + customerPw
				+ ", customerPhoneNum=" + customerPhoneNum + ", Active=" + Active + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}
	
	
}
