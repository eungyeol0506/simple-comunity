<%@page import="com.spring.board.common.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	List<Board> boards = (List<Board>) request.getAttribute("boards");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple-Community</title>
</head>
<body>
	<ul>
	<%for(Board board:boards){
	%>
	<li><a href="/detail?no=<%=board.getNo()%>"> <%=board.getTitle()%> </a> 
	    <%=board.getViews()%> 
	    <%=board.getCreateDate().toString() %>
	    <%=board.getWriter().getId()%> 
	</li>
	<%	
	} 
	%>
	</ul>
</body>
</html>