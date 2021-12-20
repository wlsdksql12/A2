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
	int selectNewCustomer();
	
	// 관리자 페이지 신규 여행작가수
	int selectNewTraveler();
	
	// 관리자 페이지 신규 ceo수
	int selectNewCeo();
	
	//관리자 페이지에 qna미답변 개수 출력
	int selectNewNotQnaComment();
}

