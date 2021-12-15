package com.gdu.cast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.CeoMapper;
import com.gdu.cast.vo.Ceo;

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
}
