package com.gdu.cast.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AddRoomSelect {
	private int roomSelectId;
	private String travelerId;
	private int hotelId;
	private String roomSelectTitle;
	private String roomSelectContent;
	private String createDate;
	private String updateDate;
	private List<MultipartFile> roomSelectImage;
}
