package com.spring.board.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
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
	
	//조회수 증가--------------------------------------------------------------------------------------------------------------
	@Update("update board set views=views+1 where no=#{no}")
	void incViews(int no);
	
	//게시판 작성--------------------------------------------------------------------------------------------------------------
	@Insert("insert into `simple-community`.`board`(`title`,`contents`,`user_no`) values(#{title},#{contents},#{user_no})")
	@SelectKey(statement="select last_insert_id()", keyProperty="no", before=false, resultType=int.class)
	void createBoard(Board newboard);
	
	//게시판 수정
	@Update("update `simple-community`.`board` set title=#{title}, contents=#{contents}, update_date=#{updateDate} where no=#{no}")
	void updateBoard(Board board);
	
	//게시판 삭제
	@Update("update `simple-community`.`board` set delete_date=#{deleteDate} where no=#{no}")
	void deleteBoard(int no);
}
