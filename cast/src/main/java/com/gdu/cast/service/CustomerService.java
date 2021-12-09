package com.gdu.cast.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.CustomerMapper;
import com.gdu.cast.vo.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerService {
	@Autowired CustomerMapper customerMapper;
	
	public void addCustomer(Customer customer) {
		String customerId = customer.getCustomerId();
		String customerName = customer.getCustomerName();
		String customerJumin = customer.getCustomerJumin();
		String customerEmail = customer.getCustomerJumin();
		String customerPw = customer.getCustomerPw();
		String customerPhoneNum = customer.getCustomerPhoneNum();
		String customerActive = customer.getActive();
		
		customer.setCustomerId(customerId);
		customer.setCustomerName(customerName);
		customer.setCustomerJumin(customerJumin);
		customer.setCustomerEmail(customerEmail);
		customer.setCustomerPw(customerPw);
		customer.setCustomerPhoneNum(customerPhoneNum);
		customer.setActive(customerActive);
	    
		customerMapper.insertCustomer(customer);
		log.debug(customer.toString());

	}
}
