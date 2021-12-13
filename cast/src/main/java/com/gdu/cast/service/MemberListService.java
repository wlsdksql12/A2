package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.MemberListMapper;
import com.gdu.cast.vo.Ceo;
import com.gdu.cast.vo.Customer;

@Service
public class MemberListService {
	@Autowired
	MemberListMapper memberListMapper;
	
	
	// 고객 리스트 페이지
	public Map<String, Object> getCustomerList(int currentPage, int ROW_PER_PAGE, String searchTitle){
		// 1. 매개변수 가공
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		System.out.println(searchTitle + " <----MemberListService");
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow);
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("searchTitle", searchTitle);
		
		// 고객 리스트 가져오기
		List<Customer> customerList = memberListMapper.selectCustomerList(paramMap);
		System.out.println(customerList + "<----MemberListService");
		// 2. 리턴값 가공
		Map<String, Object> returnMap = new HashMap<>();
		
		
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		
		// 고객 리스트 총 글갯수
		int totalCount = memberListMapper.selectCustomerListTotalCount(searchTitle);
		System.out.println(totalCount + "<----MemberListService");
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		
		returnMap.put("customerList", customerList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
	
	// 사업자 리스트 페이지
	public Map<String, Object> getCeoList(int currentPage, int ROW_PER_PAGE, String searchTitle){
		// 1. 매개변수 가공
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		System.out.println(searchTitle + " <----MemberListService");
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow);
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("searchTitle", searchTitle);
		
		// 고객 리스트 가져오기
		List<Ceo> ceoList = memberListMapper.selectCeoList(paramMap);
		System.out.println(ceoList + "<----MemberListService");
		// 2. 리턴값 가공
		Map<String, Object> returnMap = new HashMap<>();
		
		
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		
		// 고객 리스트 총 글갯수
		int totalCount = memberListMapper.selectCeoListTotalCount(searchTitle);
		System.out.println(totalCount + "<----MemberListService");
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		
		returnMap.put("ceoList", ceoList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
}
