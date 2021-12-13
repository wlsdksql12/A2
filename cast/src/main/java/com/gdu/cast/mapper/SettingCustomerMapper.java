package com.gdu.cast.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SettingCustomerMapper {
	  int updatePwCustomer(String customerId, String customerPw , String newCustomerPw);
}
