package com.spring.board.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring.board.common.Board;

@Repository
@Qualifier("mainBoardDAO")
public class BoardDAOImpl implements BoardDAO{

	@Autowired IBoardMapper bm;
	
	@Override
	public List<Board> getBoardList() {
		return bm.getBoardList();
	}

}
