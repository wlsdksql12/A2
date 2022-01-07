package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Admin;
import com.gdu.cast.vo.Qna;

@Mapper
public interface AdminMapper {
	Admin selectAdmin(Admin admin); // 관리자 로그인 시 사용
	
	// 관리자 페이지 신규회원수
	Map<String, Object> selectNewCustomer();
	
	// 관리자 페이지 신규 여행작가수
	Map<String, Object> selectNewTraveler();
	
	// 관리자 페이지 신규 ceo수
	Map<String, Object> selectNewCeo();
	
	// 관리자 페이지에 qna미답변 개수 출력
	int selectNewNotQnaComment();

	// 관리자 페이지 누적 예약 수
	int selectOrderCount();
	
	// 관리자 누적 연간 수익
	int selectTotalPay();
}

