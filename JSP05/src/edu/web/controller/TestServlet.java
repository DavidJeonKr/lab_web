package edu.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.domain.Board;
import edu.web.persistence.BoardDao;
import edu.web.persistence.BoardDaoImpl;

@WebServlet(name = "testServlet", urlPatterns = { "/testServlet" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet() {super();}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao dao = BoardDaoImpl.getInstance();
		List<Board> list = dao.read();
		for(Board b : list) {
			System.out.println(b.getBno() + ", " + b.getTitle());
		}
	}


}
