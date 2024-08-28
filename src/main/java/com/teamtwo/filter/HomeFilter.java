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

@WebFilter("/*")
public class HomeFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String path = ((HttpServletRequest) request).getRequestURI();

		if (path.equals("/") || path.equals("/WEB-JSP/")) {
			// 루트 경로인 경우 서블릿으로 포워드
			request.getRequestDispatcher("mainView.do").forward(request, response);
		} else {
			// 나머지 요청은 필터 체인을 통해 계속 처리
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {}
}