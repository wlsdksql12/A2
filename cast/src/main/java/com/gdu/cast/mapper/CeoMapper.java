package com.gdu.cast.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Ceo;

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
}

