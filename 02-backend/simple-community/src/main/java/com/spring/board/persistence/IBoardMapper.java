package com.spring.board.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.board.common.Board;

@Mapper
public interface IBoardMapper {
	
	//게시판리스트 수집---------------------------------------------------------------------------------------------------------
	@Select("select no,title,create_date,views,user_no from board order by create_date desc")
	@Results(value = {
			@Result(property="no", column="no"),
			@Result(property="title", column="title"),
			@Result(property="createDate", column="create_date"),
			@Result(property="views", column="views"),
			@Result(property="writer", column="user_no", one=@One(select="com.spring.user.persistence.IUserMapper.findByNo"))
	})
	List<Board> getBoardList();
	
	//게시판 수집------------------------------------------------------------------------------------------------------
	@Select("select * from board where no=#{no}")
	@Results(value= {
			@Result(property="no", column="no"),
			@Result(property="title", column="title"),
			@Result(property="contents", column="contents"),
			@Result(property="createDate", column="create_date"),
			@Result(property="updateDate", column="update_date"),
			@Result(property="deleteDate", column="delete_date"),
			@Result(property="views", column="views"),
			@Result(property="writer", column="user_no", one=@One(select="com.spring.user.persistence.IUserMapper.findByNo"))
	})
	Board getBoardByNo(int no);
	
	//조회수 증가 
	@Update("update board set views=views+1 where no=#{no}")
	void incViews(int no);
	
}
