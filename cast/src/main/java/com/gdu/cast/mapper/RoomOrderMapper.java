package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.RoomOrder;

@Mapper
public interface RoomOrderMapper {
	// 호텔 이름 출력
	public String selectHotelName(int hotelId);
	// 객실 이름 출력
	public String selectRoomName(int roomId);
	// 객실 가격 출력
	public int selectRoomPrice(int roomId);
	// 호텔 예약
	public void roomInsertOrder(String customerId, String roomName, String hotelName, int roomOrderPeople,
								String roomOrderStartDate, String roomOrderEndDate, String note);
	// 결제용 예약 ID
	public int roomOrderId(String customerId);
	// 호텔 결제
	public void roomInsertPayment(int roomOrderId, String roomPaymentMethod, String roomPaymentMethodNumber, int roomPaymentMoney);
	// 고객 페이지 본인이 한 숙소 예약
	List<RoomOrder> CustomerIndexRoomOrder(Map<String, Object> map);
	// 고객 페이지 숙소 예약 페이징
	int selectRoomOrderTotalCount(String CustomerId);
	

}
