package com.spring.user.common;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	int no;
	String id;
	String password;
	String email;
	Date registDate;
	Date updateDate;
	Date deleteDate;
}
