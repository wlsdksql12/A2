package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.MainSelectCommentMapper;
import com.gdu.cast.vo.ExperienceSelectComment;
import com.gdu.cast.vo.Qna;

@Service
public class MainSelectCommentService {
	@Autowired MainSelectCommentMapper mainSelectCommentMapper; 
	public Map<String, Object> getexperienceSelectComment(int currentPage, int ROW_PER_PAGE,int experienceSelectId){
		   Map<String, Object> paramMap = new HashMap<>();
			
		   int beginRow = 0;
			int displayPage = 10;
			int startPage = 0;
			int lastPage = 0;
		   beginRow = (currentPage-1)*ROW_PER_PAGE;
		   paramMap.put("beginRow", beginRow); 
		   paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		   paramMap.put("experienceSelectId", experienceSelectId);
		   List<ExperienceSelectComment> selectCommentList = mainSelectCommentMapper.experienceSelectComment(paramMap);
		   
		   startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		   
		   
		   
		   int totalCount = mainSelectCommentMapper.selectCommentTotalCount();
			System.out.println(totalCount + " <---selectCommentTotalCount");
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
			returnMap.put("selectCommentList", selectCommentList);
			returnMap.put("startPage", startPage);
			returnMap.put("lastPage", lastPage);
			returnMap.put("totalPage", totalPage);
			
			return returnMap;
	}
}
