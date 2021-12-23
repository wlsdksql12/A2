package com.gdu.cast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.RoomOrderMapper;

@Service
public class RoomOrderService {
	@Autowired RoomOrderMapper roomOrderMapper;
	// 호텔 이름
	public String getselectHotelName(int hotelId) {
		return roomOrderMapper.selectHotelName(hotelId);
	}
	// 방 이름
	public String getselectRoomName(int roomId) {
		return roomOrderMapper.selectRoomName(roomId);
	}
	// 방 가격
	public int getselectRoomPrice(int roomId) {
		return roomOrderMapper.selectRoomPrice(roomId);
	}
	
	// 숙소 예약 insert
	public int getroomInsertOrder(String customerId, String roomName, String hotelName, int roomOrderPeople,
			String roomOrderStartDate, String roomOrderEndDate, String note) {
		roomOrderMapper.roomInsertOrder(customerId, roomName, hotelName, roomOrderPeople, roomOrderStartDate, roomOrderEndDate, note);
		return roomOrderMapper.roomOrderId(customerId);
	
	}
	
	// 숙소 결제 insert
	public void getroomInsertPayment(int roomOrderId, String roomPaymentMethod, String roomPaymentMethodNumber, int roomPaymentMoney) {
		roomOrderMapper.roomInsertPayment(roomOrderId, roomPaymentMethod, roomPaymentMethodNumber, roomPaymentMoney);
	}
	
}
