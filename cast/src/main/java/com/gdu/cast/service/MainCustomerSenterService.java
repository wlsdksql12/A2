package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.MainCustomerSenterMapper;
import com.gdu.cast.vo.Qna;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class MainCustomerSenterService {
	@Autowired MainCustomerSenterMapper mainCustomerSenMapper;
	
	//qna List
	   public Map<String, Object> getselectQna(int currentPage, int ROW_PER_PAGE) {
		   Map<String, Object> paramMap = new HashMap<>();
		   
		   int beginRow = (currentPage-1)*ROW_PER_PAGE;
		   paramMap.put("beginRow", beginRow); 
		   paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		
		   List<Qna> qnaList = mainCustomerSenMapper.selectQnaList(paramMap);
		   
			Map<String, Object> returnMap = new HashMap<>();
			int lastPage = 0;
			int totalCount = mainCustomerSenMapper.selectQnaTotalCount();
			lastPage = totalCount / ROW_PER_PAGE;
			if(totalCount%ROW_PER_PAGE != 0) {
				lastPage += 1;
			}
			returnMap.put("qnaList", qnaList);
			returnMap.put("lastPage", lastPage);
			return returnMap;
	   }
}
