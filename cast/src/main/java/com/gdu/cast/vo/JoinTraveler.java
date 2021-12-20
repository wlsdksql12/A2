package com.gdu.cast.vo;

import lombok.Data;

@Data
public class JoinTraveler {
	public int joinTravelerId;
	public String adminId;
	public String travelerId;
	public String travelerName;
	public String travelerPhoneNum;
	public String travelerEmail;
	public String travelerLicense;
	public String travelerCareer;
	public String active;
	public String createDate;
	public String updateDate;
}
