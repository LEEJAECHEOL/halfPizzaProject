<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp" %>
	<main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>주문서</span></h3>
            </div>
            <div class="my-address">
                <span>배송지를 선택해주세요.</span>
                <a href="${pageContext.request.contextPath}/delivery">변경</a>
            </div>
            <c:choose>
			  	<c:when test="${cart!=null}">
					<c:forEach var="item" items="${cart}">
           				<div class="order-box ${item.name}">
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
			                            <tr class="size">
			                                <td>${item.size.text}</td>
			                                <td><fmt:formatNumber value="${item.size.price}" pattern="#,###" />원</td>
			                            </tr>
			                            <c:forEach var="option" items="${item.option}" varStatus="status">
			                            	<tr class="option">
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
			                            <input id="qty" type="number" name="quantity" value="1" class="qty" readonly />
			                            <button class="qtyplus" field="quantity">+</button>
			                        </div>
			                    </div>
			                    <div class="pizza-price">
			                        <span class="partPrice" data-price=${item.totalPrice} data-count=1><fmt:formatNumber value="${item.totalPrice}" pattern="#,###" />원</span>
			                    </div>
			                </div>
			               	<button class="delete-cart" onClick="deleteCart('${item.name}')" ><i class="fas fa-times"></i></button>
           				</div>
					</c:forEach>
			  	</c:when>
			  	<c:otherwise>
			  		<h3>장바구니가 비었습니다.</h3>
			  	</c:otherwise>
		  	</c:choose>
            <div class="total-price">
                <h3>총 주문금액</h3>
                <span id="cartToltalPrice">0원</span>
            </div>
            <div class="order-button">
                <button class="add-menu">메뉴추가</button>
                <button class="order-start">주문하기</button>
            </div>
        </div>
    </main>
    <script>
		function deleteCart(cartNo){
			document.querySelector("." + cartNo).remove();
			deleteCookie(cartNo);
		}
		function deleteCookie(name) {
			document.cookie = name + '=; expires=Thu, 01 Jan 1999 00:00:10 GMT;';
		}
		function moneyComma(val){
			return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "원";
		}
		window.addEventListener('DOMContentLoaded', function() {
			let prices = document.querySelectorAll('.partPrice');
			let price = 0;
			prices.forEach(function(p){
				price += Number(p.dataset.price);
			});
			document.querySelector('#cartToltalPrice').dataset.price = price;
			document.querySelector('#cartToltalPrice').textContent = moneyComma(price);
		});

    </script>
    <script>
        $(function() {
            $('.qtyplus').click(function(e) {
                e.preventDefault();
                fieldName = $(this).attr('field');
                var currentVal = parseInt($('input[name=' + fieldName + ']').val());
                if (!isNaN(currentVal)) {
                    $('input[name=' + fieldName + ']').val(currentVal + 1);
                    let priceSpan = $(this)[0].parentElement.parentElement.nextElementSibling.children[0];
                    priceSpan.dataset.count = Number(priceSpan.dataset.count) + 1;
                    priceSpan.textContent = moneyComma(priceSpan.dataset.price * priceSpan.dataset.count);
                    totalPriceUpdate();
                } else {
                    $('input[name=' + fieldName + ']').val(0);
                }
            });
            $(".qtyminus").click(function(e) {
                e.preventDefault();
                fieldName = $(this).attr('field');
                var currentVal = parseInt($('input[name=' + fieldName + ']').val());
                if (!isNaN(currentVal) && currentVal > 1) {
                    $('input[name=' + fieldName + ']').val(currentVal - 1);
                    let priceSpan = $(this)[0].parentElement.parentElement.nextElementSibling.children[0];
                    priceSpan.dataset.count = Number(priceSpan.dataset.count) - 1;
                    priceSpan.textContent = moneyComma(priceSpan.dataset.price * priceSpan.dataset.count);
                    totalPriceUpdate();
                } else {
                    $('input[name=' + fieldName + ']').val(1);
                }
            });

            function totalPriceUpdate(){
            	let prices = document.querySelectorAll('.partPrice');
    			let price = 0;
    			prices.forEach(function(p){
    				price += Number(p.dataset.price) * p.dataset.count;
    			});
    			document.querySelector('#cartToltalPrice').dataset.price = price;
    			document.querySelector('#cartToltalPrice').textContent = moneyComma(price);
            }

        });
    </script>

<%@ include file="../layouts/footer.jsp" %>
</body>
</html>