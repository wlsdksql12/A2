package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.HotMapper;
import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Experience;
import com.gdu.cast.vo.Hotel;
import com.gdu.cast.vo.Room;
import com.gdu.cast.vo.RoomSelect;

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
	
	// 방 추가
	public void insertRoom(Room room) {
		hotMapper.insertRoom(room);
	}
	
	// 호텔 리스트
	public Map<String, Object> getHotelList(int currentPage, int ROW_PER_PAGE, String searchTitle, String ceoId){
		// 1. 매개변수 가공
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow); // currentPage 가공
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("searchTitle", searchTitle);
		paramMap.put("ceoId", ceoId);
		
		// 호텔 리스트 가져오기
		List<Hotel> hotList = hotMapper.selectHotelList(paramMap);
		System.out.println(hotList + "HotelService");
		// 2. 리턴값 가공
		Map<String, Object> returnMap = new HashMap<>();
		
		
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		
		int totalCount = hotMapper.selectHotelTotalCount(ceoId);
		System.out.println(totalCount + "hotService");
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		
		returnMap.put("hotList", hotList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
}
