package com.spring.board.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.board.common.Board;

@Repository
@Qualifier("mainBoardDAO")
public class BoardDAOImpl implements BoardDAO{

	@Autowired IBoardMapper bm;
	
	@Transactional
	@Override
	public List<Board> getBoardList() {
		return bm.getBoardList();
	}
	@Transactional
	@Override
	public Board getBoardByNo(int no) {
		return bm.getBoardByNo(no);
	}
	
	@Transactional
	@Override
	public void increaseViews(int no) {
		bm.incViews(no);
		
	}
	@Transactional
	@Override
	public void createBoard(Board newboard) {
		bm.createBoard(newboard);
	}
	
	@Transactional
	@Override
	public void updateBoard(Board modifiedBoard) {
		bm.updateBoard(modifiedBoard);
	}
	
	
	@Transactional
	@Override
	public void deleteBoard(int no) {
		bm.deleteBoard(no);
	}

}
