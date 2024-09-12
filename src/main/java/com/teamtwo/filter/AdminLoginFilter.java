package com.teamtwo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.teamtwo.model.AdminDTO;

@WebFilter("/*")
public class AdminLoginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException{}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		
		String path = ((HttpServletRequest) request).getRequestURI();
				
		if(path.equals("/") || path.equals("/WEB-JSP/admin")) {
			HttpSession session = ((HttpServletRequest) request).getSession();
			
			AdminDTO admin = (AdminDTO)session.getAttribute("admins");
			
			if(admin == null) {
			
			request.getRequestDispatcher("adminlogin.do").forward(request, response);
			
			} else {
				chain.doFilter(request, response);
			}
			
		} else {
			chain.doFilter(request, response);
		}
		
	}
	
}
