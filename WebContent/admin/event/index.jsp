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
	<a href="/halfPizza/admin/event/regist">이벤트등록</a>
	<c:choose>
	  	<c:when test="${events!=null}">
			<c:forEach var="e" items="${events}">
				<div>
					<div>
						<input type="hidden" name="id" value="${e.id}">
						<img alt="" src="/halfPizza/${e.path}${e.changeFileName1}">
						<h3>${e.title}</h3>
						<p>${e.fromDate} ~ ${e.toDate}</p>
					</div>
					<a href="/halfPizza/admin/event/updateForm?id=${e.id}">수정하기</a>
					<button onclick="deleteById(${e.id})">삭제하기</button>
				</div>
				<br />
			</c:forEach>
	  	</c:when>
	  	<c:otherwise>
	  		<h3>등록된 메뉴가 없습니다.</h3>
	  	</c:otherwise>
  	</c:choose>
  	<script>
	function deleteById(eventId){
		// 요청과 응답을 json으로 할꺼임
		var data = {
			eventId: eventId
		}
		$.ajax({
			type:"POST",
			url:"/halfPizza/admin/event/delete?id="+eventId,
			dataType: "json",
		}).done(function(result){
			if(result.statusCode == 1){
				location.href="/halfPizza/admin/event/list";
			}
			else{
				alert("삭제 실패");
			}
		});
	}
</script>
</body>
</html>