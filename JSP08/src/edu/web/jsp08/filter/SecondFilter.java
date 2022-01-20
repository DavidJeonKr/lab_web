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
 * Servlet Filter implementation class SecondFilter
 */
public class SecondFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SecondFilter() {}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("secondFilter.destroy() 호출");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		System.out.println("secondFilter.doFilter() 호출");
		
		System.out.println(">>> secondFilter: chain.doFilter() 호출 전");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		System.out.println(">>> secondFilter: chain.doFilter() 호출 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("secondFilter.init() 호출");
	}

}