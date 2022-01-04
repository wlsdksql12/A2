package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Hotel;
import com.gdu.cast.vo.HotelImage;
import com.gdu.cast.vo.Room;
import com.gdu.cast.vo.RoomBedroom;
import com.gdu.cast.vo.RoomConvenience;
import com.gdu.cast.vo.RoomFilter;

@Mapper
public interface HotMapper {
	// 호텔 등록
	int insertHotel(Hotel hotel);
	
	// 호텔 이미지 추가
	int insertHotelImage(HotelImage hotelImage);
	
	// 호텔 이미지
	List<HotelImage> HotelImageList(int hotelId);
	
	// 호텔 주소 등록
	int insertHotelAddress(Address address);
	
	// 방 등록
	int insertRoom(Room room);
	
	// 호텔 리스트 출력
	List<Hotel> selectHotelList(Map<String, Object> map);
	
	// 호텔 전체 글 수
	int selectHotelTotalCount(String ceoId);
	
	// 호텔 방 수
	int selectCountRoom(Hotel hotel);
	
	// 호텔 상세보기
	Hotel selectHotelOne(int hotelId);
	
	// 호텔 수정
	int updateHotel(Hotel hotel);
	
	// room_bedroom 추가
	int insertRoomBedroom(RoomBedroom roomBedroom);
	
	// room_convenience 추가
	int insertRoomConvenience(RoomConvenience roomConvenience);
	
	// room_filter 추가
	int insertRoomFilter(RoomFilter roomFilter);
	
	// 방 리스트
	List<Room> selectRoomList(int hotelId);
	
	// 호텔추가 시 추가한 호텔id 출력
	int selectHotelId(Hotel hotel);
	
	// 테마 호텔 등록
	void insertThemeHotel(Map<String, Object> map);
	
	// 방 상세보기
	Room selectRoomOne(int roomId);
	
	// 방 수정
	int updateRoom(Room room);
}
