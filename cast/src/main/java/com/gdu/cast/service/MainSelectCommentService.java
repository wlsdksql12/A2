package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.MainSelectCommentMapper;
import com.gdu.cast.vo.ExperienceSelectComment;


@Transactional
@Service
public class MainSelectCommentService {
	@Autowired MainSelectCommentMapper mainSelectCommentMapper; 
	//추천 댓글 리스트 출력 및 페이징
	public Map<String, Object> getexperienceSelectComment(int currentPage, int row_per_page,int experienceSelectId){
		   Map<String, Object> paramMap = new HashMap<>();
			
		   int beginRow = 0;
			int displayPage = 10;
			int startPage = 0;
			int lastPage = 0;
		   beginRow = (currentPage-1)*row_per_page;
		   paramMap.put("beginRow", beginRow); 
		   paramMap.put("ROW_PER_PAGE", row_per_page);
		   paramMap.put("experienceSelectId", experienceSelectId);
		   List<ExperienceSelectComment> selectCommentList = mainSelectCommentMapper.experienceSelectComment(paramMap);
		   
		   startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		   
		   
		   
		   int totalCount = mainSelectCommentMapper.selectCommentTotalCount();
			System.out.println(totalCount + " <---selectCommentTotalCount");
			lastPage = startPage + displayPage - 1;
			int totalPage = totalCount / row_per_page;
			if(totalCount % row_per_page != 0) {
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
	
	//메인 체험 추천 댓글 추가
	public void getExperienceSelectInsertComment(ExperienceSelectComment experienceSelectComment) {
		System.out.println(experienceSelectComment.getCustomerId() + "experienceSelectComment. service");
		mainSelectCommentMapper.ExperienceSelectInsertcomment(experienceSelectComment);
		
	}
}