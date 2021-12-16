package com.gdu.cast.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class CustomerLoginiFilter
 */
@WebFilter("/customer/*")
public class CustomerLoginiFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		
		// 실행전
		// 이미 관리자로 로그인 되어있다면 요청 처리 불가
		System.out.println("CustomerLoginFilter 실행");
		HttpSession session = ((HttpServletRequest)request).getSession();
		System.out.println(session.getAttribute("loginCustomerId") + " session확인");
		// 관리자 로그인시 loginAdminId가 세션에 생기므로 loginAdminId가 없으면 관리자만 허용하는 사이트에 접속이 안되도록하는 필터
		if(session.getAttribute("loginCustomerId") == null) {
			System.out.println("강제이동");
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/CustmoerLogin");
			return;
		}
		
		chain.doFilter(request, response);
	}



}
