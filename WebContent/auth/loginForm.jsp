<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp" %>

	<main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>로그인</span></h3>
            </div>
            <div class="subpage-box">
                <div class="login-form">
                    <form method="post" action="${pageContext.request.contextPath}/auth/loginProc">
                        <input type="text" name="username" placeholder="ID">
                        <input type="password" name="password" placeholder="PW">

                        <label class="checkbox">
                            <input type="checkbox" name="login-idSave" id="login-idSave">
                            <span class="lbl"><i></i>아이디 저장</span>
                        </label>

                        <button class="btn-blue">로그인</button>
                    </form>
                    <ul class="user-info-search">
                        <li><a href="${pageContext.request.contextPath}/auth/selectByEmailFormId">아이디찾기</a></li>
                        <li><a href="${pageContext.request.contextPath}/auth/selectByIdFormPass">비밀번호찾기</a></li>
                        <li><a href="${pageContext.request.contextPath}/auth/registerTerms">회원가입</a></li>
                        <li><a href="${pageContext.request.contextPath}/order/noMemberOrderSearch">비회원 주문조회</a></li>
                    </ul>

                    <a href="#a"><img src="${pageContext.request.contextPath}/images/contents/ico_login_kakako.png" alt=""><span>카카오로그인</span></a>
                </div>
            </div>
        </div>
    </main>

<%@ include file="../layouts/footer.jsp" %>
</body>
</html>