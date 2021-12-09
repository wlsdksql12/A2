package com.gdu.cast.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Experience;

@Mapper
public interface ExperienceMapper {
	void insertExp(Experience experience);
}
