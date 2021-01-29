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
                    <li><a href="#a" class="selected">주문내역</a></li>
                    <li><a href="#a">쿠폰함</a></li>
                    <li><a href="#a">스탬프</a></li>
                    <li><a href="${pageContext.request.contextPath}/auth/updateChk">개인정보수정</a></li>
                </ul>
            </div>
            <div class="order-lookup">
                <h3>주문내역 변경 전 취소는 고객센터로 문의주시기 바랍니다.</h3>
                <span>기간 선택</span>
                <input type="date">
                <button>주문조회</button>
            </div>
            <div class="order-info-wrap">
	            <div class="order-info">
	                <h3>주문번호 1000113328</h3>
	                <div class="order-info-detail">
	                    <table width="80%">
	                        <colgroup>
	                            <col width="30%">
	                            <col width="30%">
	                            <col width="30%">
	                        </colgroup>
	                        <tr>
	                            <th>주문일자</th>
	                            <th>주문매장</th>
	                            <th>결제금액</th>
	                        </tr>
	                        <tr>
	                            <td>2021-01-16</td>
	                            <td>부산남구점(051-628-3888)</td>
	                            <td>31,900원</td>
	                        </tr>
	                    </table>
	                    <button class="open3"><span>상세</span>
	                        <p>보기</p>
	                    </button>
	                </div>
	            </div>
                <button class="order-list-more">더보기+</button>
            </div>
        </div>
        <br>
    </main>
    
    <%@ include file="../layouts/footer.jsp" %>
    
    <div class="popup3">
        <div class="pop3-info">
            <span>매장정보</span>
            <h4>부산남구점(051-628-3888)</h4>
        </div>
        <div class="pop3-info">
            <span>주문날짜</span>
            <h4>2021-01-16 13:32:02</h4>
        </div>
        <div class="pop3-info">
            <span>주문번호</span>
            <h4>1000113328</h4>
        </div>
        <div class="pop3-pizza-info">
            <table width="100%">
                <colgroup>
                    <col width="50%">
                    <col width="15%">
                    <col width="35%">
                </colgroup>
                <tr>
                    <td>통마늘 불고기 소보로</td>
                    <td>1</td>
                    <td>20,900</td>
                </tr>
                <tr>
                    <td>Regualr</td>
                    <td></td>
                    <td>0원</td>
                </tr>
                <tr>
                    <td>스프라이트</td>
                    <td></td>
                    <td>1,500원</td>
                </tr>
            </table>
            <p><span>할인</span><b>0</b></p>
            <p><span>최종결제금액</span><strong>22,400원</strong></p>
        </div>
        <div class="delivery-shop">
            <div class="delivery-shop-info">
                <span>매장주소</span>
                <p>부산 남구 용소로 19번길 88 부산남구점</p>
            </div>
            <div class="delivery-shop-info">
                <span>전화번호</span>
                <p>010-9062-2304</p>
            </div>
            <div class="delivery-shop-info">
                <span>요청사항</span>
                <p></p>
            </div>
        </div>
        <div class="btn-group">
            <button class="retry-order">재주문</button>
            <button class="close3">확인</button>
        </div>
    </div>
    <div class="dim"></div>
</body>

</html>