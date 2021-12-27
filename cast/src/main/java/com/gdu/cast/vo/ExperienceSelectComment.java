package com.gdu.cast.vo;

import lombok.Data;

@Data
public class ExperienceSelectComment {
	private int experienceSelectCommentId;
	private String customerId;
	private int experienceSelectId;
	private String experienceSelectContent;
	private String createDate;
	private String updateDate;
	private ExperienceSelect experienceSelect;
}
