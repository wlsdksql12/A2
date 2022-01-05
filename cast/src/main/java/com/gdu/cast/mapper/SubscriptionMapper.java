package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Subscription;

@Mapper
public interface SubscriptionMapper {
	List<Subscription> selectSubscriptionList();
}
