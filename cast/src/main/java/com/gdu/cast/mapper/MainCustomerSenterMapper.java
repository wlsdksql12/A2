package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Qna;

@Mapper
public interface MainCustomerSenterMapper {
	//고객페이지에 들어가는 qna리스트
	List<Qna> selectQnaList(Map<String, Object> map);
	int selectQnaTotalCount();
}
