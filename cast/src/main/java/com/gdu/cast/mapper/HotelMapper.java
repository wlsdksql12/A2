package com.gdu.cast.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.tomcat.jni.Address;

import com.gdu.cast.vo.Hotel;

@Mapper
public interface HotelMapper {
	// 호텔 등록
	int insertHotel(Hotel hotel);
	// 주소 추가
	int insertHotelAddress(Address address);
}