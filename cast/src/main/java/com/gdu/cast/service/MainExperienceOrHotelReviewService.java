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

import com.gdu.cast.mapper.MainExperienceOrHotelReviewMapper;
import com.gdu.cast.vo.ExperiencePaymentReview;
import com.gdu.cast.vo.ExperiencePaymentReviewImage;
import com.gdu.cast.vo.ExperienceSelectImage;
import com.gdu.cast.vo.NoticeImage;
import com.gdu.cast.vo.RoomPaymentReview;

@Transactional
@Service
public class MainExperienceOrHotelReviewService {
	@Autowired MainExperienceOrHotelReviewMapper mainExperienceOrHotelReviewMapper;
	// 메인 체험 리스트 후기 리스트 출력.
	public Map<String, Object> getexperiencePaymentReview(int currentPage, int row_per_page,int experienceId){
		System.out.println( currentPage  +"currentPage"); 
		System.out.println( row_per_page  +"row_per_page");   
		System.out.println( experienceId  +"experienceId");   
		
		
		
		Map<String, Object> paramMap = new HashMap<>();
			
		   int beginRow = 0;
			int displayPage = 10;
			int startPage = 0;
			int lastPage = 0;
		   beginRow = (currentPage-1)*row_per_page;
		   paramMap.put("beginRow", beginRow); 
		   paramMap.put("ROW_PER_PAGE", row_per_page);
		   paramMap.put("experienceId", experienceId);
		   List<ExperiencePaymentReview> ExperiencePaymentReview = mainExperienceOrHotelReviewMapper.experiencePaymentReview(paramMap);
		   System.out.println(ExperiencePaymentReview.toString() + "ExperienceReviewList");
		   
		   startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		   
		   
		   
		   int totalCount = mainExperienceOrHotelReviewMapper.selectExperienceReviewTotalCount();
			System.out.println(totalCount + " <---selectCommentTotalCount");
			lastPage = startPage + displayPage - 1;
			int totalPage = totalCount / row_per_page;
			if(totalCount % row_per_page != 0) {
				totalPage += 1;
			}
			if(lastPage > totalPage) {
				lastPage = totalPage;
			}
			
			// 리턴값
			Map<String, Object> returnMap = new HashMap<>();
			returnMap.put("ExperiencePaymentReview", ExperiencePaymentReview);
			returnMap.put("startPage", startPage);
			returnMap.put("lastPage", lastPage);
			returnMap.put("totalPage", totalPage);
			
			return returnMap;
	}
	
	// 메인 호텔 리스트 후기 리스트 출력.
	public Map<String, Object> getroomPaymentReview(int currentPage, int row_per_page,int hotelId){
		System.out.println( currentPage  +"currentPage"); 
		System.out.println( row_per_page  +"row_per_page");   
		System.out.println( hotelId  +"hotelId");   
		
		
		
		Map<String, Object> paramMap = new HashMap<>();
			
		   int beginRow = 0;
			int displayPage = 10;
			int startPage = 0;
			int lastPage = 0;
		   beginRow = (currentPage-1)*row_per_page;
		   paramMap.put("beginRow", beginRow); 
		   paramMap.put("ROW_PER_PAGE", row_per_page);
		   paramMap.put("hotelId", hotelId);
		   List<RoomPaymentReview> RoomPaymentReview = mainExperienceOrHotelReviewMapper.roomPaymentReview(paramMap);
		   System.out.println(RoomPaymentReview.toString() + "RoomPaymentReviewList");
		   
		   startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		   
		   
		   
		   int totalCount = mainExperienceOrHotelReviewMapper.selectRoomReviewTotalCount();
			System.out.println(totalCount + " <---selectCommentTotalCount");
			lastPage = startPage + displayPage - 1;
			int totalPage = totalCount / row_per_page;
			if(totalCount % row_per_page != 0) {
				totalPage += 1;
			}
			if(lastPage > totalPage) {
				lastPage = totalPage;
			}
			
			// 리턴값
			Map<String, Object> returnMap = new HashMap<>();
			returnMap.put("RoomPaymentReview", RoomPaymentReview);
			returnMap.put("startPage", startPage);
			returnMap.put("lastPage", lastPage);
			returnMap.put("totalPage", totalPage);
			
			return returnMap;
	}
	
	
	
	
	
	// 체험결제 아이디 매개변수
	public int getselectCustomerPaymentId(String experienceName, String customerId) {
		return mainExperienceOrHotelReviewMapper.selectCustomerPaymentId(experienceName,customerId);
		
	}

