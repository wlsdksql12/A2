package com.gdu.cast.vo;

import lombok.Data;

@Data
// qna 답변
public class QnaComment {
	private int qnaId;
	private String adminId;
	private String qnaCommentContent;
	private String createDate;
	private String updateDate;
	
}
