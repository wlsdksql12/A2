package com.gdu.cast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.HotelMapper;
import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Hotel;

@Service
@Transactional
public class HotelService {
	@Autowired 
	HotelMapper hotelMapper;
	
	public void insertHotel(Hotel hotel) {
		hotelMapper.insertHotel(hotel);
	}
	
	public void insertHotelAddress(Address address) {
		hotelMapper.insertHotelAddress(address);
	}
}
