<%@page import="com.spring.board.common.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Board board = (Board) request.getAttribute("board");
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

	


	
	<div>
		<jsp:include page="/WEB-INF/views/main/footer.jsp"/>
	</div>
</body>
</html>