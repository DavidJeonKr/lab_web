package edu.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.Action;
import edu.web.domain.User;
import edu.web.service.UserService;
import edu.web.service.UserServiceImpl;

public class UserInsertController implements Action {
	UserService userService = UserServiceImpl.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String method = request.getMethod();
		if(method.equals("GET")) {
			return doGet(request, response);
		} else {
			return doPost(request, response);
		}
	}
	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/user/user-insert.jsp";
	}

	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		User user = new User(userid, pwd, email, 0);
		
		userService.registerNewUser(user);
		
		return REDIRECT_PREFIX + "main";
	}


}
