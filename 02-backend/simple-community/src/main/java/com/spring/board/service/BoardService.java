package com.spring.board.service;

import java.util.List;

import com.spring.board.common.Board;

public interface BoardService {
	public List<Board> getBoardList();
	public Board getBoardDetail(int no);
	public Board getBoardDetail_withNoInc(int no);
	public void addBoard(Board newboard);
	public void modifyBoard(Board modifiedBoard);
	public void deleteBoard(int no);
}
