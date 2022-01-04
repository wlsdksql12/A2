package com.gdu.cast.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AddHotel {
	private int hotelId;
	private String ceoId;
	private int addressId;
	private String hotelName;
	private String hotelContent;
	private String createDate;
	private String updateDate;
	
	private List<MultipartFile> hotelImage;
}
