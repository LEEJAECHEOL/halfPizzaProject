<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
                        <img src="${pageContext.request.contextPath}${menu.path}${menu.changeFileName1}" alt="">
                        <div class="sub-p-title">
                            <h3 class="underLine"><span>${menu.title }</span></h3>
                        </div>
                        <p>${menu.content }</p>
                        <h5>
	                        <b><fmt:formatNumber value="${menu.price }" pattern="#,###" />원</b>
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
                        <div class="menu-request">
                        	<h4 data-id=${menu.id} data-title=${menu.title} data-price=${menu.price}><span>${menu.title}</span><b><fmt:formatNumber value="${menu.price}" pattern="#,###" /> 원</b></h4>
                        </div>
                        <h5>
                        	<span>총 주문금액</span>
					  		<b id="totalPrice" data-total=${menu.price }>
                        		<fmt:formatNumber value="${menu.price }" pattern="#,###" /> 원
                       		</b>
                        </h5>
                        <button type="button" id="cartBtn">담기</button>
                    </div>
                </div>
                <div class="choice-menu-detail-right">
                    <div class="choice-menu-detail-right-bottom">
						<h3>[필수]피자 선택 1</h3>
						<div class="choice-menu-detail-right-bottom-list choice-pizza1">
						<c:choose>
						  	<c:when test="${optional!=null}">
								<c:forEach var="opt" items="${optional}">
									<c:if test="${opt.gubun eq 'pizza'}">
										<span data-id=${opt.id} data-price=${opt.price}>${opt.title}</span>
									</c:if>
								</c:forEach>
						  	</c:when>
						  	<c:otherwise>
						  		<h3>등록된 메뉴가 없습니다.</h3>
						  	</c:otherwise>
					  	</c:choose>
					  	</div>
                    </div>
                    <div class="choice-menu-detail-right-bottom">
						<h3>[필수]피자 선택 2</h3>
						<div class="choice-menu-detail-right-bottom-list choice-pizza2">
						<c:choose>
						  	<c:when test="${optional!=null}">
								<c:forEach var="opt" items="${optional}">
									<c:if test="${opt.gubun eq 'pizza'}">
										<span data-id=${opt.id} data-price=${opt.price}>${opt.title}</span>
									</c:if>
								</c:forEach>
						  	</c:when>
						  	<c:otherwise>
						  		<h3>등록된 메뉴가 없습니다.</h3>
						  	</c:otherwise>
					  	</c:choose>
					  	</div>
                    </div>
                    <div class="choice-menu-detail-right-bottom">
                        <h3>추가선택</h3>
                        <div class="choice-menu-detail-right-bottom-list choice-option">
                        <c:choose>
						  	<c:when test="${optional!=null}">
								<c:forEach var="opt" items="${optional}">
									<c:if test="${opt.gubun eq 'side'}">
										<span data-id=${opt.id} data-price=${opt.price}>${opt.title}</span>
									</c:if>
								</c:forEach>
						  	</c:when>
						  	<c:otherwise>
						  		<h3>등록된 메뉴가 없습니다.</h3>
						  	</c:otherwise>
					  	</c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    
    <script>
	    document.querySelector('.choice-pizza1').addEventListener('click', function(e){
	    	if(e.target && e.target.tagName==="SPAN"){
	    		let _span = e.target;
				if(_span.classList.contains("selected")){
					return;
				}
	    		if(document.querySelector('.choice-pizza1 span.selected')){
	    			document.querySelector('.choice-pizza1 span.selected').classList.remove('selected');
	    		}
	    		_span.classList.add('selected');
	    		let _request = document.querySelector('.menu-request');
				let _id = _span.dataset.id;
				let _price = _span.dataset.price;
				let _text = _span.textContent;
				let _totalPrice = document.querySelector('#totalPrice');
				if(document.querySelector('.menu-request p.pizza1')){
					_totalPrice.dataset.total = Number(_totalPrice.dataset.total) - Number(document.querySelector('.menu-request p.pizza1').dataset.price);
					document.querySelector('.menu-request p.pizza1').remove();
				}
				let _content = "<p class='pizza1' data-id='" + _id + "' data-price='" + _price + "'><span>+ " + _text + "</span><b>" + moneyComma(_price) + "</b></p> ";
				_request.insertAdjacentHTML("beforeend", _content);
				_totalPrice.dataset.total = Number(_totalPrice.dataset.total) + Number(_price);
				_totalPrice.textContent = moneyComma(_totalPrice.dataset.total);
	    	}
	    });
	    document.querySelector('.choice-pizza2').addEventListener('click', function(e){
	    	if(e.target && e.target.tagName==="SPAN"){
	    		let _span = e.target;
				if(_span.classList.contains("selected")){
					return;
				}
	    		if(document.querySelector('.choice-pizza2 span.selected')){
	    			document.querySelector('.choice-pizza2 span.selected').classList.remove('selected');
	    		}
	    		_span.classList.add('selected');
	    		let _request = document.querySelector('.menu-request');
				let _id = _span.dataset.id;
				let _price = _span.dataset.price;
				let _text = _span.textContent;
				let _totalPrice = document.querySelector('#totalPrice');
				if(document.querySelector('.menu-request p.pizza2')){
					_totalPrice.dataset.total = Number(_totalPrice.dataset.total) - Number(document.querySelector('.menu-request p.pizza2').dataset.price);
					document.querySelector('.menu-request p.pizza2').remove();
				}
				let _content = "<p class='pizza2' data-id='" + _id + "' data-price='" + _price + "'><span>+ " + _text + "</span><b>" + moneyComma(_price) + "</b></p> ";
				_request.insertAdjacentHTML("beforeend", _content);
				_totalPrice.dataset.total = Number(_totalPrice.dataset.total) + Number(_price);
				_totalPrice.textContent = moneyComma(_totalPrice.dataset.total);
	    	}
	    });
		document.querySelector('.choice-option').addEventListener('click', function(e){
			if(e.target && e.target.tagName==="SPAN"){
				let _span = e.target;
				_span.classList.toggle('selected');
				let _id = _span.dataset.id;
				let _price = _span.dataset.price;
				let _totalPrice = document.querySelector('#totalPrice');
				if(_span.classList.contains('selected')){
					let _text = _span.textContent;
					let _request = document.querySelector('.menu-request');
					let _content = "<p data-id='" + _id + "' data-price='" + _price + "'><span>+ " + _text + "</span><b>" + moneyComma(_price) + "</b></p> ";
					_request.insertAdjacentHTML("beforeend", _content);
					_totalPrice.dataset.total = Number(_totalPrice.dataset.total) + Number(_price);
				}else{
					let _request = document.querySelectorAll('.menu-request p');
					_request.forEach(function(e) {
						if(e.dataset.id === _id){
							e.remove();
							_totalPrice.dataset.total = Number(_totalPrice.dataset.total) - Number(_price);
						}
					});
				}
				_totalPrice.textContent = moneyComma(_totalPrice.dataset.total);
			}
		});
		function moneyComma(val){
			return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + " 원";
		}
		document.querySelector('#cartBtn').addEventListener('click', function(){
			if(!document.querySelector('.menu-request p.pizza1') || !document.querySelector('.menu-request p.pizza2')){
				alert("피자를 선택해주세요.");return;
			}
			let cookieName = "cart";
			let name = "cart";
			
			let data = null;
	    	if(getCookie(cookieName) !== null && getCookie(cookieName) !== '' ){
	    		data = JSON.parse((decodeURIComponent(getCookie(cookieName))).replace('path=/halfPizza', ''));
			}else{
				data = { cartWrap : [] };
			}
			
	    	if(data.cartWrap.length !== 0){
				let i = 0;
				for(i = 0; i < 5; i++){
					if(data.cartWrap[i] === undefined || data.cartWrap[i] !== name + i ){
						name = name + i;
						break;
					}
				}
				if(i > 4){
					alert("최대 5개까지 장바구니에 추가하실 수 있습니다."); return;
				}
			}

			let _option = document.querySelectorAll('.menu-request p');
			let optionArray = [];
			for(let i = 0; i < _option.length; i++){
				let content = {
					id : _option[i].dataset.id,
					price : _option[i].dataset.price,
					text : _option[i].children[0].textContent
				}
				optionArray.push(content);
			}
			let _menu = document.querySelector('.menu-request h4');
			let _total = document.querySelector('#totalPrice');
			let request = {
				name : name,
				menu : {
					id : _menu.dataset.id,
					title : _menu.dataset.title,
					price : _menu.dataset.price,
					src : "${pageContext.request.contextPath}${menu.path}${menu.changeFileName1}"
				},
				option : optionArray,
				totalPrice : _total.dataset.total,
				count : 1
			}
			data.cartWrap.push(request);
			console.log(data);
			SetCookie(cookieName , JSON.stringify(data), null);
		});
		function SetCookie( strName, strValue, iSecond )
		{
			var strCookie = strName + "=" + encodeURIComponent(strValue);
			strCookie += "path=/halfPizza";
			if( typeof iSecond === "number" )
			{
				strCookie += "; max-age=" + iSecond;
			}
			strCookie += "; path=/halfPizza";
			document.cookie = strCookie;
			let num = document.querySelector("#cartNum").textContent === "" ? 0 : Number(document.querySelector("#cartNum").textContent);
			document.querySelector("#cartNum").textContent = num + 1;
			if(confirm("장바구니에 제품이 담겼습니다.\n장바구니로 이동하시겠습니까?")){
				location.href="/halfPizza/order/cart";
			}
		}
		function getCookie(name) {
			  var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
			  return value? value[2] : null;
		}
    </script>


<%@ include file="../layouts/footer.jsp" %>
</body>
</html>