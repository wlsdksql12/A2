package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.RoomSelect;
import com.gdu.cast.vo.RoomSelectImage;

@Mapper
public interface RoomSelectMapper {
	
	// 여행작가 숙소 이미지 추가
	void insertRoomSelectImage(RoomSelectImage roomSelectImage);
	
	// 여행작가 숙소 추천 추가
	void insertRoomSelect(RoomSelect roomSelect);
	
	// 자신이 등록한 숙소 추천 리스트
	List<RoomSelect> selectRoomSelectList(Map<String, Object> map);
	
	// 자신이 등록한 숙소 추천 글 수
	int selectRoomSelectTotalCount(String travelerId);
}
