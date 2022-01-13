package edu.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.Action;

public class UserMainController implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return "/WEB-INF/user/user-main.jsp";
		
	}

}
