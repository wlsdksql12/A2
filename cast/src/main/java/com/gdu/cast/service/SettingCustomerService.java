package com.gdu.cast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.SettingCustomerMapper;

@Service
public class SettingCustomerService {
	@Autowired SettingCustomerMapper settingCustomerMapper;
	
	   // 비밀번호 변경
	   public int getUpdatePwCustomer(String customerId, String customerPw , String newCustomerPw) {
		   
	      return settingCustomerMapper.updatePwCustomer(customerId, customerPw ,newCustomerPw);
	      
	   }
	
	   
}
