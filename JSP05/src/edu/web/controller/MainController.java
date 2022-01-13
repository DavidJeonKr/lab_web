package edu.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("mainContoller.execute() 메서드 호출");
		
		return "WEB-INF/index.jsp";
	}

}
