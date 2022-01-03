package com.gdu.cast.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.reactive.AbstractClientHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gdu.cast.mapper.NoticeMapper;
import com.gdu.cast.vo.Notice;
import com.gdu.cast.vo.NoticeImage;
import com.gdu.cast.vo.RoomSelectImage;

@Service
@Transactional
public class NoticeService {
	@Autowired
	NoticeMapper noticeMapper;
	
	public void addNotice(String path, Notice notice) {
		noticeMapper.insertNotice(notice);
		int noticeNo = noticeMapper.selectNoticeNo();
		System.out.println(noticeNo + "noticeNo");
		// 2) 숙소 추천 이미지 추가
		List<NoticeImage> noticeImage = null;
		if(notice.getNoticeImageUproad() != null) {
			noticeImage = new ArrayList<NoticeImage>();
			for(MultipartFile mf : notice.getNoticeImageUproad()) {
				NoticeImage rsi = new NoticeImage();
				rsi.setNoticeNo(noticeNo);
				String originName = mf.getOriginalFilename();
				int p = originName.lastIndexOf(".");
				String imageName = UUID.randomUUID().toString();
				String imageExt = originName.substring(p+1);
				rsi.setImageName(imageName);
				rsi.setImageExt(imageExt);
				rsi.setImageSize(mf.getSize());
				rsi.setCreateDate(notice.getCreateDate());
				rsi.setUpdateDate(notice.getUpdateDate());
				noticeImage.add(rsi);
				System.out.println(noticeImage +"<<< NoticeService.noticeImage");
				try {
					mf.transferTo(new File(path+"upload\\"+imageName+"."+imageExt));
				} catch(Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			}
		}
		if(noticeImage != null) {
			for(NoticeImage rsi : noticeImage) {
				noticeMapper.insertNoticeImage(rsi);
			}
		}
	}
	
	// return : boardList, lastPage
	public Map<String, Object> getNoticeList(int currentPage, int ROW_PER_PAGE, String searchTitle){
		// 1. 매개변수 가공
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		System.out.println(searchTitle + "NoticeService");
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow); // currentPage 가공
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("searchTitle", searchTitle);
		
		// 공지사항 리스트 가져오기
		List<Notice> noticeList = noticeMapper.selectNoticeList(paramMap);
		System.out.println(noticeList + "<----NoticeService");
		// 2. 리턴값 가공
		Map<String, Object> returnMap = new HashMap<>();
		
		
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		
		int totalCount = noticeMapper.selectNoticeTotalCount(searchTitle);
		System.out.println(totalCount + "NoticeService");
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		
		returnMap.put("noticeList", noticeList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
	
	public List<Notice> NoticeOne(int noticeNo) {
		List<Notice> notice =  noticeMapper.selectNoticeOne(noticeNo);
		return notice;
	}
	
	public void updateNotice(Notice notiece) {
		noticeMapper.updateNotice(notiece);
	}
	
	public void deleteNotice(Notice notice) {
		noticeMapper.deleteNotice(notice);
	}
		
}
