package com.spring.board.persistence;

import java.util.List;

import com.spring.board.common.Board;

public interface BoardDAO{
	public List<Board> getBoardList();
}
