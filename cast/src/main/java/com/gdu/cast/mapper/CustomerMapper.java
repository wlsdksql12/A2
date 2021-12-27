package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Customer;
import com.gdu.cast.vo.Customer_Login;
import com.gdu.cast.vo.Delete_Id;
import com.gdu.cast.vo.Experience;
import com.gdu.cast.vo.ExperienceSelectComment;
import com.gdu.cast.vo.Hotel;
import com.gdu.cast.vo.Qna;
import com.gdu.cast.vo.RoomSelectComment;

@Mapper
public interface CustomerMapper {
	//회원가입
	void insertCustomer(Customer customer);
	//고객 로그인
	Customer selectCustomer(Customer customer);
	//고객페이지에 들어가는 qna리스트
	List<Qna> selectQnaList(Map<String, Object> map);
	//페이징
	int selectQnaTotalCount(String CustomerId);
	//고객페이지에 있는 qna 상세보기
	Qna selectQnaOne(int qnaId);
	//상세보기한 qna 수정
	int updateQna(Qna qna);
	// qna 삭제
	int deleteQnaOne(Qna qna);
	// 내정보 보기
	Customer selectInfo(String customerId);
	// 내정보 수정
	int updateInfo(Customer customer);
	// 활성화, 비활성화
	Customer selectActive(String customerId);
	// 로그인 기록 업데이트
	int updateDate(String customerId);
	//  회원 가입 시 로그인 기록 생성
	int insertCustomerLogin(String customerId);
	// 로그인 기록 출력
	Customer_Login selectCustomerLogin(Customer_Login customer_Login);
	// 비활성화 상태 적용
	int updateActiveZeroDate(String CustomerId);
	// 활성화 상태 적용
	int updateActiveOneDate(String CustomerId);
	// 회원탈퇴 중복
	int selectDeleteId(String customerId);
	// customer테이블 회원가입 중복
	String selectCustomerOK(String customerId);
	// 체험 등록 5개 리스트
	List<Experience> selectCustomerIndexExperienceList();
	// 호텔 등록 5개 리스트
	List<Hotel> selectCustomerIndexHoelList();
	// 고객이 작성한 총 댓글 수
	int selectCustomerCommentCount(String CustomerId);
	// 고객이 결제한 총 금액
	int selectCustomerPaymentCount(String CustomerId);
	// 고객이 예약한 총 횟수
	int selectCustomerOrderCount(String customerId);
	// 고객 체험 댓글 리스트 출력
	List<ExperienceSelectComment> CustomerExperienceSelectCommentList(Map<String, Object> Map);
	// 고객 체험 댓글 페이징
	int CustomerselectCommentTotalCount(String customerId);
	// 고객 숙소 댓글 리스트 출력
	List<RoomSelectComment> CustomerRoomSelectCommentList(Map<String , Object> Map);
	// 고객 숙소 댓글 페이징
	int CustomerselectRoomCommentTotalCount(String CustomerId);
	// 총 결제금액 조건문
	int selectCustomerExperienceOrderId(String customerId);
	// 총 결제금액 조건문
	int  selectcustomerRoomOrderId(String customerId);

}
