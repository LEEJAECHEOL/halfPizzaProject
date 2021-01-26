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
	<a href="/halfPizza/admin/faq/regist">FAQ등록</a>
	<c:choose>
	  	<c:when test="${faqs!=null}">
			<c:forEach var="f" items="${faqs}">
				<div>
					<div>
						<input type="hidden" name="id" value="${f.id}">
						<h3>[${f.gubun }]  	${f.title }</h3>
						<p>${f.content }</p>
					</div>
				</div>
				<br />
			</c:forEach>
	  	</c:when>
	  	<c:otherwise>
	  		<h3>등록된 faq가 없습니다.</h3>
	  	</c:otherwise>
  	</c:choose>
</body>
</html>