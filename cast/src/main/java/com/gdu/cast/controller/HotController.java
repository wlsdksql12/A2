package com.gdu.cast.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.HotService;
import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Hotel;
import com.gdu.cast.vo.Room;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HotController {
	@Autowired
	HotService hotService;
	
	// 호텔 등록
	@GetMapping("/ceo/insertHotel")
	public String insertHotel(Model model, int addressId) {
		
		model.addAttribute("addressId", addressId);
		
		return "/ceo/insertHotel";
	}
	
	@PostMapping("/ceo/insertHotel")
	public String insertHotel(Model model, HttpSession session, Hotel hotel) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		hotel.setCeoId(ceoId);
		hotService.insertHotel(hotel);
		
		
		log.debug("====================================" + ceoId + " << ceoId");
		log.debug("====================================" + hotel.toString() + " << hotel Debug");
		
		
		
		
		
		return "redirect:/ceo/insertRoom?hotelId="+hotel.getHotelId() + "&countRoom=" + hotel.getCountRoom();
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
		
		log.debug("@@@@@@@@@"+hotel.getCountRoom());
		int count = hotel.getCountRoom();
		
		model.addAttribute("countRoom",count);
		
		return "/ceo/insertRoom";
	}
	
	@PostMapping("/ceo/insertRoom")
	public String insertRoom(Model model, Room room, Hotel hotel) {
		System.out.println("@@@@@@@@@@@@@");
		
		hotService.insertRoom(room);
		System.out.println("@@@@@@@@@@@@@");
		
		
		
		model.addAttribute(hotel);
		System.out.println("HotController countRoom"+hotel.getCountRoom());
		return "/ceo/ceoIndex";
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
}