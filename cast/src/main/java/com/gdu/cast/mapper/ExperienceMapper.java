package com.gdu.cast.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Experience;

@Mapper
public interface ExperienceMapper {
	int insertExp(Experience experience);
	int insertAddress(Address address);
}
