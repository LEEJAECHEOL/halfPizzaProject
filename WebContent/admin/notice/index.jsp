<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/halfPizza/admin/notice/regist">공지등록</a>
	<c:choose>
	  	<c:when test="${notices!=null}">
			<c:forEach var="n" items="${notices}">
				<div>
					<div>
						<input type="hidden" name="id" value="${n.id}">
						<h3>${n.title}</h3>
						<p>${n.createDate}</p>
					</div>
				</div>
				<br />
			</c:forEach>
	  	</c:when>
	  	<c:otherwise>
	  		<h3>등록된 공지가 없습니다.</h3>
	  	</c:otherwise>
  	</c:choose>
</body>
</html>