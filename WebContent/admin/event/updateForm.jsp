<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/halfPizza/admin/event/updateProc" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${dto.id}">
		<label>미리보기 이미지</label>
		<input type="hidden" name="gubun" value="prev">
		<input type="file" name="previewImg" required>
		<label>제목 : </label><input type="text" name="title" value="${dto.title}" required>
		<label>내용 이미지</label>
		<input type="hidden" name="gubun" value="content">
		<input type="file" name="contentImg" required>
		<label>시작일 : </label><input type="date" name="fromDate" value="${dto.fromDate}" required>
		<label>종료일 : </label><input type="date" name="toDate" value="${dto.toDate}" required>
		<button>저장</button>
	</form>
</body>
</html>