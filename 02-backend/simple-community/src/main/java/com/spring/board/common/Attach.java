package com.spring.board.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Attach {
	int no;
	String fileName;
	long size;
	Board board;

}
