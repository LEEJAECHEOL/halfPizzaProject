<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리페이지</title>
<style type="text/css">
	div {
		height:100vh;
		display:flex;
		align-items:center;
		justify-content:center;
		flex-wrap:wrap;
	}
	a {text-decoration:none;color:#333; font-size:26px;width:150px; height:150px;line-height:150px; border: 1px solid #444; border-radius:4px;text-align:center;}
	a:not(:last-child) {margin-right:10px}
	a:hover {opacity:0.8;}
</style>
</head>
<body>
	<a href="${pageContext.request.contextPath}/admin/menu/list">메뉴관리</a>
	<a href="${pageContext.request.contextPath}/admin/optional">추가선택관리</a>
	<a href="${pageContext.request.contextPath}/admin/notice/list">공지사항관리</a>
	<a href="${pageContext.request.contextPath}/admin/faq/list">FAQ관리</a>
	<a href="${pageContext.request.contextPath}/admin/event/list">이벤트관리</a>
</body>
</html>
