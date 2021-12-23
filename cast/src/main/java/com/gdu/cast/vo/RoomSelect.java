package com.gdu.cast.vo;

import lombok.Data;

@Data
public class RoomSelect {
	private int roomSelectId;
	private String travelerId;
	private int hotelId;
	private String roomSelectTitle;
	private String roomSelectContent;
	private String createDate;
	private String updateDate;
	private Traveler traveler;
}
