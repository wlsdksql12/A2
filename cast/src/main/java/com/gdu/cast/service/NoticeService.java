package com.gdu.cast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.NoticeMapper;

@Service
@Transactional
public class NoticeService {
	@Autowired
	NoticeMapper noticeMapper;
}
