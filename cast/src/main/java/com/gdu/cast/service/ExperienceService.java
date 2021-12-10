package com.gdu.cast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.ExperienceMapper;
import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Experience;

@Service
@Transactional
public class ExperienceService {
	@Autowired
	ExperienceMapper experienceMapper;
	
	public void insertExp(Experience experience) {
		experienceMapper.insertExp(experience);
	}
	
	public void insertAddress(Address address) {
		experienceMapper.insertAddress(address);
	}
}
