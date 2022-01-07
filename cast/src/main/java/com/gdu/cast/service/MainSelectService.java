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

import com.gdu.cast.mapper.MainSelectCommentMapper;
import com.gdu.cast.mapper.MainSelectMapper;
import com.gdu.cast.vo.AddRoomSelect;
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
	
	/*
	// 메인 페이지 숙소 추천 수정
	public void modifyRoomSelect(AddRoomSelect addRoomSelect) {
		
		// 데이터 추가
		String roomSelectTitle = addRoomSelect.getRoomSelectTitle();
		String roomSelectContent = addRoomSelect.getRoomSelectContent();
		
		// 1) 숙소 추천 입력
		RoomSelect roomSelect = new RoomSelect();		
		roomSelect.setRoomSelectTitle(roomSelectTitle);
		roomSelect.setRoomSelectContent(roomSelectContent);
		mainSelectMapper.updateRoomSelect(roomSelect);
		log.debug("★★★★Hyun★★★★"+roomSelect.toString());
		
		// 2) 숙소 추천 이미지 추가
		List<RoomSelectImage> roomSelectImage = null;
		if(addRoomSelect.getRoomSelectImage() != null) {
			roomSelectImage = new ArrayList<RoomSelectImage>();
			for(MultipartFile mf : addRoomSelect.getRoomSelectImage()) {
				RoomSelectImage rsi = new RoomSelectImage();
				rsi.setRoomSelectId(roomSelect.getRoomSelectId());
				String originName = mf.getOriginalFilename();
				int p = originName.lastIndexOf(".");
				String imageName = UUID.randomUUID().toString();
				String imageExt = originName.substring(p+1);
				rsi.setImageName(imageName);
				rsi.setImageExt(imageExt);
				rsi.setImageSize(mf.getSize());
				roomSelectImage.add(rsi);
				log.debug("★★★★Hyun★★★★"+roomSelectImage.toString());
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
		if(roomSelectImage != null) {
			for(RoomSelectImage rsi : roomSelectImage) {
				mainSelectMapper.updateRoomSelectImage(rsi);
			}
		}
	}
	*/
	
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
		mainSelectCommentMapper.ExperienceSelectDeletecomment(experienceSelect);
		mainSelectMapper.deleteExperienceSelectImage(experienceSelect);
		log.debug("★★★★Hyun★★★★"+experienceSelect.toString());
		
		return mainSelectMapper.deleteExperienceSelect(experienceSelect);
	}
	
	// 메인 페이지 숙소 추천 삭제
	public int removeRoomSelect(RoomSelect roomSelect) {
		mainSelectCommentMapper.roomSelectDeletecomment(roomSelect);
		mainSelectMapper.deleteRoomSelectImage(roomSelect);
		log.debug("★★★★Hyun★★★★"+roomSelect.toString());
		
		return mainSelectMapper.deleteRoomSelect(roomSelect);
	}
	
	// 메인 페이지 체험 추천 수정
	public void modifyExperienceSelect(ExperienceSelect experienceSelect) {
		mainSelectMapper.updateExperienceSelect(experienceSelect);
		log.debug("★★★★Hyun★★★★"+experienceSelect.toString());
	}
	
	// 메인 페이지 숙소 추천 수정
	public void modifyRoomSelect(RoomSelect roomSelect) {
		mainSelectMapper.updateRoomSelect(roomSelect);
		log.debug("★★★★Hyun★★★★"+roomSelect.toString());
	}

	// 메인 페이지 체험 추천 상세보기
	public ExperienceSelect getexperienceSelectOne(int experienceSelectId) {
		System.out.println("★★★★Hyun★★★★"+experienceSelectId);
		ExperienceSelect experienceSelect = mainSelectMapper.selectExperienceSelectOne(experienceSelectId);
		log.debug("★★★★Hyun★★★★"+experienceSelect.toString());
		
		return experienceSelect;
	}
	
	// 메인 페이지 숙소 추천 상세보기
	public RoomSelect getroomSelectOne(int roomSelectId) {
		System.out.println("★★★★Hyun★★★★"+roomSelectId);
		RoomSelect roomSelect = mainSelectMapper.selectRoomSelectOne(roomSelectId);
		log.debug("★★★★Hyun★★★★"+roomSelect.toString());
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
		log.debug("★★★★Hyun★★★★"+paramMap);
		
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
		log.debug("★★★★Hyun★★★★"+returnMap);
		
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
		log.debug("★★★★Hyun★★★★"+paramMap);
		
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
		log.debug("★★★★Hyun★★★★"+returnMap);
		
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
