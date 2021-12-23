package com.gdu.cast.vo;

import lombok.Data;

@Data
public class ExperienceSelect {
	private int experienceSelectId;
	private String travelerId;
	private int experienceId;
	private String experienceSelectTitle;
	private String experienceSelectContent;
	private String createDate;
	private String updateDate;
	private Traveler traveler;
}
