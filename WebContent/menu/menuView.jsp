<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp" %>
	<main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>주문하기</span></h3>
            </div>

            <div class="choice-menu-detail">
                <div class="choice-menu-detail-left">
                    <div class="choice-menu-detail-left-top">
                    	<input type="hidden" name="id" value="${menu.id }">
                    	<input type="hidden" name="priceR" value="${menu.price - 2000 }">
                    	<input type="hidden" name="priceL" value="${menu.price }">
                        <img src="${pageContext.request.contextPath}${menu.path}${menu.changeFileName}" alt="">
                        <div class="sub-p-title">
                            <h3 class="underLine"><span>${menu.title }</span></h3>
                        </div>
                        <p>${menu.content }</p>
                        <h5>
                        	<c:if test="${menu.isR eq 1}">
                        		<span>R</span><b><fmt:formatNumber value="${menu.price - 2000 }" pattern="#,###" />원</b>	
                        	</c:if>
	                        <span>L</span><b><fmt:formatNumber value="${menu.price }" pattern="#,###" />원</b>
                        </h5>
                    </div>
                    <div class="choice-menu-detail-left-middle">
                       <h4>한조각 제공량 (Large)</h4>
                        <table width="100%;">
                            <colgroup>
                                <col width="14%">
                                <col width="14%">
                                <col width="14%">
                                <col width="14%">
                                <col width="14%">
                                <col>
                            </colgroup>
                            <tr>
                                <th>총<br>제공량</th>
                                <th>무게</th>
                                <th>열량</th>
                                <th>당류</th>
                                <th>단백질</th>
                                <th>포화지방</th>
                                <th>나트륨</th>
                            </tr>
                            <tr>
                                <td>8조각</td>
                                <td>79.4g</td>
                                <td>181.9kcal</td>
                                <td>3.4g</td>
                                <td>11.1g</td>
                                <td>4.9g</td>
                                <td>659.9mg</td>
                            </tr>
                        </table>
                    </div>
                    <div class="choice-menu-detail-left-bottom">
                        <h4><span>더블포크쉬림프 콘치즈피자</span><b>20,900 원</b></h4>
                        <p><span>+ Regular</span><b>0 원</b></p>
                        <h5><span>총 주문금액</span><b>20,900원</b></h5>
                        <button>담기</button>
                    </div>
                </div>
                <div class="choice-menu-detail-right">
                    <div class="choice-menu-detail-right-top">
                        <h3>[필수]기본</h3>
                        <ul>
                            <li class="selected">Regular</li>
                            <li>Large</li>
                        </ul>
                    </div>
                    <div class="choice-menu-detail-right-bottom">
                        <h3>추가선택</h3>
                        <div class="choice-menu-detail-right-bottom-list">
                            <span class="selected">치즈추가</span>
                            <span>코카콜라 500ML</span>
                            <span>코카콜라 1.25L</span>
                            <span>스프라이트 500ML</span>
                            <span>스프라이트 1.5L</span>
                            <span>특제 갈릭소스</span>
                            <span>수제피클</span>
                            <span>THE 맛있는 핫소스</span>
                            <span>오븐 스파게티</span>
                            <span>치킨텐더(4조각)</span>
                            <span>훈제치킨(한마리)</span>
                            <span>THE 매운 훈제치킨(한마리)</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>


<%@ include file="../layouts/footer.jsp" %>
</body>
</html>