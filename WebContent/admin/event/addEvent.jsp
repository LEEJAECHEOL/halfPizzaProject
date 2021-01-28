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
		<label>미리보기 이미지</label>
		<input type="file" name="previewImg" required>
		<input type="hidden" name="gubun" value="prev">
		<label>제목 : </label><input type="text" name="title" required>
		<label>내용 이미지</label>
		<input type="hidden" name="gubun" value="content" required>
		<input type="file" name="contentImg">
		<label>시작일 : </label><input type="date" name="fromDate" required>
		<label>종료일 : </label><input type="date" name="toDate" required>
		<button>저장</button>
	</form>
</body>
</html>