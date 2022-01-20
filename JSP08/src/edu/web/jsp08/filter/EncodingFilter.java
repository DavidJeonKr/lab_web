package edu.web.jsp08.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String encoding;
	
    /**
     * Default constructor. 
     */
    public EncodingFilter() {}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		// 모든 요청의 인코딩 타입을 (UTF-8로) 세팅.
		request.setCharacterEncoding(encoding);

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// web.xml에서 설정된 <init-param>의 <param-name>에 설정된 <param-value> 값을 읽어옴.
		encoding = fConfig.getInitParameter("encoding");
	}

}