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
	<a href="/halfPizza/admin/event/regist">이벤트등록</a>
	<c:choose>
	  	<c:when test="${events!=null}">
			<c:forEach var="e" items="${events}">
				<div>
					<div>
						<input type="hidden" name="id" value="${e.id}">
						<img alt="" src="/halfPizza/${e.path}${e.changeFileName}">
						<h3>${e.title }</h3>
						<p>${e.content }</p>
					</div>
				</div>
				<br />
			</c:forEach>
	  	</c:when>
	  	<c:otherwise>
	  		<h3>등록된 메뉴가 없습니다.</h3>
	  	</c:otherwise>
  	</c:choose>
</body>
</html>