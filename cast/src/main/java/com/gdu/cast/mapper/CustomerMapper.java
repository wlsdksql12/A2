package com.gdu.cast.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Customer;

@Mapper
public interface CustomerMapper {
	Customer insertCustomer(Customer customer);
}
