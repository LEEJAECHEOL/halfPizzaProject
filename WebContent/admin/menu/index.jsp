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
	<a href="/halfPizza/admin/menu/regist">메뉴등록</a>
	<c:choose>
	  	<c:when test="${menu!=null}">
			<c:forEach var="m" items="${menu}">
				<div>
					<div>
						<input type="hidden" name="id" value="${m.id}">
						<img alt="" src="/halfPizza/${m.path}${m.changeFileName}">
						<h3>${m.title }</h3>
						<p>${m.content }</p>
						<p>${m.price }</p>
						
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