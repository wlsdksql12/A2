package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Ceo;
import com.gdu.cast.vo.Customer;
import com.gdu.cast.vo.Traveler;

@Mapper
public interface MemberListMapper {
	
	// 고객 리스트 글갯수
	int selectCustomerListTotalCount(String searchTitle);
		
	// 고객 리스트 출력
	List<Customer> selectCustomerList(Map<String, Object> map);
	
	// 사업자 리스트 글갯수
	int selectCeoListTotalCount(String searchTitle);
		
	// 사업자 리스트 출력
	List<Ceo> selectCeoList(Map<String, Object> map);
	
	// 여행작가 리스트 글갯수
	int selectTravelerListTotalCount(String searchTitle);
		
	// 여행작가 리스트 출력
	List<Traveler> selectTravelerList(Map<String, Object> map);
}
