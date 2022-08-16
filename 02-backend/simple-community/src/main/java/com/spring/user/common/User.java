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
	Date registDate;
	String email;
	
}
