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
                    <li><a href="${pageContext.request.contextPath}/auth/myPage">주문내역</a></li>
                    <li><a href="${pageContext.request.contextPath}/auth/myCoupon">쿠폰함</a></li>
                    <li><a href="${pageContext.request.contextPath}/auth/myStamp" class="selected">스탬프</a></li>
                    <li><a href="${pageContext.request.contextPath}/auth/updateChk">개인정보수정</a></li>
                </ul>
            </div>
            
            <div class="stamp-box">
                <h1><i class="xi-wrench"></i>현재 스탬프페이지는 준비중입니다</h1>
                <p><sup>*</sup>추후 공지사항을 확인해주세요</p>
                <p><sup>*</sup>스탬프는 연 최대 150개까지만 누적이 가능합니다.</p>
                <p><sup>*</sup>발급한 쿠폰은 마이페이지 &#62; 쿠폰함에 보여지며 온라인 주문 이용 시 사용할 수 있습니다.</p>
                <p><sup>*</sup>교환권은 결제페이지 내 쿠폰선택시 사용 가능합니다.</p>
                <p><sup>*</sup>쿠폰은 발급받은 이후로 3개월 이내에만 사용 가능하며 이후 소멸됩니다.</p>
                <p><sup>*</sup>사이드제품만 주문시에는 적용이 불가합니다.</p>
                <p><sup>*</sup>교환하지 않은 스탬프는 매년 1월 1일 소멸됩니다.</p>
            </div>
        </div>
    </main>

    <%@ include file="../layouts/footer.jsp" %>
</body>

</html>