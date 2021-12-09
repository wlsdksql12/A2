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
	
	public Ceo loginCeo(Ceo ceo) {
		return ceoMapper.loginCeo(ceo);
	}
}
