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

import com.gdu.cast.mapper.RoomSelectMapper;
import com.gdu.cast.vo.AddRoomSelect;
import com.gdu.cast.vo.RoomSelect;
import com.gdu.cast.vo.RoomSelectImage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class RoomSelectService {
	
	@Autowired
	RoomSelectMapper roomSelectMapper;
	
	// 여행작가 숙소 추천 추가
	public void addRoomSelect(AddRoomSelect addRoomSelect) {
		
		// 데이터 추가
		String travelerId = addRoomSelect.getTravelerId();
		int hotelId = addRoomSelect.getHotelId();
		String roomSelectTitle = addRoomSelect.getRoomSelectTitle();
		String roomSelectContent = addRoomSelect.getRoomSelectContent();
		String createDate = addRoomSelect.getCreateDate();
		String updateDate = addRoomSelect.getUpdateDate();
		
		// 1) 숙소 추천 입력
		RoomSelect roomSelect = new RoomSelect();		
		roomSelect.setTravelerId(travelerId);
		roomSelect.setHotelId(hotelId);
		roomSelect.setRoomSelectTitle(roomSelectTitle);
		roomSelect.setRoomSelectContent(roomSelectContent);
		roomSelect.setCreateDate(createDate);
		roomSelect.setUpdateDate(updateDate);
		roomSelectMapper.insertRoomSelect(roomSelect);
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
				rsi.setCreateDate(createDate);
				rsi.setUpdateDate(updateDate);
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
				roomSelectMapper.insertRoomSelectImage(rsi);
			}
		}
	}
	
	// 자신이 등록한 숙소 추천 리스트 출력
	public Map<String, Object> getSelectRoomSelectList(String travelerId, int currentPage, int ROW_PER_PAGE) {
		
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
		
		// 여행작가 숙소 추천 리스트
		List<RoomSelect> roomSelectList = roomSelectMapper.selectRoomSelectList(paramMap);
		log.debug("★★★★Hyun★★★★"+roomSelectList.toString());
		
		// 2) 리턴값 가공
		Map<String, Object> returnMap = new HashMap<>();
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		int totalCount = roomSelectMapper.selectRoomSelectTotalCount(travelerId);
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
		log.debug("★★★★Hyun★★★★"+returnMap.toString());
		
		return returnMap;
	}
}
