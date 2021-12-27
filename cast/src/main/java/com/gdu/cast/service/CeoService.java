package com.gdu.cast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.CeoMapper;
import com.gdu.cast.vo.Ceo;
import com.gdu.cast.vo.Experience;
import com.gdu.cast.vo.Hotel;

@Service
@Transactional
public class CeoService {
@Autowired CeoMapper ceoMapper;
	// 사업가 회원가입
	public void addCeo(Ceo ceo) {
		ceoMapper.insertCeo(ceo);
	}
	// 사업가 로그인
	public Ceo loginCeo(Ceo ceo) {
		return ceoMapper.loginCeo(ceo);
	}
	// 사업가 내정보
	public Ceo getselectCeo(String ceoId) {
		return ceoMapper.selectCeo(ceoId);
	}
	// 사업가 내정보 수정
	public int getupdateCeo(Ceo ceo) {
		return ceoMapper.updateCeo(ceo);
	}
	// 사업가 비밀번호 변경
	public int getUpdateCeoPw(String ceoId, String ceoPw, String newCeoPw) {
		return ceoMapper.updateCeoPw(ceoId, ceoPw, newCeoPw);
	}
	
	// 사업자 메인페이지 체험리스트
	public List<Experience> getselectExperienceIndex(String ceoId){	
		return ceoMapper.selectExperienceIndex(ceoId);
	}
	
	// 사업자 메인페이지 호텔리스트
	public List<Hotel> getselectHotelIndex(String ceoId){
		return ceoMapper.selectHotelIndex(ceoId);
	}
}
