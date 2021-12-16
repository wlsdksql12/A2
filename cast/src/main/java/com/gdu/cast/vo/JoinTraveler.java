package com.gdu.cast.vo;

import lombok.Data;

@Data
public class JoinTraveler {
	public int joinTravelerId;
	public String travelerId;
	public String adminId;
	public String active;
	public String createDate;
	public String updateDate;
	public Traveler traveler;
}
