package com.gdu.cast.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	@GetMapping("/insertHotel")
	public String insertHotel(Model model, int addressId) {
		
		model.addAttribute("addressId", addressId);
		
		return "/ceo/insertHotel";
	}
	
	@PostMapping("/insertHotel")
	public String insertHotel(HttpSession session, Hotel hotel) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		hotel.setCeoId(ceoId);
		hotService.insertHotel(hotel);
		
		log.debug("====================================" + ceoId + " << ceoId");
		log.debug("====================================" + hotel.toString() + " << hotel Debug");
		
		return "redirect:/insertRoom?hotelId="+hotel.getHotelId();
	}
	
	// 호텔주소 등록
	@GetMapping("/insertHotelAddress")
	public String insertHotelAddress() {
		return "/ceo/insertHotelAddress";
	}
	
	@PostMapping("/insertHotelAddress")
	public String insertHotelAddress(HttpSession session, Address address, Hotel hotel) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		hotel.setCeoId(ceoId);
		
		hotService.insertHotelAddress(address);
		
		return "redirect:/insertHotel?addressId=" + address.getAddressId() + "&ceoId=" + hotel.getCeoId();
	}
	
	// 방 등록
	@GetMapping("/insertRoom")
	public String insertRoom(Model model, int hotelId) {
		model.addAttribute("hotelId", hotelId);
		return "/ceo/insertRoom";
	}
	
	@PostMapping("/insertRoom")
	public String insertRoom(Room room) {
		hotService.insertRoom(room);
		
		return "/ceo/ceoIndex";
	}
	
}