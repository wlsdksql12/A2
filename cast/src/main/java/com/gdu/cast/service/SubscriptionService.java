package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.cast.mapper.SubscriptionMapper;
import com.gdu.cast.vo.Subscription;

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
}
