package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Qna;
import com.gdu.cast.vo.QnaComment;

@Mapper
public interface AdminQnaMapper {
	//Qna리스트
	List<Qna> selectQnaList(Map<String, Object> map);
	//페이징
	int selectQnaTotalCount();
	
	// Qna 답글 생성
	void insertQnaComment(QnaComment qnaComment);
	
	// Qna 답글 출력
	QnaComment selectQnaComment(int qnaId);
}
