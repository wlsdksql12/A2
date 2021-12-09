package com.gdu.cast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.CeoMapper;
import com.gdu.cast.vo.Ceo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class CeoService {
@Autowired CeoMapper ceoMapper;

	public Ceo addCeo(Ceo ceo) {
		String ceoId = ceo.getCeoId();
		String ceoName = ceo.getCeoName();
		String ceoEmail = ceo.getCeoEmail();
		String ceoJumin = ceo.getCeoJumin();
		String ceoLicense = ceo.getCeoLicense();
		String ceoPw = ceo.getCeoPw();
		
		return ceo;
	}
}
