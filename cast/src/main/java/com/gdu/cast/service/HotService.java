package com.gdu.cast.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gdu.cast.mapper.HotMapper;
import com.gdu.cast.vo.AddHotel;
import com.gdu.cast.vo.AddRoom;
import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.ExperienceImage;
import com.gdu.cast.vo.Hotel;
import com.gdu.cast.vo.HotelImage;
import com.gdu.cast.vo.Room;
import com.gdu.cast.vo.RoomBedroom;
import com.gdu.cast.vo.RoomConvenience;
import com.gdu.cast.vo.RoomFilter;
import com.gdu.cast.vo.RoomImage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class HotService {
	@Autowired
	HotMapper hotMapper;
	
	// 호텔 추가
	public int insertHotel(AddHotel addHotel) {
		
		// 데이터 추가
		String ceoId = addHotel.getCeoId();
		int addressId = addHotel.getAddressId();
		String hotelName = addHotel.getHotelName();
		String hotelContent = addHotel.getHotelContent();
		String createDate = addHotel.getCreateDate();
		String updateDate = addHotel.getUpdateDate();
		
		// 호텔 입력
		Hotel hotel = new Hotel();
		hotel.setCeoId(ceoId);
		hotel.setAddressId(addressId);
		hotel.setHotelName(hotelName);
		hotel.setHotelContent(hotelContent);
		hotel.setCreateDate(createDate);
		hotel.setUpdateDate(updateDate);
		hotMapper.insertHotel(hotel);
		
		// 호텔 이미지 추가
		List<HotelImage> hotelImage = null;
		System.out.println("@@@@@@@addHotel" + addHotel.getHotelImage());
		if(addHotel.getHotelImage() != null) {
			hotelImage = new ArrayList<HotelImage>();
			for(MultipartFile mf : addHotel.getHotelImage()) {
				HotelImage esi = new HotelImage();
				esi.setHotelId(hotel.getHotelId());
				String originName = mf.getOriginalFilename();
				int p = originName.lastIndexOf(".");
				String imageName = UUID.randomUUID().toString();
				String imageExt = originName.substring(p+1);
				esi.setImageName(imageName);
				esi.setImageExt(imageExt);
				esi.setImageSize(mf.getSize());
				esi.setCreateDate(createDate);
				esi.setUpdateDate(updateDate);
				hotelImage.add(esi);
				File temp = new File("");
				String path = temp.getAbsolutePath();
				System.out.println("@@@@@@@@@@hotelImage" + hotelImage);
				// 절대경로
				File f = new File(path+"\\src\\main\\webapp\\upload\\"+imageName+"."+imageExt);
				try {
					mf.transferTo(f);
				} catch(Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			}
		}
		if(hotelImage != null) {
			for(HotelImage esi : hotelImage) {
				hotMapper.insertHotelImage(esi);
				System.out.println("@@@@@@@@@@hotelImage" + hotelImage);
			}
		}
		return hotel.getHotelId();
	}
	
	// 호텔 주소 추가
	public void insertHotelAddress(Address address) {
		hotMapper.insertHotelAddress(address);
	}
	
	// 방 추가
	public int insertRoom(AddRoom addRoom) {
	
		// 데이터 추가
		int hotelId = addRoom.getHotelId();
		String roomName = addRoom.getRoomName();
		int roomCount = addRoom.getRoomCount();
		String roomContent = addRoom.getRoomContent();
		String roomStartdate = addRoom.getRoomStartdate();
		String roomEnddate = addRoom.getRoomEnddate();
		int roomPrice = addRoom.getRoomPrice();
		String createDate = addRoom.getCreateDate();
		String updateDate = addRoom.getUpdateDate();
		
		// 객실 입력
		Room room = new Room();
		room.setHotelId(hotelId);
		room.setRoomName(roomName);
		room.setRoomCount(roomCount);
		room.setRoomContent(roomContent);
		room.setRoomStartdate(roomStartdate);
		room.setRoomEnddate(roomEnddate);
		room.setRoomPrice(roomPrice);
		room.setCreateDate(createDate);
		room.setUpdateDate(updateDate);
		hotMapper.insertRoom(room);
		
		System.out.println("!!!!!!!!1" + room.getRoomId());
		
		// 이미지 추가
		List<RoomImage> roomImage = null;
		if(addRoom.getRoomImage() != null) {
			roomImage = new ArrayList<RoomImage>();
			for(MultipartFile mf : addRoom.getRoomImage()) {
				RoomImage esi = new RoomImage();
				esi.setRoomId(room.getRoomId());
				String originName = mf.getOriginalFilename();
				int p = originName.lastIndexOf(".");
				String imageName = UUID.randomUUID().toString();
				String imageExt = originName.substring(p+1);
				esi.setImageName(imageName);
				esi.setImageExt(imageExt);
				esi.setImageSize(mf.getSize());
				esi.setCreateDate(createDate);
				esi.setUpdateDate(updateDate);
				System.out.println("@@@@@@@@@@" + esi.toString());
				roomImage.add(esi);
				// 절대경로
				File temp = new File("");
				String path = temp.getAbsolutePath();
				try {
					mf.transferTo(new File(path+"\\src\\main\\webapp\\upload\\"+imageName+"."+imageExt));
				} catch(Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			}
		}
		if(roomImage != null) {
			for(RoomImage esi : roomImage) {
				hotMapper.insertRoomImage(esi);
		}
	}
		return room.getRoomId();
}
	
	// 방 리스트
	public List<Room> getSelectRoomList(int hotelId) {
		return hotMapper.selectRoomList(hotelId);
	}
	
	// 객실 이미지
	public List<RoomImage> getRoomImage(int roomId) {
		return hotMapper.RoomImageList(roomId);
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
	
	// 호텔 상세보기
	public Hotel selectHotelOne(int hotelId) {
		Hotel hotel = hotMapper.selectHotelOne(hotelId);
		return hotel;
	}
	
	// 호텔 매개변수 반환 값
	public Room selectHotelParameter(int hotelId) {
		return hotMapper.selectHotelParameter(hotelId);
	}
	
	// 호텔 이미지
	public List<HotelImage> getHotelImage(int hotelId) {
		return hotMapper.HotelImageList(hotelId);
	}
	
	// 호텔 수정하기
	public void updateHotel(Hotel hotel) {
		log.debug(hotel.toString());
		hotMapper.updateHotel(hotel);
	}
	
	// room_bedroom 추가
	public void insertRoomBedroom(RoomBedroom roomBedroom) {
		hotMapper.insertRoomBedroom(roomBedroom);
	}
	
	// room_convenience 추가
	public void insertRoomConvenience(RoomConvenience roomConvenience) {
		hotMapper.insertRoomConvenience(roomConvenience);
	}
	
	// room_filter 추가
	public void insertRoomFilter(RoomFilter roomFilter) {
		hotMapper.insertRoomFilter(roomFilter);
	}
	
	// 테마 호텔 등록
	public void insertThemeHotel(int hotelId, String theme) {
		Map<String, Object> map = new HashMap<>();
		map.put("theme", theme);
		map.put("hotelId", hotelId);
		hotMapper.insertThemeHotel(map);
	}
	
	// 방 상세보기
	public Room selectRoomOne(int roomId) {
		Room room = hotMapper.selectRoomOne(roomId);
			
		return room;
	}
	
	// 방 수정 
	public void updateRoom(Room room) {
		hotMapper.updateRoom(room);
	}
	
}



















