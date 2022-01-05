package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Subscription;

@Mapper
public interface SubscriptionMapper {
	// 구독정보리스트 출력
	List<Subscription> selectSubscriptionList();
	
	// 구독 결제값 조회
	int selectSubscriptionPay(int subscriptionNo);
	
	// 결제 테이블에 입력
	void insertSubscriptionAmount(Map<String, Object> map);
}
