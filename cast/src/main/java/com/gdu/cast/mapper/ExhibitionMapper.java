package com.gdu.cast.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Exhibition;

@Mapper
public interface ExhibitionMapper {
	void insertExhibition(Exhibition exhibition);
}
