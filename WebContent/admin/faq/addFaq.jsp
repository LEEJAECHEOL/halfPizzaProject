<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/admin/faq/registProc" method="post">
		<select name="gubun">
			<option value="계정 관련">계정 관련</option>
			<option value="배달관련">배달관련</option>
			<option value="스탬프 적립 관련">스탬프 적립 관련</option>
			<option value="온라인주문 관련">온라인주문 관련</option>
			<option value="주문확인/취소">주문확인/취소</option>
			<option value="포장주문 관련">포장주문 관련</option>
			<option value="할인정책 관련">할인정책 관련</option>
		</select>
		<label>제목 : </label><input type="text" name="title">
		<label>답변 : </label><textarea name="content" rows="3" cols=""></textarea>
		<button>저장</button>
	</form>
</body>
</html>