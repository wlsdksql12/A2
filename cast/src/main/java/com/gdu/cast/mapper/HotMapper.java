package com.gdu.cast.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Hotel;
import com.gdu.cast.vo.Room;

@Mapper
public interface HotMapper {
	// 호텔 등록
	int insertHotel(Hotel hotel);
	
	// 호텔 주소 등록
	int insertHotelAddress(Address address);
	
	// 방 등록
	int insertRoom(Room room);
}
