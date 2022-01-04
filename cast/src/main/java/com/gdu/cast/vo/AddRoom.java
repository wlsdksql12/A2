package com.gdu.cast.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AddRoom {
	private int roomId;
	private int hotelId;
	private String roomName;
	private int roomCount;
	private String roomContent;
	private String roomStartdate;
	private String roomEnddate;
	private int roomPrice;
	private String createDate;
	private String updateDate;
	
	private List<MultipartFile> roomImage;
}
