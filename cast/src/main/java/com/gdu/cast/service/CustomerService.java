package com.gdu.cast.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.AdminQnaMapper;
import com.gdu.cast.mapper.CustomerMapper;
import com.gdu.cast.vo.Customer;
import com.gdu.cast.vo.Customer_Login;
import com.gdu.cast.vo.Delete_Id;
import com.gdu.cast.vo.Qna;
import com.gdu.cast.vo.QnaComment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class CustomerService {
	@Autowired CustomerMapper customerMapper;
	@Autowired AdminQnaMapper adminQnaMapper;
	//고객 회원가입
	public void getaddCustomer(Customer customer) {
		String customerId = customer.getCustomerId();
		String customerName = customer.getCustomerName();
		String customerJumin = customer.getCustomerJumin();
		String customerEmail = customer.getCustomerEmail();
		String customerPw = customer.getCustomerPw();
		String customerPhoneNum = customer.getCustomerPhoneNum();
		String customerActive = customer.getActive();
		
		customer.setCustomerId(customerId);
		customer.setCustomerName(customerName);
		customer.setCustomerJumin(customerJumin);
		customer.setCustomerEmail(customerEmail);
		customer.setCustomerPw(customerPw);
		customer.setCustomerPhoneNum(customerPhoneNum);
		customer.setActive(customerActive);
	    
		customerMapper.insertCustomer(customer);
		log.debug(customer.toString());

	}
	
	 //고객 로그인
	   public Customer getselectCustomer(Customer customer) {
	      String customerId = customer.getCustomerId();
	      String customerPw = customer.getCustomerPw();
	      customer.setCustomerId(customerId);
	      customer.setCustomerPw(customerPw);
	      return customerMapper.selectCustomer(customer);
	   }
	   
	   // 고객이 쓴 qna select
	   public Map<String, Object> getselectQna(String customerId, int currentPage, int ROW_PER_PAGE) {
		   Map<String, Object> paramMap = new HashMap<>();
		   
		   int beginRow = (currentPage-1)*ROW_PER_PAGE;
		   paramMap.put("customerId", customerId);
		   paramMap.put("beginRow", beginRow); 
		   paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		
		   List<Qna> qnaList = customerMapper.selectQnaList(paramMap);
		   
			Map<String, Object> returnMap = new HashMap<>();
			int lastPage = 0;
			int totalCount = customerMapper.selectQnaTotalCount(customerId);
			lastPage = totalCount / ROW_PER_PAGE;
			if(totalCount%ROW_PER_PAGE != 0) {
				lastPage += 1;
			}
			returnMap.put("qnaList", qnaList);
			returnMap.put("lastPage", lastPage);
			return returnMap;
	   }
	   
	   //qnaOne
	   public Qna getSelectQnaOne(int qnaId){
 
		return customerMapper.selectQnaOne(qnaId);
		   
	   }
	   
	   //Qna상세보기 -> 수정
	   public int getupdateQnaOne(Qna qna) {
		   System.out.println(qna+"!@#!@#qna!Q@#!@#");
		   /*
		   qna.setQnaId(qna.getQnaId());
		   qna.setQnaCategory(qna.getQnaCategory());
		   qna.setQnaContent(qna.getQnaCategory());
		   qna.setQnaTitle(qna.getQnaTitle());
		   */
		return customerMapper.updateQna(qna);
		   
	   }
	   // qna 삭제
	   public int deleteQnaOne(Qna qna) {
		   adminQnaMapper.deleteQnaComment(qna);
		   return customerMapper.deleteQnaOne(qna);
	   }
	   
	   //내정보
	   public Customer getselectInfo(String customerId) {
		   return customerMapper.selectInfo(customerId);
	   }
	   
	   //내정보 수정
	   public int getupdateInfo(Customer customer) {
		   return customerMapper.updateInfo(customer);
	   }
	   
	   // 활성화 비활성화
	   public Customer getSelectActive(String customerId) {
		   System.out.println(customerMapper.selectActive(customerId) + "customerMapper.selectActive(customerId)");
		   return customerMapper.selectActive(customerId);
	   }
	   
	   //로그인 기록 엽데이트
	   public int getupdateDate(String customerId) {
		   return customerMapper.updateDate(customerId);
	   }
	   
	   //로그인 기록 생성
	   
	   public int getinsertCustomerLogin(String customerId) {
		   return customerMapper.insertCustomerLogin(customerId);
	   }
	   
	   // 로그인 기록 출력
	   public Customer_Login getselectCustomerLogin(Customer_Login customer_Login) {
		   return customerMapper.selectCustomerLogin(customer_Login);
	   }
	   
	   // 비활성화 상태 적용
	   public int getupdateActiveZeroDate(String customerId) {
		   return customerMapper.updateActiveZeroDate(customerId);
	   }

	   public int getselectDeleteId(String customerId) {
		   System.out.println(customerMapper.selectDeleteId(customerId) + "customerMapper.selectDeleteId()");
		   int result = customerMapper.selectDeleteId(customerId);
		   return result;
	   }
}
