<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리페이지</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/admin/menu/list">메뉴관리</a>
	<a href="${pageContext.request.contextPath}/admin/optional">추가선택관리</a>
	<a href="${pageContext.request.contextPath}/admin/notice/list">공지사항관리</a>
	<a href="${pageContext.request.contextPath}/admin/faq/list">FAQ관리</a>
	<a href="${pageContext.request.contextPath}/admin/event/list">이벤트관리</a>
</body>
</html>
