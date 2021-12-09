package com.gdu.cast.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Traveler;

@Mapper
public interface TravelerMapper {
	int insertTraveler(Traveler traveler);
}
