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

import com.gdu.cast.mapper.ExperienceMapper;
import com.gdu.cast.vo.AddExperience;
import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Experience;
import com.gdu.cast.vo.ExperienceImage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ExperienceService {
	@Autowired
	ExperienceMapper experienceMapper;
	
	// 체험 등록
	public int insertExp(AddExperience addExperience) {

		String ceoId = addExperience.getCeoId();
		int addressId = addExperience.getAddressId();
		String experienceName = addExperience.getExperienceName();
		String experienceContent = addExperience.getExperienceContent();
		int experiencePrice = addExperience.getExperiencePrice();
		String experienceStartdate = addExperience.getExperienceStartdate();
		String experienceEnddate = addExperience.getExperienceEnddate();
		int experiencePerson = addExperience.getExperiencePerson();
		String createDate = addExperience.getCreateDate();
		String updateDate = addExperience.getUpdateDate();
		
		Experience experience = new Experience();
		experience.setCeoId(ceoId);
		experience.setAddressId(addressId);
		experience.setExperienceName(experienceName);
		experience.setExperienceContent(experienceContent);
		experience.setExperiencePrice(experiencePrice);
		experience.setExperienceStartdate(experienceStartdate);
		experience.setExperienceEnddate(experienceEnddate);
		experience.setExperiencePerson(experiencePerson);
		experience.setCreateDate(createDate);
		experience.setUpdateDate(updateDate);
		experienceMapper.insertExp(experience);
		
		// 체험 이미지 추가
		List<ExperienceImage> experienceImage = null;
		if(addExperience.getExperienceImage() != null) {
			experienceImage = new ArrayList<ExperienceImage>();
			for(MultipartFile mf :addExperience.getExperienceImage()) {
				ExperienceImage esi = new ExperienceImage();
				esi.setExperienceId(experience.getExperienceId());
				String originName = mf.getOriginalFilename();
				int p = originName.lastIndexOf(".");
				String imageName = UUID.randomUUID().toString();
				String imageExt = originName.substring(p+1);
				esi.setImageName(imageName);
				esi.setImageExt(imageExt);
				esi.setImageSize(mf.getSize());
				esi.setCreateDate(createDate);
				esi.setUpdateDate(updateDate);
				experienceImage.add(esi);
				System.out.println("@@@@@@@@@@experienceImage" + experienceImage);
				File f = new File("C:\\Users\\공\\git\\A2\\cast\\src\\main\\webapp\\upload\\"+imageName+"."+imageExt);
				try {
					mf.transferTo(f);
				} catch(Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			}
		}
		if(experienceImage != null) {
			for(ExperienceImage esi : experienceImage) {
				experienceMapper.insertExperienceImage(esi);
			}
		}
		return experience.getExperienceId();
	}
	
	// 체험 이미지
	public List<ExperienceImage> getExperienceImage(int experienceId) {
		return experienceMapper.ExperienceImageList(experienceId);
	}
	
	public void insertExpAddress(Address address) {
		experienceMapper.insertExpAddress(address);
	}
	
	public Map<String, Object> getExperienceList(int currentPage, int ROW_PER_PAGE, String searchTitle){
		// 1. 매개변수 가공
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		System.out.println(searchTitle + "ExperienceService");
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow); // currentPage 가공
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("searchTitle", searchTitle);
		
		// 체험 리스트 가져오기
		List<Experience> experienceList = experienceMapper.selectExperienceList(paramMap);
		System.out.println(experienceList + "ExperienceService");
		// 2. 리턴값 가공
		Map<String, Object> returnMap = new HashMap<>();
		
		
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		
		int totalCount = experienceMapper.selectExperienceTotalCount(searchTitle);
		System.out.println(totalCount + "ExperienceService");
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		
		returnMap.put("experienceList", experienceList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
	
	// 체험 상세보기
	public Experience selectExperienceOne(int experienceId) {
		Experience experience = experienceMapper.selectExperienceOne(experienceId);
		return experience;
	}
	
	// 체험 수정하기
	public void updateExperience(Experience experience) {
		log.debug(experience.toString());
		experienceMapper.updateExperience(experience);
	}
	
	// 체험 삭제
	public void deleteExperience(Experience experience) {
		log.debug(experience.toString());
		experienceMapper.deleteExperience(experience);
	}
	
	// 테마 체험 등록
	public void insertThemeExperience(int experienceId, String theme) {
		Map<String, Object> map = new HashMap<>();
		map.put("theme", theme);
		map.put("experienceId", experienceId);
		experienceMapper.insertThemeExperience(map);
	}
}
