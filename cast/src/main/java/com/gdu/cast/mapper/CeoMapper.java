package com.gdu.cast.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Ceo;

@Mapper
public interface CeoMapper {
	int insertCeo(Ceo ceo);
	Ceo loginCeo(Ceo ceo);
}
