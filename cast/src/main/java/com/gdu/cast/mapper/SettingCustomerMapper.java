package com.gdu.cast.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SettingCustomerMapper {
	// 비밀번호 변경
	  int updatePwCustomer(String customerId, String customerPw , String newCustomerPw);
	  // 회원탈퇴(인설트 딜리트 테이블 입력)
	  void insertDeleteId(String customerId);
	  // 회원탈퇴(customer 테이블 삭제)
	  void deleteCustomer(String customerId, String customerPw);
	  //로그인 기록 삭제
	  void deleteCustomerLogin(String customerId);
	  // 비밀번호 조회
	  int selectCustomerPw(String customerId, String customerPw);
	  // 체험 관심상품 삭제
	  void deleteCustomerWishList(String customerId);
}
