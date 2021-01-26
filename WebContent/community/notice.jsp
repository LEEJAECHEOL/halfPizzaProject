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
			<c:choose>
				<c:when test="${notices!=null}">
					<c:forEach var="n" items="${notices}">
						<div class="notice-item">
							<a href="#a">
								<h3>${n.title}</h3> <span><b>${n.createDate}</b></span>
							</a>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h3>등록된 공지가 없습니다.</h3>
				</c:otherwise>
			</c:choose>
			<button class="notice-more">더보기+</button>
		</div>
	</div>
</main>
<%@ include file="../layouts/footer.jsp"%>
</body>

</html>