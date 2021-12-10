package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Customer;
import com.gdu.cast.vo.Qna;

@Mapper
public interface CustomerMapper {
	//회원가입
	void insertCustomer(Customer customer);
	//고객 로그인
	Customer selectCustomer(Customer customer);
	//고객페이지에 들어가는 qna리스트
	List<Qna> selectQnaList(Map<String, Object> map);
	//페이징
	int selectQnaTotalCount(String CustomerId);
	//고객페이지에 있는 qna 상세보기
	Qna selectQnaOne(int qnaId);
	//상세보기한 qna 수정
	int updateQna(Qna qna);
	
	int deleteQnaOne(Qna qna);
}
