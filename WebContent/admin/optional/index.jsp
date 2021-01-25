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
	<a href="${pageContext.request.contextPath}/admin/optional/regist">추가선택등록</a>
	<ul>
		<c:choose>
	  	<c:when test="${optional!=null}">
			<c:forEach var="opt" items="${optional}">
				<li>
					<div>
						<input type="hidden" name="id" value="${opt.id}">
						<p>${opt.title } ${opt.price}원</p>
					</div>
				</li>
			</c:forEach>
	  	</c:when>
	  	<c:otherwise>
	  		<h3>등록된 추가선택 메뉴가 없습니다.</h3>
	  	</c:otherwise>
  	</c:choose>
	</ul>
</body>
</html>