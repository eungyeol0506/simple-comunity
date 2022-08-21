package com.spring.user.persistence;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import com.spring.user.common.User;

@Mapper
public interface IUserMapper {
	
	@Select("select * from user where no=#{no}")
	@Results(value = {
			@Result(property="no" , column="no"),
			@Result(property="id" , column="id"),
			@Result(property="password" , column="password"),
			@Result(property="email" , column="email"),
			@Result(property="registDate" , column="regist_date"),
			@Result(property="updateDate" , column="update_date"),
			@Result(property="deleteDate" , column="delete_date"),
	})
	public User findByNo(int no);
}
