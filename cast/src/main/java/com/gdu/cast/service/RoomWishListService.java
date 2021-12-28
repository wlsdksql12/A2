package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.RoomWishListMapper;
import com.gdu.cast.vo.ExperienceWishList;
import com.gdu.cast.vo.RoomWishList;

@Service
public class RoomWishListService {
	@Autowired RoomWishListMapper roomWishListMapper;
	
	// 숙소 관심상품 등록
	public void getinsertRoomWishList(String customerId, int hotelId) {
		roomWishListMapper.insertRoomWishList(customerId, hotelId);
	}
	// 숙소 관심상품 등록 조건문
	public List<RoomWishList> getselectRoomWishList(String customerId){
		return roomWishListMapper.selectRoomWishList(customerId);
	}
	
	// 등록한 숙소 관심상품 조회
	public Map<String, Object> getselectRoomWishListList(String customerId, int currentPage, int ROW_PER_PAGE){
		   Map<String, Object> paramMap = new HashMap<>();
		   
		   int beginRow = (currentPage-1)*ROW_PER_PAGE;
		   paramMap.put("customerId", customerId);
		   paramMap.put("beginRow", beginRow); 
		   paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		
		   List<RoomWishList> wishList = roomWishListMapper.selectRoomWishListList(paramMap);
			Map<String, Object> returnMap = new HashMap<>();
			int lastPage = 0;
			int totalCount = roomWishListMapper.selectRoomWishListTotalCount(customerId);
			lastPage = totalCount / ROW_PER_PAGE;
			if(totalCount%ROW_PER_PAGE != 0) {
				lastPage += 1;
			}
			returnMap.put("wishList", wishList);
			returnMap.put("lastPage", lastPage);
			
			return returnMap;
	}
}
