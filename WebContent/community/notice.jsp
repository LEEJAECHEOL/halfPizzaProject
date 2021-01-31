<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp"%>
<main>
	<div class="container">
		<div class="sub-p-title">
			<h3 class="underLine">
				<span>공지사항</span>
			</h3>
		</div>

		<form action="" class="search-box">
			<input type="text" placeholder="검색할 내용을 입력해주세요">
			<button type="submit">
				<i class="xi-search"></i>
			</button>
		</form>

		<div class="notice-box">
			<div>
			<c:choose>
				<c:when test="${notices!=null}">
					<c:forEach var="n" items="${notices}">
						<div class="notice-item">
							<a href="${pageContext.request.contextPath}/community/detail?id=${n.id}">
								<h3>${n.title}</h3> <span><b>${n.createDate}</b></span>
							</a>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h3>등록된 공지가 없습니다.</h3>
				</c:otherwise>
			</c:choose>
			</div>
			<button class="notice-more" type="button">더보기+</button>
		</div>
	</div>
</main>
<script>
	let page = 1;
	document.querySelector('.notice-more').addEventListener('click', function(){
		$.ajax({
			type : "GET",
			url : "http://localhost:8000/halfPizza/community/notice/more?page=" + page,
			dataType:"json"
		})
		.done(function(result){
			if(result.statusCode === 400){
				if(result.data.length !== 0){
					let content = "";
					for(let i = 0; i < result.data.length; i++){
						content += "<div class='notice-item'>";
						content += "<a href='$halfPizza/community/detail?id=" + result.data[i].id + "'>";
						content += "<h3>" + result.data[i].title + "</h3> <span><b>" + result.data[i].createDate + "</b></span>";
						content += "</a></div>";
					}
					document.querySelector(".notice-box div").insertAdjacentHTML("beforeend", content);
					page++;
				}else{
					alert("마지막 페이지입니다.");
				}
			}else {
				alert("잘못된 요청입니다.");
			}
		});
	});
</script>
<%@ include file="../layouts/footer.jsp"%>
</body>

</html>