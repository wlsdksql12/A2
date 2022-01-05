package com.gdu.cast.controller;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gdu.cast.service.HotService;
import com.gdu.cast.service.KeywordService;
import com.gdu.cast.service.MainExperienceOrHotelReviewService;
import com.gdu.cast.service.MainSelectService;
import com.gdu.cast.vo.AddHotel;
import com.gdu.cast.vo.AddRoom;
import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Hotel;
import com.gdu.cast.vo.HotelImage;
import com.gdu.cast.vo.Room;
import com.gdu.cast.vo.RoomBedroom;
import com.gdu.cast.vo.RoomConvenience;
import com.gdu.cast.vo.RoomFilter;
import com.gdu.cast.vo.RoomImage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HotController {
	@Autowired
	HotService hotService;
	@Autowired
	KeywordService keywordService;
	@Autowired
	MainSelectService mainSelectService;
	@Autowired
	MainExperienceOrHotelReviewService mainExperienceOrHotelReviewService;
	
	 private final int row_per_page = 5;
	// 호텔 등록
	@GetMapping("/ceo/insertHotel")
	public String insertHotel(Model model, int addressId) {
		Map<String, Object> ThemeSmallmap = mainSelectService.selectThemeSmall();
		System.out.println(ThemeSmallmap.get("selectThemeSmallList")+ "tset");
		model.addAttribute("addressId", addressId);
		model.addAttribute("selectThemeSmallList",ThemeSmallmap.get("selectThemeSmallList"));
		
		return "/ceo/insertHotel";
	}
	
	@PostMapping("/ceo/insertHotel")
	public String insertHotel(Model model, HttpSession session, AddHotel addHotel, @RequestParam(defaultValue = "") String keyword, String theme) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		addHotel.setCeoId(ceoId);
		
		int hotelId = hotService.insertHotel(addHotel);
		System.out.println(hotelId + "호텔id");
		log.debug("====================================" + ceoId + " << ceoId");
		log.debug("====================================" + addHotel.toString() + " << hotel Debug");
		
		// 해시태그 키워드 입력을 안할시 실행이 안되도록
		if(!keyword.equals("")) {
			System.out.println(keyword + " <---키워드 값");
			System.out.println(keyword.length() + " <---키워드 길이");
			String[] keywordList = keyword.split(",");
			System.out.println(keywordList.length + "문자열 나누기");
			System.out.println(Arrays.toString(keywordList) + "문자열 나누기");
			
			for(int i = 0; i < keywordList.length; i++) {
				System.out.println(keywordList[i] + "입력되는 값");
				keywordService.insertHotelKeyword(keywordList[i], hotelId);
			}
		}
		hotService.insertThemeHotel(hotelId, theme);
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
	public String insertRoom(Model model, AddRoom addRoom, Hotel hotel) {
		
		int roomId = hotService.insertRoom(addRoom);
		System.out.println(roomId  + "객실 id");
		
		model.addAttribute(hotel);
		model.addAttribute(addRoom);
		System.out.println("@@@@@@@@@2HotController >> " + model);
		
		return "redirect:/ceo/insertRoomBedroom?roomId="+roomId;
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
	
	// 호텔 상세보기 페이지(이미지 추가)
	@GetMapping("/ceo/hotelOne")
	public String hotelOne(Model model, Address address, int hotelId) {
		Hotel hotel = hotService.selectHotelOne(hotelId);
		List<HotelImage> hotelImageList = hotService.getHotelImage(hotelId);
		
		model.addAttribute("hotel", hotel);
		model.addAttribute("address", address);
		model.addAttribute("hotelImageList", hotelImageList);
		
		List<Room> roomList = hotService.getSelectRoomList(hotelId);
		model.addAttribute("roomList", roomList);
		
		System.out.println(" << HotelController" + model);
		
		return "/ceo/hotelOne";
	}
	
	// 호텔 수정
	@GetMapping("/ceo/updateHotel")
	public String updateHotel(Model model, int hotelId) {
		Hotel hotel = hotService.selectHotelOne(hotelId);
		model.addAttribute("hotel", hotel);
		return "/ceo/updateHotel";
	}
	@PostMapping("/ceo/updateHotel")
	public String updateHotel(Hotel hotel) {
		hotService.updateHotel(hotel);
		log.debug("hotel" + hotel.toString());
		return "redirect:/ceo/hotelOne?hotelId="+hotel.getHotelId();
	}
	
	// room_bedroom 추가
	@GetMapping("/ceo/insertRoomBedroom")
	public String insertRoomBedroom(Model model, RoomBedroom roomBedroom, AddRoom addRoom) {
		model.addAttribute("roomId", addRoom.getRoomId());
		model.addAttribute("roomBedroom", roomBedroom);		
	
		System.out.println(roomBedroom + "HotController roomBedroom");
		return "/ceo/insertRoomBedroom";
	}
	
	@PostMapping("/ceo/insertRoomBedroom")
	public String insertRoomBedroom(Model model,  AddRoom addRoom, RoomBedroom roomBedroom) {
		
		hotService.insertRoomBedroom(roomBedroom);
		
		return "redirect:/ceo/insertRoomConvenience?roomId=" + addRoom.getRoomId();
	}
	
	// room_convenience 추가
	@GetMapping("/ceo/insertRoomConvenience")
	public String insertRoomConvenience(Model model, RoomConvenience roomConenience, AddRoom addRoom) {
		
		model.addAttribute("roomId", addRoom.getRoomId());
		model.addAttribute("roomConenience",roomConenience);
		
		System.out.println(roomConenience + "HotController roomConenience");
		
		return "/ceo/insertRoomConvenience";
	}
	@PostMapping("/ceo/insertRoomConvenience")
	public String insertRoomConvenience(Model model,  AddRoom addRoom, RoomConvenience roomConvenience) {
		
		hotService.insertRoomConvenience(roomConvenience);
		
		return "redirect:/ceo/insertRoomFilter?roomId=" + addRoom.getRoomId();
	}
	
	// room_filter 추가
	@GetMapping("/ceo/insertRoomFilter")
	public String insertRoomFilter(Model model, RoomFilter roomFilter,  AddRoom addRoom) {
		model.addAttribute("roomId", addRoom.getRoomId());
		model.addAttribute("roomFilter",roomFilter);
		
		System.out.println(roomFilter + "HotController roomFilter");
		
		return "/ceo/insertRoomFilter";
	}
	@PostMapping("/ceo/insertRoomFilter")
	public String insertRoomFilter(Model model,  AddRoom addRoom, RoomFilter roomFilter) {
		hotService.insertRoomFilter(roomFilter);
		
		return "redirect:/ceo/hotelList";
	}
	
	// 방 상세보기
	@GetMapping("/ceo/roomOne")
	public String roomOne(Model model,  Room room, RoomFilter roomFilter, RoomConvenience roomConvenience, RoomBedroom roomBedroom, int roomId) {
		room = hotService.selectRoomOne(room.getRoomId());
		List<RoomImage> roomImageList = hotService.getRoomImage(roomId);
		
		model.addAttribute("room", room);
		model.addAttribute("roomFilter", roomFilter);
		model.addAttribute("roomConvenience", roomConvenience);
		model.addAttribute("roomBedroom", roomBedroom);
		model.addAttribute("roomImageList", roomImageList);
		
		System.out.println("@@@@HotController" + model);
		
		return "/ceo/roomOne";
	}
	
	// 방 수정하기
	@GetMapping("/ceo/updateRoom")
	public String updateRoom(Model model, int roomId, RoomFilter roomFilter, RoomConvenience roomConvenience, RoomBedroom roomBedroom) {

		Room room = hotService.selectRoomOne(roomId);
		model.addAttribute("room", room);
		model.addAttribute("roomBedroom", roomBedroom);
		model.addAttribute("roomFilter", roomFilter);
		model.addAttribute("roomCovenience", roomConvenience);
		
		return "/ceo/updateRoom";
	}
	
	@PostMapping("/ceo/updateRoom")
	public String updateRoom(Room room) {
		hotService.updateRoom(room);
		System.out.println(room);
		return "redirect:/ceo/roomOne?roomId="+room.getRoomId();
	}
	
	// 메인 shop 호텔 상세보기 페이지
	@GetMapping("/mainHotelOne")
	public String mainHotelOne(Model model, Address address, int hotelId, @RequestParam(defaultValue = "1") int currentPage) {
		
		Hotel hotel = hotService.selectHotelOne(hotelId);
		//호텔 후기 리스트 출력.
		 Map<String, Object> map = mainExperienceOrHotelReviewService.getroomPaymentReview(currentPage, row_per_page, hotelId);
		model.addAttribute("hotel", hotel);
		model.addAttribute("address", address);
		
		List<Room> roomList = hotService.getSelectRoomList(hotelId);
		
		System.out.println(map.get("RoomPaymentReview") +"@#@#map.get(\"RoomPaymentReview\")");
		
	     model.addAttribute("RoomPaymentReview", map.get("RoomPaymentReview"));
		model.addAttribute("roomList", roomList);
	      model.addAttribute("startPage", map.get("startPage"));
	      model.addAttribute("lastPage", map.get("lastPage"));
	      model.addAttribute("totalPage", map.get("totalPage"));
	      model.addAttribute("currentPage", currentPage);
		System.out.println(" << HotelController" + model);
		
		return "mainHotelOne";
	}
	
	// 메인 shop 상세보기
	@GetMapping("/mainRoomOne")
	public String mainRoomOne(Model model, Room room, RoomFilter roomFilter, RoomConvenience roomConvenience, RoomBedroom roomBedroom) {
		room = hotService.selectRoomOne(room.getRoomId());
		
		model.addAttribute("room", room);
		model.addAttribute("roomFilter", roomFilter);
		model.addAttribute("roomConvenience", roomConvenience);
		model.addAttribute("roomBedroom", roomBedroom);
		
		System.out.println("@@@@HotController" + model);
		
		return "/mainRoomOne";
	}
	// 호텔 리뷰 추가 화면으로 이동.
	@GetMapping("/addHotelReview")
	public String addMainHotel(Model model, String hotelName, HttpSession session, int hotelId) {
		 String customerId = (String)session.getAttribute("loginCustomerId");
		 int roomPaymentId = mainExperienceOrHotelReviewService.getselectCustomerHotelPaymentId(hotelName, customerId); 
		 
		 model.addAttribute("customerId", customerId);
		 model.addAttribute("hotelId", hotelId);
		 model.addAttribute("roomPaymentId", roomPaymentId);
		 model.addAttribute("hotelName", hotelName);
		 
		 return "addHotelReview";
	}
	// 호텔 리뷰 추가 (사진 초함)
	@PostMapping("/addHotelReview")
	public String addMainHotel(HttpServletRequest request,List<MultipartFile> roompaymentReviewImageUpload ,String roomPaymentReviewContent, int roomPaymentId, int hotelId, String hotelName) {
		 System.out.println(roomPaymentId + "roomPaymentReviewId! 디버깅!"); 
		 String path = request.getSession().getServletContext().getRealPath("/");
		mainExperienceOrHotelReviewService.getinsertRoomPaymentReview(roompaymentReviewImageUpload, path, roomPaymentReviewContent, roomPaymentId, hotelId);
		
		
		return "redirect:/mainHotelOne?hotelId="+hotelId+"&hotelName="+hotelName;
	}
	
	// 호텔 리뷰 삭제
   @GetMapping("/deleteHotelReview")
   public String deleteHotelPaymentReview(int roomPaymentReviewId, int hotelId, String hotelName) {
	   System.out.println(roomPaymentReviewId + "roomPaymentReviewId!"); 
	   mainExperienceOrHotelReviewService.getdeletehotelReview(roomPaymentReviewId);
	   System.out.println("삭제 완료!"); 
	   return "redirect:/mainHotelOne?hotelId="+hotelId+"&hotelName="+hotelName;
   }

}




























