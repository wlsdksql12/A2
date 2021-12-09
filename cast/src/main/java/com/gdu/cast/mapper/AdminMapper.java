package com.gdu.cast.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Admin;

@Mapper
public interface AdminMapper {
	Admin selectAdmin(Admin admin); // 관리자 로그인 시 사용
}
