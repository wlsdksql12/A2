package com.gdu.cast.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.reactive.AbstractClientHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.NoticeMapper;
import com.gdu.cast.vo.Notice;

@Service
@Transactional
public class NoticeService {
	@Autowired
	NoticeMapper noticeMapper;
	
	public void addNotice(Notice notice) {
		noticeMapper.insertNotice(notice);
	}
}
