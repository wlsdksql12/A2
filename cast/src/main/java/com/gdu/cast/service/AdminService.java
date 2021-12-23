package com.gdu.cast.service;

import java.util.HashMap;
import java.util.Map;

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
	
	public Map<String, Object> selectNewCustomer() {
		Map<String, Object> map = new HashMap<>();
		map = adminMapper.selectNewCustomer();
		return map;
	}
	
	public Map<String, Object> selectNewTraveler() {
		Map<String, Object> map = new HashMap<>();
		map = adminMapper.selectNewTraveler();
		return adminMapper.selectNewTraveler();
	}
	
	public Map<String, Object> selectNewCeo() {
		Map<String, Object> map = new HashMap<>();
		map = adminMapper.selectNewCeo();
		return adminMapper.selectNewCeo();
	}
	
	public int selectNewNotQnaComment() {
		return adminMapper.selectNewNotQnaComment();
	}
	
	public int selectAdminCount(String admin) {
		return adminMapper.selectAdminCount(admin);
	}
}
