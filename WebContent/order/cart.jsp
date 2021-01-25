<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp" %>
	<main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>주문서</span></h3>
            </div>
            <div class="my-address">
                <span>부산 남구 문현동 800-18 1층</span>
                <button>변경</button>
            </div>
            <c:choose>
			  	<c:when test="${cart!=null}">
					<c:forEach var="item" items="${cart}" varStatus="status">
           				<div class="order-box" data-cartNo=${status.index + 1 }>
           					<div class="order-menu">
			                    <img src="${item.menu.src}" alt="">
			                </div>
			                <div class="order-content">
			                    <div class="pizza-info">
			                        <h3>${item.menu.title}</h3>
			                        <span><fmt:formatNumber value="${item.menu.price}" pattern="#,###" />원</span>
			                    </div>
			                    <div class="other-thing">
			                        <table>
			                            <colgroup>
			                                <col width="80%">
			                                <col width="20%">
			                            </colgroup>
			                            <tr>
			                                <td>${item.size.text}</td>
			                                <td><fmt:formatNumber value="${item.size.price}" pattern="#,###" />원</td>
			                            </tr>
			                            <c:forEach var="option" items="${item.option}" varStatus="status">
			                            	<tr>
				                                <td>${option.text}</td>
				                                <td><fmt:formatNumber value="${option.price}" pattern="#,###" />원</td>
				                            </tr>
			                            </c:forEach>
			                        </table>
			                    </div>
			                    <div class="pizza-count">
			                        <span>수량</span>
			                        <div>
			                            <button class="qtyminus" field="quantity">-</button>
			                            <input id="qty" type="number" name="quantity" value="1" class="qty" />
			                            <button class="qtyplus" field="quantity">+</button>
			                        </div>
			                    </div>
			                    <div class="pizza-price">
			                        <span class="partPrice"><fmt:formatNumber value="${item.totalPrice}" pattern="#,###" />원</span>
			                    </div>
			                </div>
           				</div>
					</c:forEach>
			  	</c:when>
			  	<c:otherwise>
			  		<h3>장바구니가 비었습니다.</h3>
			  	</c:otherwise>
		  	</c:choose>
            <div class="total-price">
                <h3>총 주문금액</h3>
                <span>25,400</span>
            </div>
            <div class="order-button">
                <button class="add-menu">메뉴추가</button>
                <button class="order-start">주문하기</button>
            </div>
        </div>
    </main>
    <script>
		console.log(document.querySelectorAll('.partPrice'));
    </script>
    <script>
        $(function() {
            // This button will increment the value
            $('.qtyplus').click(function(e) {
                // Stop acting like a button
                e.preventDefault();
                // Get the field name
                fieldName = $(this).attr('field');
                // Get its current value
                var currentVal = parseInt($('input[name=' + fieldName + ']').val());
                // If is not undefined
                if (!isNaN(currentVal)) {
                    // Increment
                    $('input[name=' + fieldName + ']').val(currentVal + 1);
                } else {
                    // Otherwise put a 0 there
                    $('input[name=' + fieldName + ']').val(0);
                }
            });
            // This button will decrement the value till 0
            $(".qtyminus").click(function(e) {
                // Stop acting like a button
                e.preventDefault();
                // Get the field name
                fieldName = $(this).attr('field');
                // Get its current value
                var currentVal = parseInt($('input[name=' + fieldName + ']').val());
                // If it isn't undefined or its greater than 0
                if (!isNaN(currentVal) && currentVal > 1) {
                    // Decrement one
                    $('input[name=' + fieldName + ']').val(currentVal - 1);
                } else {
                    // Otherwise put a 0 there
                    $('input[name=' + fieldName + ']').val(1);
                }
            });

        });
    </script>

<%@ include file="../layouts/footer.jsp" %>
</body>
</html>