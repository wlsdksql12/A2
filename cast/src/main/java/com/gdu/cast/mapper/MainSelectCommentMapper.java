package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.ExperienceSelectComment;

@Mapper
public interface MainSelectCommentMapper {
	List<ExperienceSelectComment> experienceSelectComment(Map<String, Object> map);
	int selectCommentTotalCount();
}
