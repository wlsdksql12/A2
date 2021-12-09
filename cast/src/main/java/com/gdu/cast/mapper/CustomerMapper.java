package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Customer;
import com.gdu.cast.vo.Qna;

@Mapper
public interface CustomerMapper {
	void insertCustomer(Customer customer);
	Customer selectCustomer(Customer customer);
	
	List<Qna> selectQnaList(Map<String, Object> map);
	int selectQnaTotalCount(String CustomerId);
	
	Qna selectQnaOne(int qnaId);
}
