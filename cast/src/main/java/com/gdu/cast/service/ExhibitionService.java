package com.gdu.cast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.ExhibitionMapper;
import com.gdu.cast.vo.Exhibition;

@Service
@Transactional
public class ExhibitionService {
	@Autowired
	ExhibitionMapper exhibitionMapper;
	
	public void addExhibition(Exhibition exhibition) {
		exhibitionMapper.insertExhibition(exhibition);
	}
}
