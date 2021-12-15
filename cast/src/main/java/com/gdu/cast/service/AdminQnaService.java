package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.AdminQnaMapper;
import com.gdu.cast.vo.Qna;
import com.gdu.cast.vo.QnaComment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminQnaService {
	@Autowired AdminQnaMapper adminQnaMapper;
	 public Map<String, Object> selectQna(int currentPage, int ROW_PER_PAGE) {
		   Map<String, Object> map = new HashMap<>();
		   
		   int beginRow = (currentPage-1)*ROW_PER_PAGE;
		   map.put("beginRow", beginRow); 
		   map.put("ROW_PER_PAGE", ROW_PER_PAGE);
		
		   List<Qna> qnaList = adminQnaMapper.selectQnaList(map);
			Map<String, Object> returnMap = new HashMap<>();
			
			int lastPage = 0;
			int totalCount = adminQnaMapper.selectQnaTotalCount();
			lastPage = totalCount / ROW_PER_PAGE;
			
			if(totalCount%ROW_PER_PAGE != 0) {
				lastPage += 1;
			}
			
			returnMap.put("qnaList", qnaList);
			returnMap.put("lastPage", lastPage);
			return returnMap;
	   }
	 
	 public void insertQnaComment(QnaComment qnaComment) {
		 adminQnaMapper.insertQnaComment(qnaComment);
	 }
	 
	 public QnaComment selectQnaComment(int qnaId) {
		QnaComment qnaComment = adminQnaMapper.selectQnaComment(qnaId);
		return qnaComment;
	 }
	 
	 // qna 알람
	 public List<Qna> getQnaAlarm(String customerId){
		 System.out.println(adminQnaMapper.selectQnaAlarm(customerId).toString() + "adminQnaMapper.selectQnaAlarm(qna)");
		 return adminQnaMapper.selectQnaAlarm(customerId); 
		 
	 }
}
