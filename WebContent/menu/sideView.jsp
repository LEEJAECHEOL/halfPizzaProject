<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp" %>
	<main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>주문하기</span></h3>
            </div>

            <div class="choice-menu-detail side">
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
                        	<c:if test="${menu.isR eq 1}">
                        		<span>R</span><b><fmt:formatNumber value="${menu.price - 2000 }" pattern="#,###" />원</b>	
                        	</c:if>
	                        <b><fmt:formatNumber value="${menu.price }" pattern="#,###" />원</b>
                        </h5>
                    </div>
                    <div class="choice-menu-detail-left-middle">
                       <h4>1인분 제공량</h4>
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
                                <td>150g</td>
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
            </div>
        </div>
    </main>
    
    <script>
		function moneyComma(val){
			return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + " 원";
		}
		document.querySelector('#cartBtn').addEventListener('click', function(){
			
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