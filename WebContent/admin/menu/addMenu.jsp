<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/halfPizza/admin/menu/registProc" method="post" enctype="multipart/form-data">
		<label>상품 이미지</label>
		<input type="hidden" name="kind" value="pizza">
		<input type="file" name="file">
		<label>상품 명 : </label><input type="text" name="title">
		<label>상품 설명 : </label><textarea name="content" rows="3" cols=""></textarea>
		<label>가격 : </label><input type="text" name="price">
		<label>사이즈 R 여부 : </label><input type="checkbox" name="isR" value=1>
		<button>저장</button>
		
	
	</form>
</body>
</html>