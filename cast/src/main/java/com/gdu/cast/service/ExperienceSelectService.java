package com.gdu.cast.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gdu.cast.mapper.ExperienceSelectMapper;
import com.gdu.cast.vo.AddExperienceSelect;
import com.gdu.cast.vo.ExperienceSelect;
import com.gdu.cast.vo.ExperienceSelectImage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ExperienceSelectService {
	
	@Autowired
	ExperienceSelectMapper experienceSelectMapper;
	
	// 여행작가 체험 추천 추가
	public void addExperienceSelect(AddExperienceSelect addExperienceSelect) {
		
		int experienceSelectId = addExperienceSelect.getExperienceSelectId();
		String travelerId = addExperienceSelect.getTravelerId();
		int experienceId = addExperienceSelect.getExperienceId();
		String experienceSelectTitle = addExperienceSelect.getExperienceSelectTitle();
		String experienceSelectContent = addExperienceSelect.getExperienceSelectContent();
		String createDate = addExperienceSelect.getCreateDate();
		String updateDate = addExperienceSelect.getUpdateDate();
		MultipartFile file = addExperienceSelect.getExperienceSelectImage();
		
		// 1) 체험 추천 입력
		ExperienceSelect experienceSelect = new ExperienceSelect();
		experienceSelect.setExperienceId(experienceSelectId);
		experienceSelect.setTravelerId(travelerId);
		experienceSelect.setExperienceId(experienceId);
		experienceSelect.setExperienceSelectTitle(experienceSelectTitle);
		experienceSelect.setExperienceSelectContent(experienceSelectContent);
		experienceSelect.setCreateDate(createDate);
		experienceSelect.setUpdateDate(updateDate);
		experienceSelectMapper.insertExperienceSelect(experienceSelect);
		System.out.println(experienceSelect +"★★★★Hyun★★★★");
		
		if(file != null) {
		
		// 2) 체험 추천 이미지 추가
		ExperienceSelectImage experienceSelectImage = new ExperienceSelectImage();
		experienceSelectImage.setExperienceSelectId(experienceSelect.getExperienceSelectId());
		
		String imageName = UUID.randomUUID().toString();
		experienceSelectImage.setImageName(imageName);
		
		String originName = file.getOriginalFilename();
		int p = originName.lastIndexOf(".");
		
		String imageExt = originName.substring(p+1);
		experienceSelectImage.setImageExt(imageExt);
		experienceSelectImage.setImageSize(file.getSize());
		experienceSelectImage.setCreateDate(createDate);
		experienceSelectImage.setUpdateDate(updateDate);
		experienceSelectMapper.insertExperienceSelectImage(experienceSelectImage);
		System.out.println(experienceSelectImage +"★★★★Hyun★★★★");
		
		// 3) 파일 저장
		File f = new File("D:\\workspace\\A2\\cast\\src\\main\\webapp\\upload\\"+imageName+"."+imageExt);
			try {
				file.transferTo(f);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				throw new RuntimeException(); // 트랜잭션 구동조건 -> 예외 발생
			}		
		}
	}
	
	// 자신이 등록한 체험 추천 리스트
	public Map<String, Object> getSelectExperienceSelectList(String travelerId, int currentPage, int ROW_PER_PAGE) {
		
		// 1) 매개변수 가공
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow); 
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("travelerId", travelerId);
		log.debug(travelerId);
		
		// 여행작가 체험 추천 리스트
		List<ExperienceSelect> experienceSelectList = experienceSelectMapper.selectExperienceList(paramMap);
		
		// 2) 리턴값 가공
		Map<String, Object> returnMap = new HashMap<>();
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		int totalCount = experienceSelectMapper.selectExperienceTotalCount(travelerId);
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		returnMap.put("experienceSelectList", experienceSelectList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
}
