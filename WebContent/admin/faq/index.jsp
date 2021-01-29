<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../layouts/adminHeader.jsp"%>

<main>
	<div class="container">
		<div class="sub-p-title">
			<h3 class="underLine">
				<span>FAQ 리스트</span>
			</h3>
		</div>

		<a href="/halfPizza/admin/faq/regist" class="addMenu">FAQ등록</a>

		<div class="faq-list">
			<c:choose>
				<c:when test="${faqs!=null}">
					<c:forEach var="f" items="${faqs}">
						<div class="faq-item">
							<input type="hidden" name="id" value="${f.id}">
							<p>구분 : [${f.gubun }]</p>
							<p>질문 : ${f.title }</p>
							<p>답변 : ${f.content }</p>
							<a href="/halfPizza/admin/faq/updateForm?id=${f.id}">수정하기</a>
							<button onclick="deleteById(${f.id})">삭제하기</button>
						</div>

					</c:forEach>
				</c:when>
				<c:otherwise>
					<h3>등록된 faq가 없습니다.</h3>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</main>

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