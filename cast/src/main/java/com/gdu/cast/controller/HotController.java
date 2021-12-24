package com.gdu.cast.controller;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.HotService;
import com.gdu.cast.service.KeywordService;
import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Hotel;
import com.gdu.cast.vo.Room;
import com.gdu.cast.vo.RoomBedroom;
import com.gdu.cast.vo.RoomConvenience;
import com.gdu.cast.vo.RoomFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HotController {
	@Autowired
	HotService hotService;
	@Autowired
	KeywordService keywordService;
	
	// 호텔 등록
	@GetMapping("/ceo/insertHotel")
	public String insertHotel(Model model, int addressId) {
		
		model.addAttribute("addressId", addressId);
		
		return "/ceo/insertHotel";
	}
	
	@PostMapping("/ceo/insertHotel")
	public String insertHotel(Model model, HttpSession session, Hotel hotel, String keyword) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		hotel.setCeoId(ceoId);
		int hotelId = hotService.insertHotel(hotel);
		System.out.println(hotelId + "호텔id");
		log.debug("====================================" + ceoId + " << ceoId");
		log.debug("====================================" + hotel.toString() + " << hotel Debug");
		System.out.println(keyword + " <---키워드 값");
		System.out.println(keyword.length() + " <---키워드 길이");
		String[] keywordList = keyword.split(",");
		System.out.println(keywordList.length + "문자열 나누기");
		System.out.println(Arrays.toString(keywordList) + "문자열 나누기");
		
		for(int i = 0; i < keywordList.length; i++) {
			System.out.println(keywordList[i] + "입력되는 값");
			keywordService.insertHotelKeyword(keywordList[i], hotelId);
		}
		
		return "redirect:/ceo/hotelList";
	}
	
	// 호텔주소 등록
	@GetMapping("/ceo/insertHotelAddress")
	public String insertHotelAddress() {
		
		return "/ceo/insertHotelAddress";
	}
	
	@PostMapping("/ceo/insertHotelAddress")
	public String insertHotelAddress(HttpSession session, Address address, Hotel hotel) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		hotel.setCeoId(ceoId);
		
		hotService.insertHotelAddress(address);	
		
		return "redirect:/ceo/insertHotel?addressId=" + address.getAddressId() + "&ceoId=" + hotel.getCeoId();
	}
	
	// 방 등록
	@GetMapping("/ceo/insertRoom")
	public String insertRoom(Model model, Hotel hotel) {
		model.addAttribute("hotelId", hotel.getHotelId());
		
		return "/ceo/insertRoom";
	}
	
	@PostMapping("/ceo/insertRoom")
	public String insertRoom(Model model, Room room, Hotel hotel) {
		
		hotService.insertRoom(room);
		
		model.addAttribute(hotel);
		model.addAttribute(room);
		
		return "redirect:/ceo/insertRoomBedroom?roomId="+room.getRoomId();
	}
	
	// 호텔리스트
	@GetMapping("/ceo/hotelList")
	 public String experienceList(Model model, HttpSession session,
	         @RequestParam(defaultValue = "1") int currentPage,
	         @RequestParam(required = false) String searchTitle) {
	         // required = true -> 값이 안넘어오면 에러, required = false -> 안넘어오면 null
	      System.out.println(searchTitle);
	      final int ROW_PER_PAGE = 10;
	      String ceoId = (String) session.getAttribute("loginCeoId");
	      Map<String, Object> map = hotService.getHotelList(currentPage, ROW_PER_PAGE, searchTitle, ceoId);
	      System.out.println(session);
	      System.out.println(session.getAttribute("loginCeoId"));
	      model.addAttribute("hotList", map.get("hotList"));
	      model.addAttribute("startPage", map.get("startPage"));
	      model.addAttribute("lastPage", map.get("lastPage"));
	      model.addAttribute("totalPage", map.get("totalPage"));
	      model.addAttribute("currentPage", currentPage);
	      
	      
	      System.out.println(session.getAttribute("loginCeoId") + " 호텔리스트 세션값");
	      return "/ceo/hotelList";
	   }
	
	// 호텔 상세보기 페이지
	@GetMapping("/ceo/hotelOne")
	public String hotelOne(Model model, Address address, int hotelId) {
		Hotel hotel = hotService.selectHotelOne(hotelId);
		
		model.addAttribute("hotel", hotel);
		model.addAttribute("address", address);
		
		List<Room> roomList = hotService.getSelectRoomList(hotelId);
		model.addAttribute("roomList", roomList);
		
		System.out.println(" << HotelController" + model);
		
		return "/ceo/hotelOne";
	}
	
	// room_bedroom 추가
	@GetMapping("/ceo/insertRoomBedroom")
	public String insertRoomBedroom(Model model, RoomBedroom roomBedroom, Room room) {
		model.addAttribute("roomId", room.getRoomId());
		model.addAttribute("roomBedroom", roomBedroom);		
	
		System.out.println(roomBedroom + "HotController roomBedroom");
		return "/ceo/insertRoomBedroom";
	}
	
	@PostMapping("/ceo/insertRoomBedroom")
	public String insertRoomBedroom(Model model, Room room, RoomBedroom roomBedroom) {
		
		hotService.insertRoomBedroom(roomBedroom);
		
		return "redirect:/ceo/insertRoomConvenience?roomId=" + room.getRoomId();
	}
	
	// room_convenience 추가
	@GetMapping("/ceo/insertRoomConvenience")
	public String insertRoomConvenience(Model model, RoomConvenience roomConenience,  Room room) {
		
		model.addAttribute("roomId", room.getRoomId());
		model.addAttribute("roomConenience",roomConenience);
		
		System.out.println(roomConenience + "HotController roomConenience");
		
		return "/ceo/insertRoomConvenience";
	}
	@PostMapping("/ceo/insertRoomConvenience")
	public String insertRoomConvenience(Model model, Room room, RoomConvenience roomConvenience) {
		
		hotService.insertRoomConvenience(roomConvenience);
		
		return "redirect:/ceo/insertRoomFilter?roomId=" + room.getRoomId();
	}
	
	// room_filter 추가
	@GetMapping("/ceo/insertRoomFilter")
	public String insertRoomFilter(Model model, RoomFilter roomFilter, Room room) {
		model.addAttribute("roomId", room.getRoomId());
		model.addAttribute("roomFilter",roomFilter);
		
		System.out.println(roomFilter + "HotController roomFilter");
		
		return "/ceo/insertRoomFilter";
	}
	@PostMapping("/ceo/insertRoomFilter")
	public String insertRoomFilter(Model model, Room room, RoomFilter roomFilter) {
		hotService.insertRoomFilter(roomFilter);
		
		return "redirect:/ceo/hotelList";
	}
}




























