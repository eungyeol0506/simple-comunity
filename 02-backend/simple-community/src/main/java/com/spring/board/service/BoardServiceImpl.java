package com.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.board.common.Board;
import com.spring.board.persistence.BoardDAO;

@Service
@Qualifier("mainBoardService")
public class BoardServiceImpl implements BoardService{

	@Autowired	
	@Qualifier("mainBoardDAO") BoardDAO myboardDAO;
	
	@Transactional
	@Override
	public List<Board> getBoardList() {
		return myboardDAO.getBoardList();
	}
	@Transactional
	@Override
	public Board getBoardDetail(int no) {
		myboardDAO.increaseViews(no);
		return myboardDAO.getBoardByNo(no);
	}
	@Transactional
	@Override
	public Board getBoardDetail_withNoInc(int no) {
		return myboardDAO.getBoardByNo(no);
	}
	@Override
	public void addBoard(Board newboard) {
		myboardDAO.createBoard(newboard);
		
	}
	@Override
	public void modifyBoard(Board modifiedBoard) {
		myboardDAO.modifyBoard(modifiedBoard);
		
	}

	
}
