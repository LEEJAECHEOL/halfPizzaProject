
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../layouts/adminHeader.jsp" %>
<main>
	<div class="container">
		<div class="sub-p-title">
			<h3 class="underLine">
				<span>메뉴 리스트</span>
			</h3>
		</div>

		<a href="/halfPizza/admin/menu/regist" class="addMenu">메뉴등록</a>
		<div class="menu-list">
			<c:choose>
				<c:when test="${menu!=null}">
					<c:forEach var="m" items="${menu}">
						<div class="menu-item">
							<input type="hidden" name="id" value="${m.id}"> 
							<img alt="" src="/halfPizza/${m.path}${m.changeFileName}">
							<div class="menu-item-content">
								<p>피자명 : ${m.title }</p>
								<p>설명 : ${m.content }</p>
								<p>가격 : ${m.price }</p>
								<p>라지여부 : ${m.isR }</p>
								<p>구분 : ${m.gubun }</p>
								<a href="/halfPizza/admin/menu/updateForm?id=${m.id}">수정하기</a>
								<button onclick="deleteById(${m.id})">삭제하기</button>
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
	function deleteById(menuId){
		// 요청과 응답을 json으로 할꺼임
		var data = {
			menuId: menuId
		}
		$.ajax({
			type:"POST",
			url:"/halfPizza/admin/menu/delete?id="+menuId,
			dataType: "json",
		}).done(function(result){
			if(result.statusCode == 1){
				location.href="/halfPizza/admin/menu/list";
			}
			else{
				alert("삭제 실패");
			}
		});
	}
</script>
</body>

</html>