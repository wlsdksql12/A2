package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Ceo;
import com.gdu.cast.vo.Subscription;

@Mapper
public interface SubscriptionMapper {
	// 구독정보리스트 출력
	List<Subscription> selectSubscriptionList();
	
	// 구독 결제값 조회
	int selectSubscriptionPay(int subscriptionNo);
	
	// 결제 테이블에 입력
	void insertSubscriptionAmount(Map<String, Object> map);
	
	// 사업자의 세션에 이용할 구독 정보
	Integer selectSessionSubscriptionNo(String ceoId);
	
	// 사업자의 구독 정보 조회
	int selectSubscriptionNo(String ceoId);
	
	// 사업자의 구독 정보 변경
	void updateCeoSubscription(Map<String, Object> map);
	
	// 사업자의 구독 정보 변경 시 결제 기록 조회
	int selectSubscriptionAmount(String ceoId);
	
	// 매년 1월 1일 구독 결제 DB에 입력될 사업자 정보 조회
	List<Ceo> selectAutoPaymentCeoList();
	
	// 매년 1월 1일 구독 결제 DB에 입력
	void insertAutoPayment(Map<String, Object> map);
	
	// 사업자 구독 정보 업그레이드 시 변경
	void updateSubscriptionPay(Map<String, Object> map);
}