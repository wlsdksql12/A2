package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Experience;
import com.gdu.cast.vo.ExperienceSelect;
import com.gdu.cast.vo.ExperienceSelectComment;
import com.gdu.cast.vo.Hotel;
import com.gdu.cast.vo.RoomSelect;
import com.gdu.cast.vo.RoomSelectComment;
import com.gdu.cast.vo.Traveler;

@Mapper
public interface TravelerMapper {
	
	// 자신이 등록한 체험 추천 댓글 알람
	List<ExperienceSelect> selectExperienceSelectAlram(String travelerId);
	
	// 자신이 등록한 숙소 추천 댓글 알람
	List<RoomSelect> selectRoomSelectAlarm(String travelerId);

	// 최근 체험 등록 리스트(5개)
	List<Experience> selectExperienceListByMain();
	
	// 최근 호텔 등록 리스트(5개)
	List<Hotel> selectHotelListByMain();
	
	// 자신이 등록한 체험 추천 글의 댓글 수
	int selectExperienceSelectCommentTotalCount(String travelerId);
	
	// 자신이 등록한 숙소 추천 글의 댓글 수
	int selectRoomSelectCommentTotalCount(String travelerId);
	
	// 자신이 등록한 체험 추천 글의 댓글 리스트
	List<ExperienceSelectComment> selectExperienceSelectCommentList(Map<String, Object> map);
	
	// 자신이 등록한 숙소 추천 글의 댓글 리스트
	List<RoomSelectComment> selectRoomSelectCommentList(Map<String, Object> map);
	
	// 여행작가 메인 페이지 자신이 등록한 체험 추천 글의 댓글 출력(5개)
	List<ExperienceSelectComment> selectExperienceSelectCommentListByMain(String travelerId);
	
	// 여행작가 메인 페이지 자신이 등록한 숙소 추천 글의 댓글 출력(5개)
	List<RoomSelectComment> selectRoomSelectCommentListByMain(String travelerId);
	
	// 여행작가 비밀번호 변경
	int updateTravelerPw(String travelerId, String travelerPw, String newTravelerPw);
	
	// 회원 탈퇴 한 아이디의 중복값
	int selectDeleteTravelerId(String travelerId);
	
	// 회원 가입 시 아이디 중복 검사
	String selectTravelerId(String travelerId);
	
	// 회원 탈퇴 시 비밀번호 조회
	int selectTravelerPw(String travelerId, String travelerPw);
	
	// 회원 탈퇴(delete_id 테이블에 id 값 입력)
	void insertDeleteTravelerId(String travelerId);
	
	// 회원 탈퇴(traveler 테이블 데이터 삭제)
	void deleteTraveler(String travelerId, String travelerPw);
	
	// 여행작가 메인 페이지 자신이 등록한 체험 추천 리스트 출력(5개)
	List<ExperienceSelect> selectExperienceSelectListByMain(String travelerId);
	
	// 여행작가 메인 페이지 자신이 등록한 숙소 추천 리스트 출력(5개)
	List<RoomSelect> selectRoomSelectListByMain(String travelerId);
	
	// 여행작가 내정보 수정
	int updateTravelerMyInfo(Traveler traveler);
	
	// 여행작가 내정보 보기
	Traveler selectTravelerMyInfo(String TravelerId);
	
	// 여행작가 로그인
	Traveler selectTraveler(Traveler traveler);
	
	// 여행작가 회원가입
	int insertTraveler(Traveler traveler);
}
