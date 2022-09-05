package com.spring.board.common;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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

//	List<MultipartFile> attachFiles;
//	List<Attach> attaches;
}
