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
                    <li><a href="${pageContext.request.contextPath}/auth/myCoupon" class="selected">쿠폰함</a></li>
                    <li><a href="${pageContext.request.contextPath}/auth/myStamp">스탬프</a></li>
                    <li><a href="${pageContext.request.contextPath}/auth/updateChk">개인정보수정</a></li>
                </ul>
            </div>
            
            <div class="my-coupon-box">
                <div class="my-coupon-box-top">
                    <h3>E쿠폰은 현재 서비스 준비중입니다.</h3>
                    <div>
                        <span>쿠폰등록</span>
                        <input type="text" readOnly>
                        <button>등록</button>
                    </div>
                </div>
                <div class="my-coupon-box-bottom">
                    <p><sup>*</sup>모든 모바일상품권 (금액권, 교환권)은 매장 전화 주문도 가능합니다. (네고왕 쿠폰, 볼파스엔젤맨 쿠폰 포함)</p>
                    <p><sup>*</sup>주문 시 쿠폰 조회가 되지 않거나 매장 찾기가 되지 않는 경우, 해당 매장으로 전화주문하여 쿠폰번호 알려주세요.</p>
                    <p>사용가능한 쿠폰이 없습니다.</p>
                </div>
            </div>
        </div>
    </main>
    <%@ include file="../layouts/footer.jsp" %>
</body>

</html>