	//체험 리뷰 내용 추가
	public void getinsertExperiencePaymentReview(List<MultipartFile> experiencepaymentReviewImageUpload,String path, String experiencePaymentReviewContent, int experiencePaymentId, int experienceId) {
		ExperiencePaymentReview experiencePaymentReview = new ExperiencePaymentReview();
		experiencePaymentReview.setExperiencePaymentReviewContent(experiencePaymentReviewContent);
		experiencePaymentReview.setExperiencePaymentId(experiencePaymentId);
		experiencePaymentReview.setExperienceId(experienceId);
		experiencePaymentReview.setExperiencepaymentReviewImageUpload(experiencepaymentReviewImageUpload);
		// 1) 리뷰 추가
		mainExperienceOrHotelReviewMapper.insertExperiencePaymentReview(experiencePaymentReview);
		
		// 이미지 테이블에 값 전송 . experiencePaymentReviewId
		int experiencePaymentReviewId = experiencePaymentReview.getExperiencePaymentReviewId();
		System.out.println(experiencePaymentReviewId + "experiencePaymentReviewId");
		
		// 2) 리뷰 사진 추가
		List<ExperiencePaymentReviewImage> experiencePaymentReviewImage = null;
		if(experiencePaymentReview.getExperiencepaymentReviewImageUpload() != null) {
			System.out.println(experiencePaymentReview.getExperiencepaymentReviewImageUpload() + " 실행됨");
			// 이미지 저장할 리스트 선언. (사진이 여러개 들어갈 수 있도록 리스트를 사용함.)
			experiencePaymentReviewImage = new ArrayList<ExperiencePaymentReviewImage>();
			for(MultipartFile mf : experiencePaymentReview.getExperiencepaymentReviewImageUpload()) {
				
				ExperiencePaymentReviewImage rsi = new ExperiencePaymentReviewImage();
				// 테이블에 insert 하기위한 paymentId 키값(리뷰)
				rsi.setExperiencePaymentReviewId(experiencePaymentReviewId);
				// 사진 규격 . 별로 나눔.(속성별로)
				String originName = mf.getOriginalFilename();
				int p = originName.lastIndexOf(".");
				String imageName = UUID.randomUUID().toString();
				String imageExt = originName.substring(p+1);
				// 속성별로 나눈 규격에 값 저장.
				rsi.setImageName(imageName);
				rsi.setImageExt(imageExt);
				rsi.setImageSize(mf.getSize());
				rsi.setCreateDate(experiencePaymentReview.getCreateDate());
				rsi.setUpdateDate(experiencePaymentReview.getUpdateDate());
				// 리스트에 저장한 값 저장. (여러개의 사진을 담기위해 리스트를 사용해야 함.)
				experiencePaymentReviewImage.add(rsi);
				
				System.out.println(experiencePaymentReviewImage.toString() +"<<< experiencePaymentReviewImage.toString()");
				try {
					mf.transferTo(new File(path+"upload\\"+imageName+"."+imageExt));
				} catch(Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			}
		}
		
		if(experiencePaymentReviewImage != null) {
			for(ExperiencePaymentReviewImage rsi : experiencePaymentReviewImage) {
				mainExperienceOrHotelReviewMapper.insertExperiencePaymentReviewImage(rsi);
	
			}

		}
			
	}	
	
	
	// 체험 후기 삭제
	public void getdeleteExperiencePaymentReviewId(int experiencePaymentReviewId) {
		mainExperienceOrHotelReviewMapper.deleteExperienceReview(experiencePaymentReviewId);
	}
	
	/*
	// 호텔 리뷰 내용 추가
	public void getinsertRoomPaymentReview(List<MultipartFile> roomPaymentReviewImageUpload,String path, String roomPaymentReviewContent, int roomPaymentId, int hotelId) {
		RoomPaymentReview roomPaymentReview = new RoomPaymentReview();
		roomPaymentReview.setRoomPaymentReviewContent(roomPaymentReviewContent);
		roomPaymentReview.setRoomPaymentId(roomPaymentId);
		roomPaymentReview.setHotelId(hotelId);
		roomPaymentReview.setRoomPaymentReviewImageUpload(roomPaymentReviewImageUpload);
		// 1) 리뷰 추가
		mainExperienceOrHotelReviewMapper.
		
		// 이미지 테이블에 값 전송 . experiencePaymentReviewId
		int experiencePaymentReviewId = experiencePaymentReview.getExperiencePaymentReviewId();
		System.out.println(experiencePaymentReviewId + "experiencePaymentReviewId");
		
		// 2) 리뷰 사진 추가
		List<ExperiencePaymentReviewImage> experiencePaymentReviewImage = null;
		if(experiencePaymentReview.getExperiencepaymentReviewImageUpload() != null) {
			System.out.println(experiencePaymentReview.getExperiencepaymentReviewImageUpload() + " 실행됨");
			// 이미지 저장할 리스트 선언. (사진이 여러개 들어갈 수 있도록 리스트를 사용함.)
			experiencePaymentReviewImage = new ArrayList<ExperiencePaymentReviewImage>();
			for(MultipartFile mf : experiencePaymentReview.getExperiencepaymentReviewImageUpload()) {
				
				ExperiencePaymentReviewImage rsi = new ExperiencePaymentReviewImage();
				// 테이블에 insert 하기위한 paymentId 키값(리뷰)
				rsi.setExperiencePaymentReviewId(experiencePaymentReviewId);
				// 사진 규격 . 별로 나눔.(속성별로)
				String originName = mf.getOriginalFilename();
				int p = originName.lastIndexOf(".");
				String imageName = UUID.randomUUID().toString();
				String imageExt = originName.substring(p+1);
				// 속성별로 나눈 규격에 값 저장.
				rsi.setImageName(imageName);
				rsi.setImageExt(imageExt);
				rsi.setImageSize(mf.getSize());
				rsi.setCreateDate(experiencePaymentReview.getCreateDate());
				rsi.setUpdateDate(experiencePaymentReview.getUpdateDate());
				// 리스트에 저장한 값 저장. (여러개의 사진을 담기위해 리스트를 사용해야 함.)
				experiencePaymentReviewImage.add(rsi);
				
				System.out.println(experiencePaymentReviewImage.toString() +"<<< experiencePaymentReviewImage.toString()");
				try {
					mf.transferTo(new File(path+"upload\\"+imageName+"."+imageExt));
				} catch(Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			}
		}
		
		if(experiencePaymentReviewImage != null) {
			for(ExperiencePaymentReviewImage rsi : experiencePaymentReviewImage) {
				mainExperienceOrHotelReviewMapper.insertExperiencePaymentReviewImage(rsi);
	
			}

		}
			
	}	
		*/
}
