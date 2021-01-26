<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/halfPizza/admin/event/registProc" method="post" enctype="multipart/form-data">
		<label>이벤트 이미지</label>
		<input type="file" name="file">
		<label>제목 : </label><input type="text" name="title">
		<label>내용 : </label><textarea name="content" rows="3" cols=""></textarea>
		<label>시작일 : </label><input type="date" name="fromDate">
		<label>종료일 : </label><input type="date" name="toDate">
		<button>저장</button>
	</form>
</body>
</html>