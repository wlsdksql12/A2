package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.SubscriptionMapper;
import com.gdu.cast.vo.Ceo;
import com.gdu.cast.vo.Subscription;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Service
public class SubscriptionService {
	@Autowired SubscriptionMapper subscriptionMapper;
	
	public List<Subscription> SubscriptionList() {
		return subscriptionMapper.selectSubscriptionList();
	}
	
	// 사업자의 구독 정보 조회
	public int getSubscriptionNo(String ceoId) {
		return subscriptionMapper.selectSubscriptionNo(ceoId);
	}
	
	// 사업자의 구독 정보 변경
	public void modifyCeoSubscription(String ceoId, int subscriptionNo) {
		Map<String, Object> map = new  HashMap<>();
		map.put("ceoId", ceoId);
		map.put("subscriptionNo", subscriptionNo);
		subscriptionMapper.updateCeoSubscription(map);
	}

	/* 매년 1월 1일 구독결제 자동 DB입력
	@Scheduled(cron = "0 0 0 1 1 ? *", zone = "Asia/Seoul")
	public void autoPayment() {
		// 0 0 0 1 1 ? * == 초 분 시 일 월 요일 년
		List<Ceo> ceoList = subscriptionMapper.selectAutoPaymentCeoList();
		for(Ceo c : ceoList) {
			log.debug(c.getCeoId()+c.getSubscriptionNo()+"스케쥴러 테스트");
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("ceoId", c.getCeoId());
			paramMap.put("subscriptionNo", c.getSubscriptionNo());
			subscriptionMapper.insertAutoPayment(paramMap);
		}
	}
	*/
}
