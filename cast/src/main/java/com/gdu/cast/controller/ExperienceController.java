package com.gdu.cast.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gdu.cast.service.ExperienceService;
import com.gdu.cast.service.KeywordService;
import com.gdu.cast.service.MainExperienceOrHotelReviewService;
import com.gdu.cast.service.MainSelectService;
import com.gdu.cast.vo.AddExperience;
import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Experience;
import com.gdu.cast.vo.ExperienceImage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExperienceController {
   @Autowired
   ExperienceService experienceService;
   @Autowired
   KeywordService keywordService;
   @Autowired
   MainSelectService mainSelectService;
   @Autowired MainExperienceOrHotelReviewService mainExperienceOrHotelReviewService;
   
   
   private final int row_per_page = 5;
   
   @GetMapping("/ceo/insertExp")
   public String insertExp(Model model, int addressId) {
      Map<String, Object> ThemeSmallmap = mainSelectService.selectThemeSmall();
      System.out.println(ThemeSmallmap.get("selectThemeSmallList")+ "tset");
      model.addAttribute("addressId" , addressId);
      model.addAttribute("selectThemeSmallList",ThemeSmallmap.get("selectThemeSmallList"));
      return "/ceo/insertExp";
   }
   
   @PostMapping("/ceo/insertExp")
   public String insertExp(HttpServletRequest request,HttpSession session, AddExperience addExperience, @RequestParam(defaultValue = "") String keyword, String theme) {
      String ceoId = (String) session.getAttribute("loginCeoId");
      addExperience.setCeoId(ceoId);
      System.out.println(ceoId + " << ceoId");
      
      int experienceId = experienceService.insertExp(addExperience);
      System.out.println(experienceId  + "체험 id");
      log.debug("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+ceoId);
      log.debug("=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-"+addExperience.toString());
      
      // 해시태그 키워드 입력을 안할시 실행이 안되도록
      if(!keyword.equals("")) {
         // 해시태그 결과값 불러오기
         System.out.println(keyword + "test");
          System.out.println(keyword.length() + "test");
          String[] keywordList = keyword.split(",");
          System.out.println(keywordList.length + "문자열 나누기");
          System.out.println(Arrays.toString(keywordList) + "문자열 나누기");
          for(int i = 0; i < keywordList.length; i++) {
             System.out.println(keywordList[i] + "입력되는 값");
             keywordService.insertExperienceKeyword(keywordList[i], experienceId);
          }  
      }
      // 테마 값 불러오기
      System.out.println(theme + "theme");
      experienceService.insertThemeExperience(experienceId, theme);
      // 나중에 체험리스트로 가게 바꾸기
      return "/ceo/ceoIndex";
   }
   
   @GetMapping("/ceo/insertExpAddress")
   public String insertAddress() {
      return "/ceo/insertExpAddress";
   }
   
   @PostMapping("/ceo/insertExpAddress")
   public String insertAddress(HttpSession session, Address address, Experience experience) {
      String ceoId = (String) session.getAttribute("loginCeoId");
      experience.setCeoId(ceoId);
      
      experienceService.insertExpAddress(address);
      
      return "redirect:/ceo/insertExp?addressId="+address.getAddressId() + "&ceoId=" + experience.getCeoId();
   }
   
   // 체험 리스트
   @GetMapping("/ceo/experienceList")
   public String experienceList(Model model, HttpSession session,
         @RequestParam(defaultValue = "1") int currentPage,
         @RequestParam(required = false) String searchTitle) {
         // required = true -> 값이 안넘어오면 에러, required = false -> 안넘어오면 null
      System.out.println(searchTitle);
      final int ROW_PER_PAGE = 10;
      Map<String, Object> map = experienceService.getExperienceList(currentPage, ROW_PER_PAGE, searchTitle);
      System.out.println(session);
      System.out.println(session.getAttribute("loginCeoId"));
      model.addAttribute("experienceList", map.get("experienceList"));
      model.addAttribute("startPage", map.get("startPage"));
      model.addAttribute("lastPage", map.get("lastPage"));
      model.addAttribute("totalPage", map.get("totalPage"));
      model.addAttribute("currentPage", currentPage);
      model.addAttribute("searchTitle", searchTitle);
      model.addAttribute("loginCeoId", session.getAttribute("loginCeoId"));
      System.out.println(session.getAttribute("loginCeoId") + " 체험리스트 세션값");
      return "/ceo/experienceList";
   }
   
   // 체험 상세보기(이미지 추가)
   @GetMapping("/ceo/experienceOne")
   public String experienceOne(Model model, Address address, int experienceId) {
      Experience experience = experienceService.selectExperienceOne(experienceId);
      List<ExperienceImage> experienceImageList = experienceService.getExperienceImage(experienceId);
      
      model.addAttribute("experience", experience);
      model.addAttribute("address", address);
      model.addAttribute("experienceImageList", experienceImageList);
      
      System.out.println(experience + " << Experience");
      System.out.println(address + " << Address");
      System.out.println(experienceImageList + "<<experienceImageList");
      
      return "/ceo/experienceOne";
   }
   
   // 체험 수정
   @GetMapping("/ceo/updateExperience")
   public String updateExperience(Model model, int experienceId) {
      Experience experience = experienceService.selectExperienceOne(experienceId);
      model.addAttribute("experience", experience);
      return "/ceo/updateExperience";
   }
   @PostMapping("/ceo/updateExperience")
   public String updateExperience(Experience experience) {
      experienceService.updateExperience(experience);
      log.debug("experience"+experience.toString());
      return "redirect:/experienceOne?experienceId="+experience.getExperienceId();
   }
   
   // 체험 삭제
   @GetMapping("/ceo/deleteExperience")
   public String deleteExperience(Model model, int experienceId, String ceoId) {
      Experience experience = experienceService.selectExperienceOne(experienceId);
      log.debug(ceoId);
      model.addAttribute("experience", experience);
      return "/ceo/deleteExperience";
   }   
   @PostMapping("/ceo/deleteExperience")
   public String deleteExperience(Experience experience) {
      experienceService.deleteExperience(experience);
      return "redirect:/ceo/experienceList";
   }
   
   // 메인 체험 상세보기
   @GetMapping("/mainExperienceOne")
   public String mainExperienceOne(Model model, Address address, int experienceId, @RequestParam(defaultValue = "1") int currentPage, HttpSession session, String experienceName) {
      String customerId = (String)session.getAttribute("loginCustomerId");
      Experience experience = experienceService.selectExperienceOne(experienceId);
      Map<String, Object> map = mainExperienceOrHotelReviewService.getexperiencePaymentReview(currentPage, row_per_page, experienceId);
      
      model.addAttribute("ExperiencePaymentReview", map.get("ExperiencePaymentReview"));
      
      System.out.println("map.get(\"ExperiencePaymentReview\")" + map.get("ExperiencePaymentReview"));
      
      model.addAttribute("experienceName", experienceName);
      model.addAttribute("customerId", customerId);
      model.addAttribute("startPage", map.get("startPage"));
      model.addAttribute("lastPage", map.get("lastPage"));
      model.addAttribute("totalPage", map.get("totalPage"));
      model.addAttribute("currentPage", currentPage);
      System.out.println(experienceName+"experienceName2323");
      model.addAttribute("experience", experience);
      model.addAttribute("address", address);
      
      System.out.println(experience + " << Experience");
      System.out.println(address + " << Address");
      
      return "/mainExperienceOne";
   }
   
   // 리뷰 추가화면
   @GetMapping("/addExperienceReview")
   public String addMainExperience(Model model, HttpSession session, int experienceId, String experienceName) {
      System.out.println(experienceName+"experienceName");
      String customerId = (String)session.getAttribute("loginCustomerId");
      int experiencePaymentId = mainExperienceOrHotelReviewService.getselectCustomerPaymentId(experienceName, customerId);
      model.addAttribute("experienceName", experienceName);

      model.addAttribute("customerId", customerId);
      model.addAttribute("experienceId", experienceId);
      model.addAttribute("experiencePaymentId", experiencePaymentId);
      return "addExperienceReview";
   }
   // 리뷰 추가(사진 포함)
   @PostMapping("/addExperienceReview")
   public String addMainExperience(String experienceName,List<MultipartFile> experiencepaymentReviewImageUpload ,HttpServletRequest request, String customerId, String experiencePaymentReviewContent, int experiencePaymentId, int experienceId) {
	  
	   
	   
	   String path = request.getSession().getServletContext().getRealPath("/");
	   
	  // 리뷰 추가
	  mainExperienceOrHotelReviewService.getinsertExperiencePaymentReview(experiencepaymentReviewImageUpload,path,experiencePaymentReviewContent, experiencePaymentId, experienceId);
      
      return "redirect:/mainExperienceOne?experienceId="+experienceId+"&experienceName="+experienceName;
      
   }
   
}   