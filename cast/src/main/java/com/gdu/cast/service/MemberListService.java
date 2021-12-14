package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.CustomerMapper;
import com.gdu.cast.mapper.MemberListMapper;
import com.gdu.cast.vo.Ceo;
import com.gdu.cast.vo.Customer;
import com.gdu.cast.vo.Traveler;

@Service
public class MemberListService {
	@Autowired
	MemberListMapper memberListMapper;
	@Autowired
	CustomerMapper customerMapper;
	
	// 고객 리스트 페이지
	public Map<String, Object> getCustomerList(int currentPage, int ROW_PER_PAGE, String searchTitle){
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		// 검색어 디버깅
		System.out.println(searchTitle + " <----MemberListService");
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow);
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("searchTitle", searchTitle);
		
		// 고객 리스트 가져오기
		List<Customer> customerList = memberListMapper.selectCustomerList(paramMap);
		System.out.println(customerList + "<----MemberListService");
		
		// 하단 페이지 숫자에 보이는 첫번째 숫자
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		// 고객 리스트 총 글갯수
		int totalCount = memberListMapper.selectCustomerListTotalCount(searchTitle);
		System.out.println(totalCount + "<----MemberListService");
		// 하단 페이지 숫자에 보이는 마지막 숫자
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		
		// 리턴값
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("customerList", customerList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
	
	// 고객 리스트페이지에서 고객 아아디 비활성화 시
	public int updateActiveZeroDate(String customerId) {
		return customerMapper.updateActiveZeroDate(customerId);
	}
	
	// 고객 리스트페이지에서 고객 아아디 활성화 시
	public int updateActiveOneDate(String customerId) {
		return customerMapper.updateActiveOneDate(customerId);
	}
	
	// 사업자 리스트 페이지
	public Map<String, Object> getCeoList(int currentPage, int ROW_PER_PAGE, String searchTitle){
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		// 검색어 디버깅
		System.out.println(searchTitle + " <----MemberListService");
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow);
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("searchTitle", searchTitle);
		
		// 사업자 리스트 가져오기
		List<Ceo> ceoList = memberListMapper.selectCeoList(paramMap);
		System.out.println(ceoList + "<----MemberListService");
		// 하단 페이지 숫자에 보이는 첫번째 숫자
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		// 사업자 리스트 총 글갯수
		int totalCount = memberListMapper.selectCeoListTotalCount(searchTitle);
		System.out.println(totalCount + "<----MemberListService");
		// 하단 페이지 숫자에 보이는 마지막 숫자
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		
		// 리턴값
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("ceoList", ceoList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
	
	// 여행작가 리스트 페이지
	public Map<String, Object> getTravelerList(int currentPage, int ROW_PER_PAGE, String searchTitle){
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		// 검색어 디버깅
		System.out.println(searchTitle + " <----MemberListService");
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow);
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("searchTitle", searchTitle);
		
		// 여행작가 리스트 가져오기
		List<Traveler> travelerList = memberListMapper.selectTravelerList(paramMap);
		System.out.println(travelerList + "<----MemberListService");
		// 하단 페이지 숫자에 보이는 첫번째 숫자
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		// 여행작가 리스트 총 글갯수
		int totalCount = memberListMapper.selectCeoListTotalCount(searchTitle);
		System.out.println(totalCount + "<----MemberListService");
		// 하단 페이지 숫자에 보이는 마지막 숫자
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		
		// 리턴값
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("travelerList", travelerList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
}
