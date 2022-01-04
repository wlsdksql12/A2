package com.gdu.cast.service;

import java.io.File;
import java.util.ArrayList;
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
		
		// 데이터 추가
		String travelerId = addExperienceSelect.getTravelerId();
		int experienceId = addExperienceSelect.getExperienceId();
		String experienceSelectTitle = addExperienceSelect.getExperienceSelectTitle();
		String experienceSelectContent = addExperienceSelect.getExperienceSelectContent();
		String createDate = addExperienceSelect.getCreateDate();
		String updateDate = addExperienceSelect.getUpdateDate();
		
		// 1) 체험 추천 입력
		ExperienceSelect experienceSelect = new ExperienceSelect();
		experienceSelect.setTravelerId(travelerId);
		experienceSelect.setExperienceId(experienceId);
		experienceSelect.setExperienceSelectTitle(experienceSelectTitle);
		experienceSelect.setExperienceSelectContent(experienceSelectContent);
		experienceSelect.setCreateDate(createDate);
		experienceSelect.setUpdateDate(updateDate);
		experienceSelectMapper.insertExperienceSelect(experienceSelect);
		log.debug("★★★★Hyun★★★★"+experienceSelect.toString());
		
		// 2) 체험 추천 이미지 추가
		List<ExperienceSelectImage> experienceSelectImage = null;
		if(addExperienceSelect.getExperienceSelectImage() != null) {
			experienceSelectImage = new ArrayList<ExperienceSelectImage>();
			for(MultipartFile mf : addExperienceSelect.getExperienceSelectImage()) {
				ExperienceSelectImage esi = new ExperienceSelectImage();
				esi.setExperienceSelectId(experienceSelect.getExperienceSelectId());
				String originName = mf.getOriginalFilename();
				int p = originName.lastIndexOf(".");
				String imageName = UUID.randomUUID().toString();
				String imageExt = originName.substring(p+1);
				esi.setImageName(imageName);
				esi.setImageExt(imageExt);
				esi.setImageSize(mf.getSize());
				esi.setCreateDate(createDate);
				esi.setUpdateDate(updateDate);
				experienceSelectImage.add(esi);
				log.debug("★★★★Hyun★★★★"+experienceSelectImage.toString());
				File temp = new File("");
				String path = temp.getAbsolutePath();
				log.debug("★★★★Hyun★★★★"+path);
				try {
					mf.transferTo(new File(path+"\\src\\main\\webapp\\upload\\"+imageName+"."+imageExt));
				} catch(Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			}
		}
		if(experienceSelectImage != null) {
			for(ExperienceSelectImage esi : experienceSelectImage) {
				experienceSelectMapper.insertExperienceSelectImage(esi);
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
		log.debug("★★★★Hyun★★★★"+travelerId);
		
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
		log.debug("★★★★Hyun★★★★"+returnMap.toString());
		
		return returnMap;
	}
}
