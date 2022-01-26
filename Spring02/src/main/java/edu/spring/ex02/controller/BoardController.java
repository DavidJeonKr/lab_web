package edu.spring.ex02.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.ex02.domain.Board;
import edu.spring.ex02.service.BoardService;

@Controller // DispatcherServlet에 의해서 컴포넌트 객체로 생성되고 관리됨.
@RequestMapping(value = "/board")
public class BoardController {
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	// Service 계층의 객체들을 주입(injection)받아서 사용.
	@Autowired private BoardService boardService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void main(Model model) {
		log.info("main() 호출");
		
		// 서비스 객체의 메서드를 사용해서 글 전체 목록을 가져옴.
		List<Board> list = boardService.select();
		// 글 전체 목록을 Model 객체에 속성으로 추가해서 View(JSP)까지 전달
		model.addAttribute("boardList", list);
		
		// controller 메서드가 리턴하는 문자열이 없으면 요청 주소로 View(jsp 파일)을 찾음.
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert() {
		log.info("insert() 호출");
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(Board board) {
		log.info("insert({}) POST 호출", board);
		// 클라이언트에서 보낸 데이터들을 서비스 계층의 객체 (메서드)를 사용해서 새 글 작성
		// 게시판 메인 페이지로 이동한다(redirect)
		boardService.insert(board);
		return "redirect:/board/main";
	}
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public void detail(int bno, Model model) {
		log.info("detail(bno={}) GET 호출", bno);
		
		//TODO: 서비스 계층의 객체 (메서드)를 사용해서 해당 글 번호를 검색하고 
		Board board =boardService.select(bno);
		// 검색된 내용을 View(JSP)에게 전달.
		model.addAttribute("board", board);
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void update(int bno, Model model) {
		log.info("update(bno={})", bno);
		
		Board board = boardService.select(bno);
		model.addAttribute("board", board);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Board board) {
		log.info("update({}) POST 호출", board);
		boardService.update(board);
		
		return "redirect:/board/main";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(int bno) {
		
		boardService.delete(bno);
		
		return "redirect:/board/main";
	}
	
	
}