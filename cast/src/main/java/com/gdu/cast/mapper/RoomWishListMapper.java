package com.gdu.cast.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.RoomWishList;

@Mapper
public interface RoomWishListMapper {
	void insertRoomWishList(String customerId, int hotelId);
	List<RoomWishList> selectRoomWishList(String customerId);
}
