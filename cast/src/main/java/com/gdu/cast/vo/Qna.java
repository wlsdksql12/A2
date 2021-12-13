package com.gdu.cast.vo;

import lombok.Data;

@Data
// Qna 고객 <-> 관리자
public class Qna {
	private int qnaId;
	private String customerId;
	private String qnaTitle;
	private String qnaContent;
	private String qnaCategory;
	private String qnaSecret;
	private String createDate;
	private String updateDate;
	
}
