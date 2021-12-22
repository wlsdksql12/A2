package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.ExperienceSelect;
import com.gdu.cast.vo.ExperienceSelectComment;
import com.gdu.cast.vo.RoomSelect;
import com.gdu.cast.vo.RoomSelectComment;

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
	int ExperienceSelectDeletecomment(ExperienceSelect experienceSelect);
	// 숙소 추천 댓글 리스트 출력
	List<RoomSelectComment> roomSelectComment(Map<String, Object> map);
	//숙소 추천 댓글 리스트 페이징
	int roomCommentTotalCount();
	//숙소 추천 댓글 수정
	int roomSelectUpdatecomment(RoomSelectComment roomSelectComment);
	// 숙소 추천 댓글 삭제
	int roomSelectDeletecomment(RoomSelect roomSelect);
	// 숙소 추천 댓글 추가
	void roomSelectInsertcomment(RoomSelectComment roomSelectComment);
}