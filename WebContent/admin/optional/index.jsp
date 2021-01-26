<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴추가선택관리</title>
<style type="text/css">
	body {padding:10px;}
	li {list-style:none;height:30px; border-bottom:1px solid #555;padding : 0 20px;}
	li p {display:flex;width:100%;}
	li p span {margin-left:auto;}
	a {text-decoration:none;color:#333;}
	a {border:1px solid #333;border-radius:4px;padding:10px;}
</style>
</head>
<body>
	<a href="${pageContext.request.contextPath}/admin/optional/regist">추가선택등록</a>
	<ul>
		<li>
			<div>
				<p><b>상품명</b> <span><b>가격</b></span></p>
			</div>
		</li>
		<c:choose>
	  	<c:when test="${optional!=null}">
			<c:forEach var="opt" items="${optional}">
				<li>
					<div>
						<input type="hidden" name="id" value="${opt.id}">
						<p>${opt.title } <span>${opt.price}원</span></p>
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