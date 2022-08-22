package com.spring.board.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	@Qualifier("mainBoardService")
	BoardService myboardService;
	
	@GetMapping("/simple_community")
	public String printMain() {
		return "/main/list";
	}
	
	@GetMapping("/list")
	public ModelAndView printBoardList() {
		ModelAndView mv= new ModelAndView();
		
		mv.addObject("boards", myboardService.getBoardList());
		mv.setViewName("/board/BoardListView");
		
		return mv;
	}
}
