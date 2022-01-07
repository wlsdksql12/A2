package com.gdu.cast.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.SubscriptionMapper;
import com.gdu.cast.vo.Ceo;
import com.gdu.cast.vo.Subscription;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Component
@Slf4j
@Service
public class SubscriptionService {
	@Autowired SubscriptionMapper subscriptionMapper;
	
	// 구독 정보 리스트
	public List<Subscription> SubscriptionList() {
		return subscriptionMapper.selectSubscriptionList();
	}
	
	// 사업자의 세션에 입력할 구독 정보 조회
	public Integer getSessionSubscriptionNo(String ceoId) {
		return subscriptionMapper.selectSessionSubscriptionNo(ceoId);
	}
	
	// 사업자의 구독 정보 조회
	public int getSubscriptionNo(String ceoId) {
		return subscriptionMapper.selectSubscriptionNo(ceoId);
	}
	
	// 사업자의 구독 정보 변경
	public void modifyCeoSubscription(String ceoId, int subscriptionNo) {
		// 사업자 구독 정보 변경
		Map<String, Object> map = new  HashMap<>();
		map.put("ceoId", ceoId);
		map.put("subscriptionNo", subscriptionNo);
		subscriptionMapper.updateCeoSubscription(map);
		
		// 올해 구독 결제 DB에 없을 시 추가
		int subscriptionAmountResult = subscriptionMapper.selectSubscriptionAmount(ceoId);
		if(subscriptionAmountResult == 0 && subscriptionNo != 1) {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("ceoId", ceoId);
			paramMap.put("subscriptionNo", subscriptionNo);
			// 구독의 결제 값 조회
			int subscriptionPay = subscriptionMapper.selectSubscriptionPay(subscriptionNo);
			// System.out.println(subscriptionPay + "구독 가격");
			// 현재 날짜 구하기
			LocalDate nowDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
			// System.out.println(nowDate + "현재 날짜");
			// 분기별 날짜
			LocalDate date1 = nowDate.withMonth(1).withDayOfMonth(1);
			LocalDate date2 = nowDate.withMonth(4).withDayOfMonth(1);
			LocalDate date3 = nowDate.withMonth(7).withDayOfMonth(1);
			LocalDate date4 = nowDate.withMonth(10).withDayOfMonth(1);
			int amount = 0;
			// 분기별 가격 구하기
			if(nowDate.isAfter(date1) && nowDate.isBefore(date2)) { // 1분기 조건
				amount = subscriptionPay;
			} else if(nowDate.isAfter(date2) && nowDate.isBefore(date3)) { // 2분기 조건
				amount = ((subscriptionPay * 75) / 100);
			} else if(nowDate.isAfter(date3) && nowDate.isBefore(date4)) { // 3분기 조건
				amount = ((subscriptionPay * 50) / 100);
			} else { // 4분기
				amount = ((subscriptionPay * 50) / 100);
			}
			paramMap.put("amount", amount);
			subscriptionMapper.insertSubscriptionAmount(paramMap);
		}
	}

	// 매년 1월 1일 구독결제 자동 DB입력
	@Scheduled(cron = "0 0 0 1 1 ?", zone = "Asia/Seoul")
	public void autoPayment() {
		// 0 0 0 1 1 ? * == 초 분 시 일 월 요일 년(생략가능)
		List<Ceo> ceoList = subscriptionMapper.selectAutoPaymentCeoList();
		for(Ceo c : ceoList) {
			log.debug(c.getCeoId()+c.getSubscriptionNo()+"스케쥴러 테스트");
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("ceoId", c.getCeoId());
			paramMap.put("subscriptionNo", c.getSubscriptionNo());
			subscriptionMapper.insertAutoPayment(paramMap);
		}
	}
}
