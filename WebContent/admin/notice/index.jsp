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
	<a href="/halfPizza/admin/notice/regist">공지등록</a>
	<c:choose>
	  	<c:when test="${notices!=null}">
			<c:forEach var="n" items="${notices}">
				<div>
					<div>
						<input type="hidden" name="id" value="${n.id}">
						<h3>${n.title}</h3>
						<p>${n.createDate}</p>
						<a href="/halfPizza/admin/notice/updateForm?id=${n.id}">수정</a>
						<button onclick="deleteById(${n.id})">삭제</button>
					</div>
				</div>
				<br />
			</c:forEach>
	  	</c:when>
	  	<c:otherwise>
	  		<h3>등록된 공지가 없습니다.</h3>
	  	</c:otherwise>
  	</c:choose>
  	<script>
	function deleteById(noticeId){
		// 요청과 응답을 json으로 할꺼임
		var data = {
			noticeId: noticeId
		}
		
		$.ajax({
			type:"POST",
			url:"/halfPizza/admin/notice/delete?id="+noticeId,
			dataType: "json",
		}).done(function(result){
			if(result.statusCode == 1){
				location.href="/halfPizza/admin/notice/list";
			}
			else{
				alert("삭제 실패");
			}
		});
	}
</script>
</body>
</html>