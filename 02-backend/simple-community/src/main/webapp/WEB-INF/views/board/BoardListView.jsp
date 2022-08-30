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
<title>simple-cummunity</title>
<!-- //bootstrap -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<div>
		<jsp:include page="/WEB-INF/views/main/navbar.jsp"/>
	</div>
	<div class="container-fluid" style="height:auto">
		<div class="h-100 row">
			<div class="col-sm-3 p-3 bg-dark">
			</div>
			<div class="col-sm-8 align-middle">
			 <table class="table table-hover">
			    <thead>
			      <tr>
			        <th>제목</th>
			        <th>조회수</th>
			        <th>작성일</th>
			        <th>작성자</th>
			      </tr>
			    </thead>
			    
				<tbody>
				<%for(Board board : boards){
				%>
				  <tr>
				    <td><a href="/detail?no=<%=board.getNo()%>"> <%=board.getTitle()%> </a> </td>
				    <td><%=board.getViews()%> </td>
				    <td><%=board.getCreateDate().toString() %></td>
				    <td><%=board.getWriter().getId()%></td>
				  </tr>
				<%	
				}
				for(int i = 10-boards.size(); i<=10; i++){
					//10은 페이징할 게시글 수;
				%>
				<tr><td>&nbsp;</td><td> </td><td> </td><td> </td></tr>
				<%
				}
				%>
				</tbody>
			 </table>
			</div>
		</div>	
	</div>
	<div>
		<jsp:include page="/WEB-INF/views/main/footer.jsp"/>
	</div>
</body>
</html>