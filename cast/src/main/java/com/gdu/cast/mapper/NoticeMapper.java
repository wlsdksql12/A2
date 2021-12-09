package com.gdu.cast.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Notice;


@Mapper
public interface NoticeMapper {
	void insertNotice(Notice notice);
}
