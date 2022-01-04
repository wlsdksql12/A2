package com.gdu.cast.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gdu.cast.mapper.ExhibitionMapper;
import com.gdu.cast.vo.Exhibition;
import com.gdu.cast.vo.ExhibitionImage;
import com.gdu.cast.vo.NoticeImage;

@Service
@Transactional
public class ExhibitionService {
	@Autowired
	ExhibitionMapper exhibitionMapper;
	
	// 전시소개 작성
	public void addExhibition(String path, Exhibition exhibition) {
		exhibitionMapper.insertExhibition(exhibition);
		int exhibitionNo = exhibition.getExhibitionNo();
		System.out.println(exhibitionNo + " <<< exhibitionNo값");
		// 2) 숙소 추천 이미지 추가
		List<ExhibitionImage> exhibitionImage = null;
		if(exhibition.getExhibitionImageUproad() != null) {
			exhibitionImage = new ArrayList<ExhibitionImage>();
			for(MultipartFile mf : exhibition.getExhibitionImageUproad()) {
				ExhibitionImage rsi = new ExhibitionImage();
				rsi.setExhibitionNo(exhibitionNo);
				String originName = mf.getOriginalFilename();
				int p = originName.lastIndexOf(".");
				String imageName = UUID.randomUUID().toString();
				String imageExt = originName.substring(p+1);
				// if문을 이용해 파일추가 안할시 DB에 NULL값 저장되는걸 방지
				if(imageExt.equals("")) {
					// System.out.println("확장자 여백디버깅");
					break;
				}
				rsi.setImageName(imageName);
				rsi.setImageExt(imageExt);
				rsi.setImageSize(mf.getSize());
				rsi.setCreateDate(exhibition.getCreateDate());
				rsi.setUpdateDate(exhibition.getUpdateDate());
				exhibitionImage.add(rsi);
				System.out.println(exhibitionImage +"<<< ExhibitionService.exhibitionImage");
				try {
					mf.transferTo(new File(path+"upload\\"+imageName+"."+imageExt));
				} catch(Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			}
		}
		if(exhibitionImage != null) {
			for(ExhibitionImage rsi : exhibitionImage) {
				exhibitionMapper.insertExhibitionImage(rsi);
			}
		}
	
	}
	
	// 전시소개 리스트 페이지
	public Map<String, Object> getExhibitionList(int currentPage, int ROW_PER_PAGE, String searchTitle){
		// 1. 매개변수 가공
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		System.out.println(searchTitle + "ExhibitionService");
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow); // currentPage 가공
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("searchTitle", searchTitle);
		
		// 전시소개 리스트 가져오기
		List<Exhibition> exhibitionList = exhibitionMapper.selectExhibitionList(paramMap);
		System.out.println(exhibitionList + "ExhibitionService");
		// 2. 리턴값 가공
		Map<String, Object> returnMap = new HashMap<>();
		
		
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		
		int totalCount = exhibitionMapper.selectExhibitionTotalCount(searchTitle);
		System.out.println(totalCount + "ExhibitionService");
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		
		returnMap.put("exhibitionList", exhibitionList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
	
	// 전시소개 상세보기
	public List<Exhibition> getExhibitionOne(int exhibitionNo) {
		List<Exhibition> exhibition =  exhibitionMapper.selectExhibitionOne(exhibitionNo);
		return exhibition;
	}
	
	// 전시소개 수정
	public void updateNotice(Exhibition exhibition) {
		exhibitionMapper.updateExhibition(exhibition);
	}
	
	// 전시소개 삭제
	public void deleteExhibition(Exhibition exhibition) {
		exhibitionMapper.deleteExhibition(exhibition);
	}
	
	// 메인페이지 전시소개 리스트 4개
	public List<Exhibition> getExhibitionList1(){
		List<Exhibition> exhibitionList = exhibitionMapper.selectExhibitionList1();
		System.out.println(exhibitionList + "<----ExhibitionService");
		
		return exhibitionList;
	}
}
