package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.AdminMapper;
import com.gdu.cast.vo.Qna;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminQnaService {
	@Autowired AdminMapper adminMapper;
	 public Map<String, Object> selectQna(int currentPage, int ROW_PER_PAGE) {
		   Map<String, Object> map = new HashMap<>();
		   
		   int beginRow = (currentPage-1)*ROW_PER_PAGE;
		   map.put("beginRow", beginRow); 
		   map.put("ROW_PER_PAGE", ROW_PER_PAGE);
		
		   List<Qna> qnaList = adminMapper.selectQnaList(map);
			Map<String, Object> returnMap = new HashMap<>();
			
			int lastPage = 0;
			int totalCount = adminMapper.selectQnaTotalCount();
			lastPage = totalCount / ROW_PER_PAGE;
			
			if(totalCount%ROW_PER_PAGE != 0) {
				lastPage += 1;
			}
			
			returnMap.put("qnaList", qnaList);
			returnMap.put("lastPage", lastPage);
			return returnMap;
	   }
}
