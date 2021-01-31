<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/header.jsp"%>
<main class="index">
	<div class="container">
		<!--베너-->
		<div class="banner">
			<img
				src="${pageContext.request.contextPath}/images/main_banner/2020123194934974_256187f80d274391810230880729b447.png"
				alt="">
		</div>

		<!--오늘 뭐먹지?-->
		<div class="title">
			<h3 class="underLine">
				<span>오늘 뭐먹지?</span>
			</h3>
			<ul>
				<li><a href="#a" class="selected">추천메뉴</a></li>
				<li><a href="#a">오리지널</a></li>
				<li><a href="#a">세트메뉴</a></li>
			</ul>
		</div>

		<!--슬라이더-->
		<section class="visual1">
			<c:choose>
				<c:when test="${menu!=null}">
					<c:forEach var="m" items="${menu}">
						<div class="visual-item">
							<div class="visual-content">
								<img src="${pageContext.request.contextPath}/${m.path}${m.changeFileName1}"	alt=""> 
								<a href="#a">
									<h3 class="beanist-detail">${m.title}</h3>
									<p class="beanist-detail-en">
										<c:if test="${m.isR eq 1}">
											<strong>R</strong>
											<span><fmt:formatNumber value="${m.price - 2000 }" pattern="#,###" />원</span>
										</c:if>
										<strong>L</strong>
										<span><fmt:formatNumber	value="${m.price }" pattern="#,###" />원</span>
									</p>
								</a>
								<a class="menu-select blue" href="${pageContext.request.contextPath}/menu/menuView?gubun=pizza&id=${m.id}">
									<p>선택</p>
									<p>하기</p>
								</a>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h3>등록된 메뉴가 없습니다.</h3>
				</c:otherwise>
			</c:choose>
		</section>

		<div class="title">
			<h3 class="underLine">
				<span>반올림피자샵</span>
			</h3>
		</div>

		<div class="communication">
			<a href="https://www.youtube.com/channel/UCOj3KZVKRMben6zlfSH8uAw"
				target="_blank">
				<div class="communication-item">
					<h3>youtube</h3>
					<img
						src="${pageContext.request.contextPath}/images/contents-main/ico_main_bottom_5.png"
						alt="">
				</div>
			</a> <a href="${pageContext.request.contextPath}/community/notice">
				<div class="communication-item">
					<h3>공지사항</h3>
					<img
						src="${pageContext.request.contextPath}/images/contents-main/ico_main_bottom_4.png"
						alt="">
				</div>
			</a> <a href="${pageContext.request.contextPath}/community/event">
				<div class="communication-item">
					<h3>이벤트</h3>
					<img
						src="${pageContext.request.contextPath}/images/contents-main/ico_main_bottom_3.png"
						alt="">
				</div>
			</a> <a href="${pageContext.request.contextPath}/store">
				<div class="communication-item">
					<h3>매장안내</h3>
					<img
						src="${pageContext.request.contextPath}/images/contents-main/ico_main_bottom_2.png"
						alt="">
				</div>
			</a> <a href="#a">
				<div class="communication-item">
					<h3>창업안내</h3>
					<img
						src="${pageContext.request.contextPath}/images/contents-main/ico_main_bottom_1.png"
						alt="">
				</div>
			</a> <a href="${pageContext.request.contextPath}/community/contact">
				<div class="communication-item">
					<h3>고객의 소리</h3>
					<img
						src="${pageContext.request.contextPath}/images/contents-main/ico_main_bottom_0.png"
						alt="">
				</div>
			</a>
		</div>
	</div>
</main>
<%@ include file="../layouts/footer.jsp"%>

<!--Script-->
<script>
        $('.visual1').slick({
            infinite: true,
            slidesToShow: 3,
            slidesToScroll: 1,
            speed: 1000,
        });
    </script>

</body>
</html>