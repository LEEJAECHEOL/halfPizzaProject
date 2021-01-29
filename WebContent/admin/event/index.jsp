<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../layouts/adminHeader.jsp"%>
<main>
	<div class="container">
		<div class="sub-p-title">
			<h3 class="underLine">
				<span>이벤트 리스트</span>
			</h3>
		</div>

		<a href="/halfPizza/admin/event/regist" class="addMenu">이벤트등록</a>

	<div class="event-list">
		<c:choose>
			<c:when test="${events!=null}">
				<c:forEach var="e" items="${events}">
				<div class="event-item">
					<input type="hidden" name="id" value="${e.id}">
                    <img src="/halfPizza/${e.path}${e.changeFileName1}" alt="">
                    <div class="event-item-content">
                        <p>이벤트타이틀 : ${e.title}</p>
                        <p>기간 : ${e.fromDate} ~ ${e.toDate}</p>
                        <a href="/halfPizza/admin/event/updateForm?id=${e.id}">수정하기</a>
						<button onclick="deleteById(${e.id})">삭제하기</button>
                    </div>
                </div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<h3>등록된 메뉴가 없습니다.</h3>
			</c:otherwise>
		</c:choose>
		</div>
	</div>
</main>

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