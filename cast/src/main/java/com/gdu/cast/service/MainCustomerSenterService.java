package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.MainCustomerSenterMapper;
import com.gdu.cast.vo.Notice;
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
	
	// 메인페이지에 공지사항 리스트 출력
	public Map<String, Object> getNoticeList(int currentPage, int ROW_PER_PAGE, String searchTitle){
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		// 검색어 디버깅
		System.out.println(searchTitle + " <---MainCustomerSenterService");
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow);
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("searchTitle", searchTitle);
		
		// 공지사항 리스트 가져오기
		List<Notice> noticeList = mainCustomerSenMapper.selectNoticeList(paramMap);
		System.out.println(noticeList + " <---MainCustomerSenterService");
		
		// 하단 페이지 숫자에 보이는 첫번째 숫자
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		
		int totalCount = mainCustomerSenMapper.selectNoticeTotalCount(searchTitle);
		System.out.println(totalCount + " <---MainCustomerSenterService");
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		
		// 리턴값
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("noticeList", noticeList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
}