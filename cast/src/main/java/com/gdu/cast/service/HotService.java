package com.gdu.cast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.HotMapper;
import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Hotel;

@Service
@Transactional
public class HotService {
	@Autowired
	HotMapper hotMapper;
	
	// 호텔 추가
	public void insertHotel(Hotel hotel) {
		hotMapper.insertHotel(hotel);
	}
	
	// 호텔 주소 추가
	public void insertHotelAddress(Address address) {
		hotMapper.insertHotelAddress(address);
	}
}
