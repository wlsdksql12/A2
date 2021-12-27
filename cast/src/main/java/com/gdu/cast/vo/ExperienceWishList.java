package com.gdu.cast.vo;

import lombok.Data;

@Data
public class ExperienceWishList {
	private String customerId;
	private String experienceId;
	private String createDate;
	private String updateDate;
	private Experience experience;
}
