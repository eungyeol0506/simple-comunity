<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<div class="col-sm-3 p-3 bg-primary"></div>
			<div class="col-sm-8 align-middle">
			
			<jsp:include page="/WEB-INF/views/board/BoardListView.jsp"/>
			
			</div>
		</div>
	</div>
	
	<div>
		<jsp:include page="/WEB-INF/views/main/footer.jsp"/>
	</div>
</body>
</html>