package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.RoomWishList;

@Mapper
public interface RoomWishListMapper {
	// 숙소상품 등록
	void insertRoomWishList(String customerId, int hotelId);
	// 숙소 상품 조건문
	List<RoomWishList> selectRoomWishList(String customerId);
	// 고객페이지 숙소 관심상품 조회
	List<RoomWishList> selectRoomWishListList(Map<String, Object> paramMap);
	// 고객페이지 숙소 관심상품 페이징
	int selectRoomWishListTotalCount(String customerId);
}
