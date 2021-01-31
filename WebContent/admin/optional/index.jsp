<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../layouts/adminHeader.jsp"%>
<main>
	<div class="container">
		<div class="sub-p-title">
			<h3 class="underLine">
				<span>옵션 리스트</span>
			</h3>
		</div>

		<a href="${pageContext.request.contextPath}/admin/optional/regist" class="addMenu">추가선택</a>

		<div class="option-list">
			<c:choose>
				<c:when test="${optional!=null}">
					<c:forEach var="opt" items="${optional}">
						<div class="option-item">
							<div class="option-item-content">
								<input type="hidden" name="id" value="${opt.id}">
								<p>상품명 : ${opt.title }</p>
								<p>구분 : ${opt.gubun}</p>
								<p>가격 : ${opt.price}원</p>
								<button onclick="deleteById(${opt.id})">삭제하기</button>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h3>등록된 추가선택 메뉴가 없습니다.</h3>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</main>
</body>

<script>
	function deleteById(optId){
		// 요청과 응답을 json으로 할꺼임
		var data = {
			optId: optId
		}
		$.ajax({
			type:"POST",
			url:"/halfPizza/admin/optional/delete?id="+optId,
			dataType: "json",
		}).done(function(result){
			if(result.statusCode == 1){
				location.href="/halfPizza/admin/optional";
			}
			else{
				alert("삭제 실패");
			}
		});
	}
</script>
</body>
</html>