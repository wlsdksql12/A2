package com.gdu.cast.vo;

import lombok.Data;

@Data
// 편의성
public class RoomConvenience {
	private int roomId;
	private String stairsThreshold; // 계단과 문턱의 유무
	private String toiletHandle; // 변기 옆 고정 손잡이 유무
	private String showerStallHandle; // 샤워실 고정 손잡이 유무
	private String createDate;
	private String updateDate;
}
