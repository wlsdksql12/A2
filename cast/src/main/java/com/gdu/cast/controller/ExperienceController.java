package com.gdu.cast.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.ExperienceService;
import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Experience;
import com.gdu.cast.vo.ExperienceSelect;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExperienceController {
   @Autowired
   ExperienceService experienceService;
   
   @GetMapping("/ceo/insertExp")
   public String insertExp(Model model, int addressId) {
      
      model.addAttribute("addressId" , addressId);
      
      return "/ceo/insertExp";
   }
   
   @PostMapping("/ceo/insertExp")
   public String insertExp(HttpSession session, Experience experience) {
      String ceoId = (String) session.getAttribute("loginCeoId");
      experience.setCeoId(ceoId);
      System.out.println(ceoId + " << ceoId");
      experienceService.insertExp(experience);
      
      log.debug("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+ceoId);
      log.debug("=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-"+experience.toString());
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
   
   // 체험 상세보기
   @GetMapping("/ceo/experienceOne")
   public String experienceOne(Model model, Address address, int experienceId) {
      Experience experience = experienceService.selectExperienceOne(experienceId);
      
      model.addAttribute("experience", experience);
      model.addAttribute("address", address);
      
      System.out.println(experience + " << Experience");
      System.out.println(address + " << Address");
      
      return "/ceo/experienceOne";
   }
   
   //체험 수정
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
}	