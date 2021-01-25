<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/admin/optional/registProc" method="post">
		<label>상품 명 : </label><input type="text" name="title" required>
		<label>가격 : </label><input type="text" name="price" required>
		<button>저장</button>
	</form>
</body>
</html>