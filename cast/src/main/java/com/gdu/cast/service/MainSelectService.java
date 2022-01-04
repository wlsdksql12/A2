package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.MainSelectCommentMapper;
import com.gdu.cast.mapper.MainSelectMapper;
import com.gdu.cast.vo.ExperienceSelect;
import com.gdu.cast.vo.ExperienceSelectImage;
import com.gdu.cast.vo.RoomSelect;
import com.gdu.cast.vo.RoomSelectImage;
import com.gdu.cast.vo.ThemeMiddle;
import com.gdu.cast.vo.ThemeSmall;
import com.gdu.cast.vo.ThemeSmallExperience;
import com.gdu.cast.vo.ThemeSmallHotel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class MainSelectService {
	
	@Autowired
	MainSelectMapper mainSelectMapper;
	
	@Autowired
	MainSelectCommentMapper mainSelectCommentMapper;
	
	// 메인 페이지 숙소 추천 이미지
	public List<RoomSelectImage> getselectRoomSelectImageList(int roomSelectId) {
		System.out.println("★★★★Hyun★★★★"+roomSelectId);
		return mainSelectMapper.selectRoomImageList(roomSelectId);
	}

	// 메인 페이지 체험 추천 이미지
	public List<ExperienceSelectImage> getselectExperienceSelectImageList(int experienceSelectId) {
		System.out.println("★★★★Hyun★★★★"+experienceSelectId);
		return mainSelectMapper.selectExperienceImageList(experienceSelectId);
	}
	
	// 메인 페이지 체험 추천 삭제
	public int removeExperienceSelect(ExperienceSelect experienceSelect) {
		log.debug("★★★★Hyun★★★★"+experienceSelect.toString());
		mainSelectCommentMapper.ExperienceSelectDeletecomment(experienceSelect);
		mainSelectMapper.deleteExperienceSelectImage(experienceSelect);
		return mainSelectMapper.deleteExperienceSelect(experienceSelect);
	}
	
	// 메인 페이지 숙소 추천 삭제
	public int removeRoomSelect(RoomSelect roomSelect) {
		log.debug("★★★★Hyun★★★★"+roomSelect.toString());
		mainSelectCommentMapper.roomSelectDeletecomment(roomSelect);
		mainSelectMapper.deleteRoomSelectImage(roomSelect);
		return mainSelectMapper.deleteRoomSelect(roomSelect);
	}
	
	// 메인 페이지 체험 추천 수정
	public void modifyExperienceSelect(ExperienceSelect experienceSelect) {
		log.debug("★★★★Hyun★★★★"+experienceSelect.toString());
		mainSelectMapper.updateExperienceSelect(experienceSelect);
	}
	
	// 메인 페이지 숙소 추천 수정
	public void modifyRoomSelect(RoomSelect roomSelect) {
		log.debug("★★★★Hyun★★★★"+roomSelect.toString());
		mainSelectMapper.updateRoomSelect(roomSelect);
	}
	
	// 메인 페이지 체험 추천 상세보기
	public ExperienceSelect getexperienceSelectOne(int experienceSelectId) {
		System.out.println(experienceSelectId + "<-- experienceSelectId");
		ExperienceSelect experienceSelect = mainSelectMapper.selectExperienceSelectOne(experienceSelectId);
		return experienceSelect;
	}
	
	// 메인 페이지 숙소 추천 상세보기
	public RoomSelect getroomSelectOne(int roomSelectId) {
		System.out.println(roomSelectId + "<-- roomSelectId");
		RoomSelect roomSelect = mainSelectMapper.selectRoomSelectOne(roomSelectId);
		return roomSelect;
	}
	
	// 메인 페이지 체험 추천 리스트
	public Map<String, Object> getSelectExperienceSelectList(String searchTitle, int currentPage, int ROW_PER_PAGE) {
		
		// 1) 매개변수 가공
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow); 
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("searchTitle", searchTitle);
		log.debug(searchTitle);
		
		// 메인 페이지 체험 추천 리스트
		List<ExperienceSelect> experienceSelectList = mainSelectMapper.selectExperienceList(paramMap);
		
		// 2) 리턴값 가공
		Map<String, Object> returnMap = new HashMap<>();
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		int totalCount = mainSelectMapper.selectExperienceTotalCount(searchTitle);
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
	
	// 메인 페이지 숙소 추천 리스트
	public Map<String, Object> getSelectRoomSelectList(String searchTitle, int currentPage, int ROW_PER_PAGE) {
		
		// 1) 매개변수 가공
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow); 
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("searchTitle", searchTitle);
		log.debug(searchTitle);
		
		// 여행작가 숙소 추천 리스트
		List<RoomSelect> roomSelectList = mainSelectMapper.selectRoomSelectList(paramMap);
		
		// 2) 리턴값 가공
		Map<String, Object> returnMap = new HashMap<>();
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		int totalCount = mainSelectMapper.selectRoomSelectTotalCount(searchTitle);
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		returnMap.put("roomSelectList", roomSelectList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
	
	public Map<String, Object> selectTheme() {
		Map<String, Object> map = new HashMap<>();
		List<ThemeMiddle> selectThemeList = mainSelectMapper.selectThemeList();
		map.put("selectThemeList", selectThemeList);
		return map;
		
	}
	
	public Map<String, Object> selectThemeSmall() {
		Map<String, Object> ThemeSmallmap = new HashMap<>();
		List<ThemeSmall> selectThemeSmallList = mainSelectMapper.selectThemeSmallList();
		ThemeSmallmap.put("selectThemeSmallList", selectThemeSmallList);
		return ThemeSmallmap;
	}
	
	public Map<String, Object> selectThemeShopExperienceList(String ThemeSmallName, String searchKeyword, String shopCategory, int currentPage, int ROW_PER_PAGE) {
		Map<String, Object> map = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		
		map.put("beginRow", beginRow); 
		map.put("ROW_PER_PAGE", ROW_PER_PAGE);
		map.put("searchKeyword", searchKeyword);
		map.put("ThemeSmallName", ThemeSmallName);
		
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+ThemeSmallName+"aaaaaaaaaaaaaaaaa");
		List<ThemeSmallExperience> selectThemeShopExperienceList = mainSelectMapper.selectThemeShopExperienceList(map);
		//System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx"+selectThemeShopExperienceList.toString()+"xxxxxxxxxxxxxxxxxxxxxxxx");
		
		Map<String, Object> returnMap = new HashMap<>();
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		int totalCount = mainSelectMapper.selectExperienceSelectTotalCount(map);
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		
		returnMap.put("selectThemeShopExperienceList", selectThemeShopExperienceList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
	
	public Map<String, Object> selectThemeShopHotelList(String ThemeSmallName, String searchKeyword, String shopCategory, int currentPage, int ROW_PER_PAGE) {
		Map<String, Object> map = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		
		map.put("beginRow", beginRow); 
		map.put("ROW_PER_PAGE", ROW_PER_PAGE);
		map.put("searchKeyword", searchKeyword);
		map.put("ThemeSmallName", ThemeSmallName);
		map.put("shopCategory", shopCategory);
		
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+ThemeSmallName+"aaaaaaaaaaaaaaaaa");
		List<ThemeSmallHotel> selectThemeShopHotelList = mainSelectMapper.selectThemeShopHotelList(map);
		//System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx"+selectThemeShopHotelList.toString()+"xxxxxxxxxxxxxxxxxxxxxxxx");
		
		Map<String, Object> returnMap = new HashMap<>();
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		int totalCount = mainSelectMapper.selectHotelSelectTotalCount(map);
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		
		returnMap.put("selectThemeShopHotelList", selectThemeShopHotelList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
	
}
