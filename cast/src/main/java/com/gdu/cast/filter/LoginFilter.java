package com.gdu.cast.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/blank/*")
public class LoginFilter extends HttpFilter implements Filter {
   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		
	   HttpSession session = ((HttpServletRequest)request).getSession();
	   
	   if(session.getAttribute("loginAdminId") == null) {
			System.out.println("강제이동");
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/loginSelect");
			return;
		}
	   else if(session.getAttribute("loginCustomerId") == null) {
			System.out.println("강제이동");
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/loginSelect");
			return;
		}
	   else if(session.getAttribute("loginCeoId") == null) {
			System.out.println("강제이동");
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/loginSelect");
			return;
		}
	   else if(session.getAttribute("loginTravelerId") == null) {
			System.out.println("강제이동");
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/loginSelect");
			return;
		} else {
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/loginSelect");
		}
	   
	super.doFilter(request, response, chain);
}
}
