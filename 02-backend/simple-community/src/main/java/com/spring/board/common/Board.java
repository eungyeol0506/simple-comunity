package com.spring.board.common;

import java.util.Date;

import com.spring.user.common.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
	int no;
	String title;
	String contents;
	Date createDate;
	Date updateDate;
	Date deleteDate;
	int views;
	User writer;

}
