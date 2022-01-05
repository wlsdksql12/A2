package com.gdu.cast.service;

import java.util.List;

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
}
