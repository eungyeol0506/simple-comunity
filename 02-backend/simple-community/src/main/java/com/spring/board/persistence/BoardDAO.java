package com.spring.board.persistence;

import java.util.List;

import com.spring.board.common.Board;

public interface BoardDAO{
	public List<Board> getBoardList();
	public Board getBoardByNo(int no);
	public void increaseViews(int no);
}
