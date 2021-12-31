package com.gdu.cast.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.ExperienceOrderService;
import com.gdu.cast.service.RoomOrderService;
import com.gdu.cast.vo.ExperienceOrder;
import com.gdu.cast.vo.ExperiencePayment;
import com.gdu.cast.vo.RoomFilter;
import com.gdu.cast.vo.RoomOrder;
import com.gdu.cast.vo.RoomPayment;

@Controller
public class CustomerOrderController {
	@Autowired ExperienceOrderService experienceOrderService;
	@Autowired RoomOrderService roomOrderService;
	private final int ROW_PER_PAGE = 10;
	
	// 예약 입력
	@GetMapping("/addExperienceOrder")
	public String getaddExperienceOrder(HttpSession session, Model model, @RequestParam(defaultValue = "1") int experienceId) {
	System.out.println(experienceId + "EXID");
	String customerId = (String) session.getAttribute("loginCustomerId");
	model.addAttribute("experienceId",experienceId);
	model.addAttribute("customerId",customerId);
	
	return "addExperienceOrder";
	}
	
	// 예약 입력
	@PostMapping("/addExperienceOrder")
	public String PostaddOrder(ExperienceOrder experienceOrder, int experienceId) {
		
		return "redirect:/addExperiencePayment?experienceId="+experienceId + "&customerId="+ experienceOrder.getCustomerId() + "&experienceOrderPeople="+experienceOrder.getExperienceOrderPeople()
		+ "&experienceOrderStartDate="+experienceOrder.getExperienceOrderStartDate() + "&experienceOrderEndDate="+experienceOrder.getExperienceOrderEndDate();
	}
	// 결제 입력
	@GetMapping("/addExperiencePayment")
	public String getaddPayment(Model model, ExperienceOrder experienceOrder, int experienceId) {
		System.out.println(experienceOrder.toString() +"experienceOrder.toString()");
		int experiencePrice = experienceOrderService.getexperienceSelectPrice(experienceId);
		String experienceSelectName = experienceOrderService.getexperienceSelectName(experienceId);
		model.addAttribute("customerId", experienceOrder.getCustomerId());
		model.addAttribute("experienceSelectName",experienceSelectName);
		model.addAttribute("experiencePrice",experiencePrice * experienceOrder.getExperienceOrderPeople());
		model.addAttribute("experienceOrderPeople", experienceOrder.getExperienceOrderPeople());
		model.addAttribute("ExperienceOrderStartDate",experienceOrder.getExperienceOrderStartDate());
		model.addAttribute("ExperienceOrderEndDate", experienceOrder.getExperienceOrderEndDate());
		model.addAttribute("customerId", experienceOrder.getCustomerId());
		model.addAttribute("experienceId", experienceId);
		return "addExperiencePayment";
	}
	// 체혐 결제
	@PostMapping("/addExperiencePayment")
	public String postaddPayment(String experiencePaymentMethod,String experiencePaymentMethodNumber,int experienceOrderPeople, int experiencePaymentMoney, String experienceName, String customerId, String experienceOrderEndDate, String experienceOrderStartDate) {
		int Order = experienceOrderService.getexperienceInsertOrder(experienceOrderPeople, experienceName,customerId,experienceOrderEndDate,experienceOrderStartDate);
		System.out.println(Order+"@#@#Order@#@#");
		experienceOrderService.getexperienceInsertPayment(Order,experiencePaymentMethod, experiencePaymentMethodNumber, experiencePaymentMoney);
		return "redirect:/shop";
	}
	// 고객페이지 예약 리스트 출력
	@GetMapping("/CustomerOrderList")
	public String OrderList(Model model, HttpSession session, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "1") int currentPage2) {
		String customerId = (String) session.getAttribute("loginCustomerId");
		Map<String,Object> map = experienceOrderService.getCustomerIndexExperienceOrder(customerId, currentPage, ROW_PER_PAGE);
		System.out.println(map.get("experienceOrderList").toString() + "@#@#map.get(\"experienceOrderList\")@#@#@#");
		Map<String,Object> map2 = roomOrderService.getCustomerIndexRoomOrder(customerId, currentPage2, ROW_PER_PAGE);
		
		
		
		model.addAttribute("roomOrderList", map2.get("roomOrderList"));
		model.addAttribute("lastPage2", map2.get("lastPage"));
		model.addAttribute("experienceOrderList", map.get("experienceOrderList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("currentPage2",currentPage2);
		return "customer/customerOrder";
	}

	// 고객 페이지 결제내역 리스트 출력
	@GetMapping("/CustomerPaymentList")
	public String PaymentList(Model model, HttpSession session, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "1") int currentPage2) {
		String customerId = (String) session.getAttribute("loginCustomerId");
		Map<String,Object> map = experienceOrderService.getCustomerIndexExperiencePayment(customerId, currentPage, ROW_PER_PAGE);
		Map<String,Object> map2 = roomOrderService.getselectCustomerRoomPayment(customerId, currentPage2, ROW_PER_PAGE);
		
		model.addAttribute("roomPaymentList", map2.get("roomPaymentList"));
		model.addAttribute("lastPage2",map2.get("lastPage2"));
		model.addAttribute("currentPage2", currentPage2);
		
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("experiencePaymentList", map.get("experiencePaymentList"));
		return "customer/customerPayment";
		
	}
	
	
	// 숙소 예약 입력 페이지
	@GetMapping("/addHotelOrder")
	public String getaddHotelOrder(HttpSession session, Model model, @RequestParam(defaultValue = "1") int roomId, @RequestParam(defaultValue = "1") int hotelId,
			@RequestParam(defaultValue = "1") String internet, @RequestParam(defaultValue = "1") String kitchen, @RequestParam(defaultValue = "1") String boiler, @RequestParam(defaultValue = "1") String aircon,
			@RequestParam(defaultValue = "1") String  washingMachine, @RequestParam(defaultValue = "1") String  breakfast, @RequestParam(defaultValue = "1") String tv, @RequestParam(defaultValue = "1") String hairdryer,
			@RequestParam(defaultValue = "1") String bidet, @RequestParam(defaultValue = "1") String  stairsThreshold, @RequestParam(defaultValue = "1") String  toiletHandle, @RequestParam(defaultValue = "1") String  showerStallHandle,
			@RequestParam(defaultValue = "1") int bedCount, @RequestParam(defaultValue = "1") int bedroomCount, @RequestParam(defaultValue = "1") int bathroomCount) {
		//System.out.println(roomFilter.getInternet() +"text입니다!");
		String note = 
				" 인텨넷 유무 : " + internet + "\n kitchen : " + kitchen + "\n boiler : " + boiler + "\n aircon : "+ aircon + "\n washingMachine :" +  washingMachine + "\n breakfast : " + breakfast + "\n tv : " + tv + "\n hairdryer : " + hairdryer +
				"\n bidet : " + bidet + "\n stairsThreshold : " + stairsThreshold + "\n toiletHandle : " + toiletHandle + "\n showStallHandle : " + showerStallHandle + "\n bedCount : " + bedCount + "\n bedroomCount :" + bedroomCount + "\n bathroomCount : " + bathroomCount;
		String customerId = (String) session.getAttribute("loginCustomerId");
		// 호텔 이름 select
		String hotelName = roomOrderService.getselectHotelName(hotelId);
		String roomName = roomOrderService.getselectRoomName(roomId);
		model.addAttribute("roomId", roomId);
		model.addAttribute("customerId",customerId);
		model.addAttribute("roomName", roomName);
		model.addAttribute("hotelName", hotelName);
		model.addAttribute("note" ,note);
		return "addHotelOrder";
	}
	// 숙소 예약 
	@PostMapping("/addHotelOrder")
	public String postaddHotelOrder(RoomOrder roomOrder, int roomId) throws UnsupportedEncodingException  {	
		System.out.println("hotel" + roomOrder.getHotelName());
		
		String hotelName = URLEncoder.encode(roomOrder.getHotelName(), "UTF-8");
		String customerId = URLEncoder.encode(roomOrder.getCustomerId(), "UTF-8");
		String note = URLEncoder.encode(roomOrder.getNote(), "UTF-8");
		String roomName = URLEncoder.encode(roomOrder.getRoomName(), "UTF-8");
		
		
		
		return "redirect:/addHotelPayment?customerId="+customerId+"&hotelName="+hotelName+
				"&roomName="+roomName+"&roomOrderEndDate="+roomOrder.getRoomOrderEndDate()+
				"&roomOrderStartDate="+roomOrder.getRoomOrderStartDate()+"&note="+note+"&roomOrderPeople="+roomOrder.getRoomOrderPeople()+"&roomId="+roomId;
	}
	// 숙소 결제 페이지
	@GetMapping("/addHotelPayment")
	public String getaddHotelPayment(Model model, RoomOrder roomOrder, int roomId) throws UnsupportedEncodingException {

		int roomPrice = roomOrderService.getselectRoomPrice(roomId);
		System.out.println(roomOrder.toString()+"debug");
		System.out.println(roomOrder.getHotelName()+"hotelName");
		model.addAttribute("customerId",roomOrder.getCustomerId());
		model.addAttribute("hotelName", roomOrder.getHotelName());
		model.addAttribute("note", roomOrder.getNote());
		model.addAttribute("roomName", roomOrder.getRoomName());
		model.addAttribute("roomOrderEndDate", roomOrder.getRoomOrderEndDate());
		model.addAttribute("roomOrderStartDate", roomOrder.getRoomOrderStartDate());
		model.addAttribute("roomPrice" , roomOrder.getRoomOrderPeople() * roomPrice);
		model.addAttribute("roomOrderPeople", roomOrder.getRoomOrderPeople());
		return "addHotelPayment";
		
	}
	// 숙소 결제 및 예약
	@PostMapping("/addHotelPayment")
	public String postaddHotelPayment(RoomOrder roomOrder, RoomPayment roomPayment) {
		int roomOrderId = roomOrderService.getroomInsertOrder(roomOrder.getCustomerId(), roomOrder.getRoomName(), roomOrder.getHotelName(),roomOrder.getRoomOrderPeople() , roomOrder.getRoomOrderStartDate(), roomOrder.getRoomOrderEndDate(), roomOrder.getNote());
		roomOrderService.getroomInsertPayment(roomOrderId, roomPayment.getRoomPaymentMethod(), roomPayment.getRoomPaymentMethodNumber(), roomPayment.getRoomPaymentMoney());
		
		return "redirect:/shop";
		
	}
}
