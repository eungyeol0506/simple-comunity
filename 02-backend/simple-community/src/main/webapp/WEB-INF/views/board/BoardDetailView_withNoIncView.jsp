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

	<div class="container-fluid" style="height:auto" id="detailBoard">
		<div class="row">
			<div class="col-sm-3 bg-dark border-end" ></div>
			
			<div class="col-sm-8 align-middle m-3" id="content">
				<div class="container pt-2" >
					<h2 class="post-title mb-1"><b><%=board.getTitle()%></b></h2>
					<p class="post-meta mb-4">
						<%=board.getCreateDate()%> by
						<a href="#"><%=board.getWriter().getId()%></a>
					</p>
					
				</div>
				<div class="container" style="height:460px;">
					<p><%=board.getContents()%>
				</div>
				<div class="container">
					<p>첨부파일 ##<p> 
				</div>
				
				<button type="button" class="btn btn-secondary">
				목록으로
				
				</button>
				
			</div>
			
		</div>
	</div>

</body>
</html>