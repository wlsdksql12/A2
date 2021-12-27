package com.gdu.cast.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Ceo;
import com.gdu.cast.vo.Experience;
import com.gdu.cast.vo.Hotel;

@Mapper
public interface CeoMapper {
	// 회원가입
	int insertCeo(Ceo ceo);
	// 로그인
	Ceo loginCeo(Ceo ceo);
	// 내정보 보기
	Ceo selectCeo(String ceoId);
	// 내정보 수정
	int updateCeo(Ceo ceo);
	// 비밀번호 변경
	int updateCeoPw(String ceoId, String ceoPw, String newCeoPw);
	// 사업자 메인페이지 체험리스트
	List<Experience> selectExperienceIndex(String ceoId);
	// 사업자 메인페이지 호텔리스트
	List<Hotel> selectHotelIndex(String ceoId);
}

