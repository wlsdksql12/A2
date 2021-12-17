package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.ExperienceSelectComment;

@Mapper
public interface MainSelectCommentMapper {
	//체험 추천 댓글 리스트 출력
	List<ExperienceSelectComment> experienceSelectComment(Map<String, Object> map);
	//체험 추천 댓글 리스트 페이징
	int selectCommentTotalCount();
	//체험 추천 댓글 추가
	void ExperienceSelectInsertcomment(ExperienceSelectComment experienceSelectComment);
	// 체험 추천 댓글 수정
	int ExperienceSelectUpdatecomment(ExperienceSelectComment experienceSelectComment);
	// 체험 추천 댓글 삭제
	int ExperienceSelectDeletecomment(ExperienceSelectComment experienceSelectComment);
}