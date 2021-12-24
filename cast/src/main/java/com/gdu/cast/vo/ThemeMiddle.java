package com.gdu.cast.vo;

import lombok.Data;

@Data
// 테마_중
public class ThemeMiddle {
	private int ThemeMiddleId;
	private int ThemeBigId;
	private String ThemeMiddleName;
	private String createDate;
	private String updateDate;
	
	private ThemeSmall themeSmall;
	private ThemeBig themeBig;
}
