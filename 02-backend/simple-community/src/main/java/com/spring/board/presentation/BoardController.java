package com.spring.board.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.common.Board;
import com.spring.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	@Qualifier("mainBoardService")
	BoardService myboardService;
	
	@GetMapping("/simple_community")
	public ModelAndView printBoardList() {
		ModelAndView mv= new ModelAndView();
		
		mv.addObject("boards", myboardService.getBoardList());
		mv.setViewName("/board/BoardListView");
		
		return mv;
	}
	
	@GetMapping("/detail")
	public ModelAndView printBoard(@RequestParam("no") int no) {
		ModelAndView mv= new ModelAndView();
		
		Board board = myboardService.getBoardDetail(no);
		
		mv.addObject("board", board);
		mv.setViewName("/board/BoardDetailView");
		
		return mv;
	}
	
	@GetMapping("/wrtie")
	public String prepareAddBoard() {
		return "/board/BoardWrtieForm";
	}
	
	@PostMapping("/write")
	public ModelAndView addBoard(Board newboard) {
		ModelAndView mv= new ModelAndView();
		
		myboardService.addBoard(newboard);
		
		
		mv.setViewName("redirectView");
		return mv;
	}
}
