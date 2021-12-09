package com.gdu.cast.vo;

import lombok.Data;

@Data
// 침실과 침대
public class RoomBedroom {
	private int roomId;
	private int bedCount;
	private int bedroomCount;
	private int bathroomCount;
	private String createDate;
	private String updateDate;
}
