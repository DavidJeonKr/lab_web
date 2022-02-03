package edu.spring.ex02.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;

import edu.spring.ex02.domain.User;

// signin POST 방식의 컨트롤러 메서드가 리턴 후 
// 로그인 성공이면 가고자 했었던 url로 이동
// 로그인 실패이면 다시 signin GET 요청으로 redirect

public class SignedInInterceptor implements HandlerInterceptor {
	private static final Logger log = LoggerFactory.getLogger(SignedInInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("<<<<< postHandle() 호출");
		
		if (request.getMethod().equals("GET")) {
			return;  // GET 방식에서는 interceptor가 할 일이 없음.(로그인 페이지 form을 보여줌.)
		}
		
		// 로그인 성공 후 이동할 페이지(input type="hidden"에서 찾음)
		String targetUrl = request.getParameter("url");
		
		Object user = modelAndView.getModel().get("signInUser");
		if (user != null) { // 테이블에 아이디/비밀번호가 일치하는 사용자가 있는 경우 -> 로그인 성공
			// 세션에 로그인 사용자 아이디를 저장
			HttpSession session = request.getSession();
			session.setAttribute("signInUserId", ((User) user).getUserid());
			
			// 원래 이동하려고 했던 페이지(targetUrl)로 redirect
			if (targetUrl != null && !targetUrl.equals("")) {
				response.sendRedirect(targetUrl);
			} else {
				response.sendRedirect("/ex02");
			}
			
		} else { // 테이블에 아이디/비밀번호가 일치하는 사용자가 없는 경우 -> 로그인 실패
			// 로그인 페이지(signin GET)로 redirect
			response.sendRedirect("/ex02/user/signin?url=" + UriUtils.encode(targetUrl, "UTF-8"));
		}
		
	}
}