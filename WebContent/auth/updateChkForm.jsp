<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layouts/header.jsp" %>

    <main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>마이페이지</span></h3>
            </div>
            <div class="mypage-list">
                <ul>
                    <li><a href="#a">주문내역</a></li>
                    <li><a href="#a">쿠폰함</a></li>
                    <li><a href="#a">스탬프</a></li>
                    <li><a href="#a" class="selected">개인정보수정</a></li>
                </ul>
            </div>
            <div class="subpage-box">
			<div class="mypage-passwordCk">
				<form method="post" action="${pageContext.request.contextPath}/auth/updateChkProc">
					<h3>개인정보 보호를 위해 비밀번호를 입력해주세요</h3>
					<input type="hidden" name="id" value="${user.id}"> <input
						type="password" placeholder="비밀번호를 입력해주세요" name="password">
					<p class="passwordCk-warning">
						<span>*타인에게 유출되지 않도록 주의해주세요.</span> <span>*개인정보 보호를 위해
							정기적으로 비밀번호를 변경해주세요.</span>
					</p>
					<button class="passCk">확인</button>
				</form>
			</div>
		</div>
        </div>
    </main>
    <%@ include file="../layouts/footer.jsp" %>
</body>

</html>