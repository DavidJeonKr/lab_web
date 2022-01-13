package edu.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	String REDIRECT_PREFIX ="redirect:";
	String execute(HttpServletRequest request, HttpServletResponse response);
}
