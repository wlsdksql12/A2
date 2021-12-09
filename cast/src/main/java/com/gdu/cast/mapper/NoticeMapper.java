package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Notice;


@Mapper
public interface NoticeMapper {
	void insertNotice(Notice notice);
	
	// 공지사항 리스트 글갯수
	int selectNoticeTotalCount(String searchTitle);
	
	// 공지사항 리스트 출력
	List<Notice> selectNoticeList(Map<String, Object> map);
}
