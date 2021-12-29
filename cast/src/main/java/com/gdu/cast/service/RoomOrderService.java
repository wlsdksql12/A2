package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.RoomOrderMapper;
import com.gdu.cast.vo.RoomOrder;
import com.gdu.cast.vo.RoomPayment;

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
	
	public Map<String, Object> getCustomerIndexRoomOrder(String customerId, int currentPage2, int ROW_PER_PAGE){
		 Map<String, Object> paramMap = new HashMap<>();
		 
		   int beginRow = (currentPage2-1)*ROW_PER_PAGE;
		   paramMap.put("customerId", customerId);
		   paramMap.put("beginRow", beginRow); 
		   paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		   System.out.println(ROW_PER_PAGE +"ROW_PER_PAGE");
		   System.out.println(currentPage2 +"currentPage");
		   List<RoomOrder> roomOrderList = roomOrderMapper.CustomerIndexRoomOrder(paramMap);
		   Map<String, Object> returnMap = new HashMap<>();
			int lastPage = 0;
			int totalCount = roomOrderMapper.selectRoomOrderTotalCount(customerId);
			lastPage = totalCount / ROW_PER_PAGE;
			if(totalCount%ROW_PER_PAGE != 0) {
				lastPage += 1;
			}
			returnMap.put("roomOrderList", roomOrderList);
			returnMap.put("lastPage", lastPage);
		 
		 return returnMap;
		 
	}
	
	// 관리자 페이지에 숙소 예약 리스트 출력
	public List<RoomOrder> getAdminRoomOrder(){
		return roomOrderMapper.selectAdminRoomOrder();
	}
	
	// 관리자 페이지에 숙소 결제 리스트 출력
	public List<RoomPayment> getAdminRoomPayment(){
		return roomOrderMapper.selectAdminRoomPayment();
	}
	
}
