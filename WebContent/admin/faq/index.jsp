<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
					<a href="/halfPizza/admin/faq/updateForm?id=${f.id}">수정하기</a>
					<button onclick="deleteById(${f.id})">삭제하기</button>
				</div>
				<br />
			</c:forEach>
	  	</c:when>
	  	<c:otherwise>
	  		<h3>등록된 faq가 없습니다.</h3>
	  	</c:otherwise>
  	</c:choose>
  	<script>
	function deleteById(faqId){
		// 요청과 응답을 json으로 할꺼임
		var data = {
			faqId: faqId
		}
		$.ajax({
			type:"POST",
			url:"/halfPizza/admin/faq/delete?id="+faqId,
			dataType: "json",
		}).done(function(result){
			if(result.statusCode == 1){
				location.href="/halfPizza/admin/faq/list";
			}
			else{
				alert("삭제 실패");
			}
		});
	}
</script>
</body>
</html>