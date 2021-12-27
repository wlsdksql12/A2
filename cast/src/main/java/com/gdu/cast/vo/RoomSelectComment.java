package com.gdu.cast.vo;

import lombok.Data;

@Data
public class RoomSelectComment {
	private int roomSelectCommentId;
	private String customerId;
	private int roomSelectId;
	private String roomSelectContent;
	private String createDate;
	private String updateDate;
	private RoomSelect roomSelect;
}
