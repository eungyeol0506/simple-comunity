package com.spring.board.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import com.spring.board.common.Board;

@Mapper
public interface IBoardMapper {
	
	@Select("select no,title,create_date,views,user_no from board order by create_date desc")
	@Results(value = {
			@Result(property="no", column="no"),
			@Result(property="title", column="title"),
			@Result(property="createDate", column="create_date"),
			@Result(property="views", column="views"),
			@Result(property="writer", column="user_no", one=@One(select="com.spring.user.persistence.IUserMapper.findByNo"))
	})
	List<Board> getBoardList();
}
