package com.gdu.cast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.HotelService;
import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Experience;
import com.gdu.cast.vo.Hotel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HotelController {
	@Autowired
	HotelService hotelService;
	
	@GetMapping("/insertHotel")
	public String insertExp(Model model, int addressId) {
		
		model.addAttribute("addressId" , addressId);
		
		return "/ceo/insertHotel";
	}
	
	@PostMapping("/insertHotel")
	public String insertExp(HttpSession session, Hotel hotel) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		hotel.setCeoId(ceoId);
		System.out.println(ceoId + " << ceoId");
		hotelService.insertHotel(hotel);
		
		log.debug("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+ceoId);
		log.debug("=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-"+hotel.toString());
		
		return "/ceo/ceoIndex";
	}
	
	@GetMapping("/insertHotelAddress")
	public String insertAddress() {
		return "/ceo/insertHotelAddress";
	}
	
	@PostMapping("/insertHotelAddress")
	public String insertAddress(HttpSession session, Address address, Hotel hotel) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		hotel.setCeoId(ceoId);
		
		hotelService.insertHotelAddress(address);
		
		return "redirect:/insertHotel?addressId="+address.getAddressId() + "&ceoId=" + hotel.getCeoId();
	}
}
