package com.gdu.cast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.AdminMapper;
import com.gdu.cast.vo.Admin;

@Service
@Transactional
public class AdminService {
	@Autowired
	AdminMapper adminMapper;
	
	// 입력받은 ID, PW와 해당하는 관리자정보 찾기
	public Admin getSelectAdmin(Admin admin) {
		return adminMapper.selectAdmin(admin);
	}
	
	public int selectNewCustomer() {
		return adminMapper.selectNewCustomer();
	}
	
	public int selectNewTraveler() {
		return adminMapper.selectNewTraveler();
	}
	
	public int selectNewCeo() {
		return adminMapper.selectNewCeo();
	}
}
