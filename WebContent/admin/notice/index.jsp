<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../layouts/adminHeader.jsp"%>
<main>
	<div class="container">

		<div class="sub-p-title">
			<h3 class="underLine">
				<span>공지 리스트</span>
			</h3>
		</div>

		<a href="/halfPizza/admin/notice/regist" class="addMenu">공지등록</a>
		<div class="faq-list">
			<c:choose>
				<c:when test="${notices!=null}">
					<c:forEach var="n" items="${notices}">
						<div class="faq-item">
							<input type="hidden" name="id" value="${n.id}">
							<p>공지 제목 : ${n.title}</p>
							<p>${n.createDate}</p>
							<a href="/halfPizza/admin/notice/updateForm?id=${n.id}">수정</a>
							<button onclick="deleteById(${n.id})">삭제</button>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h3>등록된 공지가 없습니다.</h3>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</main>
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