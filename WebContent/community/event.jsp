<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp"%>

<main>
	<div class="container">
		<div class="sub-p-title">
			<h3 class="underLine">
				<span>이벤트</span>
			</h3>
		</div>
		<div class="event-list">
			<c:choose>
				<c:when test="${events!=null}">
					<c:forEach var="e" items="${events}">

						<div class="event-item">
							<a href="${pageContext.request.contextPath}/community/event/detail?id=${e.id}">
								<img src="${pageContext.request.contextPath}${e.path}${e.changeFileName1}" alt="">
								<div class="event-content">
									<h3>${e.title}</h3>
									<p>${e.fromDate}~${e.toDate}</p>
								</div>
							</a>
						</div>

					</c:forEach>
				</c:when>
				<c:otherwise>
					<h3>등록된 이벤트가 없습니다.</h3>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</main>
<%@ include file="../layouts/footer.jsp"%>
</body>

</html>