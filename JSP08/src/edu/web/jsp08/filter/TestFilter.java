package edu.web.jsp08.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class TestFilter
 */
// @WebFilter(filterName = "testFilter", urlPatterns = {"/", "/main"})
public class TestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TestFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
    @Override
	public void destroy() {
		// WAS가 생성된 Filter 객체를 소멸시킬 때 호출하는 메서드.
    	System.out.println("testFilter.destroy() 호출");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		System.out.println("testFilter.doFilter() 호출");

		System.out.println(">>> testFilter: chain.doFilter() 호출 전");
		// 요청을 처리하는 servlet이 실행되기 전에 할 일들을 작성
		
		// 요청(request)을 필터 체인을 따라서 전달. -> 요청을 처리하는 servlet 메서드가 호출.
		chain.doFilter(request, response);
		
		// servlet 함수의 처리가 다 끝났을 때 할 일들을 작성
		System.out.println(">>> testFilter: chain.doFilter() 호출 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
    @Override
	public void init(FilterConfig fConfig) throws ServletException {
		// Filter 객체가 생성된 후 Filter 환경 설정 정보들을 읽거나 변경하기 위해서 호출되는 메서드.
    	// doFilter 메서드 호출 전에 실행됨.
    	System.out.println("testFilter.init() 호출");
	}

}