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
                    <li><a href="${pageContext.request.contextPath}/auth/myPage" class="selected">주문내역</a></li>
                    <li><a href="${pageContext.request.contextPath}/auth/myCoupon">쿠폰함</a></li>
                    <li><a href="${pageContext.request.contextPath}/auth/myStamp">스탬프</a></li>
                    <li><a href="${pageContext.request.contextPath}/auth/updateChk">개인정보수정</a></li>
                </ul>
            </div>
            ${request.date }
            <form action="" method="get">
	            <div class="order-lookup">
	            	<input type="hidden" name="id" value="${sessionScope.user.id}">
	                <h3>주문내역 변경 전 취소는 고객센터로 문의주시기 바랍니다.</h3>
	                <span>기간 선택</span>
	                <input type="date" name="date" value="${param.date }" required>
	                <button>주문조회</button>
	            </div>
            </form>
            <div class="order-info-wrap">
            	<c:choose>
				  	<c:when test="${dto!=null}">
						<c:forEach var="list" items="${dto}">
							 <div class="order-info">
				                <h3>주문번호 ${list.id }</h3>
				                <div class="order-info-detail">
				                    <table width="80%">
				                        <colgroup>
				                            <col width="30%">
				                            <col width="30%">
				                            <col width="30%">
				                        </colgroup>
				                        <tr>
				                            <th>주문일자</th>
				                            <th>요구사항</th>
				                            <th>결제금액</th>
				                        </tr>
				                        <tr>
				                            <td>${list.createDate }</td>
				                            <td>${list.text }</td>
				                            <td><fmt:formatNumber value="${list.paidAmount}" pattern="#,###" />원</td>
				                        </tr>
				                    </table>
				                    <button class="open3" type="button" onclick="detailBtn('${list.id}')"><span>상세</span>
				                        <p>보기</p>
				                    </button>
				                </div>
				            </div>
						</c:forEach>
				  	</c:when>
				  	<c:otherwise>
				  		<h3>주문내역이 없습니다.</h3>
				  	</c:otherwise>
			  	</c:choose>
            </div>
        </div>
        <br>
    </main>
    
    <%@ include file="../layouts/footer.jsp" %>
    
    <div class="popup3">
		<div class="pop3-info">
	        <span>매장정보</span>
	        <h4 id="popAddr"></h4>
	    </div>
	    <div class="pop3-info">
	        <span>주문날짜</span>
	        <h4 id="popDate"></h4>
	    </div>
	    <div class="pop3-info">
	        <span>주문번호</span>
	        <h4 id="popId"></h4>
	    </div>
	    <div class="pop3-pizza-info">
	        <table width="100%" id="popMenu">
	        </table>
	        <p><span>할인</span><b>0</b></p>
	        <p><span>최종결제금액</span><strong id="totalPrice"></strong></p>
	    </div>
	    <div class="delivery-shop">
	        <div class="delivery-shop-info">
	            <span>매장주소</span>
	            <p id="storeAddr"></p>
	        </div>
	        <div class="delivery-shop-info">
	            <span>전화번호</span>
	            <p id="storeTel"></p>
	        </div>
	        <div class="delivery-shop-info">
	            <span>요청사항</span>
	            <p id="popText"></p>
	        </div>
	    </div>
	    <div class="btn-group">
	        <button class="close3">확인</button>
	    </div>
    </div>
    <div class="dim"></div>
<script>
	function detailBtn(id){
		$.ajax({
            type : "GET",
            url : "http://localhost:8000/halfPizza/order/findDetail?id=" + id,
            dataType:"json"
         })
         .done(function(result){
	        document.querySelector('#popAddr').textContent = result.data.addr;
	        document.querySelector('#popDate').textContent = result.data.createDate;
	        document.querySelector('#popId').textContent = result.data.id;
	        document.querySelector('#totalPrice').textContent = result.data.paidAmount+"원";
	        document.querySelector('#popText').textContent = result.data.text;
	        document.querySelector('#storeAddr').textContent = result.data.storeAddr;
	        document.querySelector('#storeTel').textContent = result.data.storeTel;
			let info = JSON.parse(result.data.info);
	        let content = "<colgroup><col width='50%'><col width='15%'><col width='35%'></colgroup>";
	        for(let i = 0; i < info.cartWrap.length; i++){
		        content += "<tr>";
	        	content += "<td>" + info.cartWrap[i].menu.title +"</td>";
	        	content += "<td> x" + info.cartWrap[i].count +"</td>";
	        	content += "<td>" + info.cartWrap[i].menu.price +"원</td>";
	        	content += "</tr>"
		        content += "<tr>";
	        	content += "<td>" + info.cartWrap[i].size.text +"</td>";
	        	content += "<td></td>";
	        	content += "<td>" + info.cartWrap[i].size.price +"원</td>";
	        	content += "</tr>"
		       	for(let j = 0; j < info.cartWrap[i].option.length; j++){
			        content += "<tr>";
		        	content += "<td>" + info.cartWrap[i].option[j].text +"</td>";
		        	content += "<td></td>";
		        	content += "<td>" + info.cartWrap[i].option[j].price +"원</td>";
		        	content += "</tr>"
	       		}
	        }
	        document.querySelector('#popMenu').innerHTML = content;
         });
			
		
	}
</script>
</body>

</html>