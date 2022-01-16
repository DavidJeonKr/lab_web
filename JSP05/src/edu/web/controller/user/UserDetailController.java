package edu.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.Action;
import edu.web.domain.User;
import edu.web.service.UserService;
import edu.web.service.UserServiceImpl;

public class UserDetailController implements Action {
	
	private UserService userService = UserServiceImpl.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		
		User user = userService.select(userid);
		
		request.setAttribute("user", user);
		
		return "/WEB-INF/user/user-detail.jsp";
	}

}
