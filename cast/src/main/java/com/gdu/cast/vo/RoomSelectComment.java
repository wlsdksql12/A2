package com.gdu.cast.vo;

import lombok.Data;

@Data
public class RoomSelectComment {
	public int roomSelectCommentId;
	public String customerId;
	public int roomSelectId;
	public String roomSelectContent;
	public String createDate;
	public String updateDate;
}
