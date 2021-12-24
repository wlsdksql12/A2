package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.ExperienceOrder;
import com.gdu.cast.vo.ExperiencePayment;

@Mapper
public interface ExperienceOrderMapper {
	// 결제 금액에서 사용
	public int experienceSelectPrice(int experienceId);
	// 예약 insert
	public void experienceInsertOrder(String customerId, String experienceName, int experienceOrderPeople, String experienceOrderStartDate, String experienceOrderEndDate);
	// 결제 insert
	public void experienceInsertPayment(int experienceOrderId, String experiencePaymentMethod, String experiencePaymentMethodNumber, int experiencePaymentMoney);
	// 체험 이름에서 사용
	public String experienceSelectName(int experienceId);
	// 예약 아이디 select
	public int experienceOrderId(String customerId);
	// 고객 페이지 본인이 한 예약
	List<ExperienceOrder> CustomerIndexExperienceOrder(Map<String, Object> map);
	// 고객 페이지 예약 페이징
	int selectExperienceOrderTotalCount(String customerId);
	
	
	// 고객 체험 결제 페이지
	List<ExperiencePayment> CustomerIndexExperiencePayment(Map<String, Object> map);
	// 고객 체험 결제 페이징
	int selectExperiencePaymentTotalCount(String customerId);
}
