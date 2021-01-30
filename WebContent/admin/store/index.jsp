<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../layouts/adminHeader.jsp"%>
<main>
	<div class="container">
		<div class="sub-p-title">
			<h3 class="underLine">
				<span>스토어 리스트</span>
			</h3>
		</div>

		<a href="/halfPizza/admin/store/regist" class="addMenu">스토어등록</a>

		<div class="faq-list">
			<c:choose>
				<c:when test="${dto!=null}">
					<c:forEach var="dto" items="${dto}">
						<div class="faq-item">
							<p>지점명 : ${dto.name }</p>
							<p>주소 : ${dto.addr} ${dto.addr2}</p>
							<p>전화번호 : ${dto.tel }</p>
							<button onclick="deleteById(${dto.id})">삭제하기</button>
						</div>

					</c:forEach>
				</c:when>
				<c:otherwise>
					<h3>등록된 스토어가 없습니다.</h3>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</main>
<script>
	function deleteById(id){
		if(confirm('해당 스토어를 삭제하시겠습니까?')){
			$.ajax({
				type:"POST",
				url:"/halfPizza/admin/store/delete",
				data:"id="+id,
				dataType: "json",
			}).done(function(result){
				if(result.data === 'ok'){
					location.href="/halfPizza/admin/store";
				}
				else{
					alert("삭제 실패");
				}
			});
		}
	}
</script>
</body>

</html>