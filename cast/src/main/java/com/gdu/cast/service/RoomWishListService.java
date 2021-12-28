package com.gdu.cast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.RoomWishListMapper;
import com.gdu.cast.vo.RoomWishList;

@Service
public class RoomWishListService {
	@Autowired RoomWishListMapper roomWishListMapper;
	
	// 숙소 관심상품 등록
	public void getinsertRoomWishList(String customerId, int hotelId) {
		roomWishListMapper.insertRoomWishList(customerId, hotelId);
	}
	
	public List<RoomWishList> getselectRoomWishList(String customerId){
		return roomWishListMapper.selectRoomWishList(customerId);
	}
	
	// 숙소 관심상품 등록 조건문
}
