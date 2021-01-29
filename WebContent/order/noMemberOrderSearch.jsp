<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp" %>
    <main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>비회원 주문조회</span></h3>
            </div>
            <form method="GET" action="${pageContext.request.contextPath}/order/noMemberOrderSearchProc" onSubmit="return valid();">
            	<div class="non-member-order">
	                <h3>비회원 주문 이력을 조회합니다.(금일만 가능)</h3>
	                <p>주문내역 변경 및 취소는 고객센터로 문의주시기 바랍니다.</p>
	                <div class="non-member-phone">
	                    <span>휴대폰번호</span>
	                    <input type="text" placeholder="전화번호를 입력해주세요" id="phone" name="phone" required />
	                </div>
	                <button type="submit">조회하기</button>
	            </div>
            </form>
        </div>
    </main>
    <script>
    	function valid(){
        	let phone = (document.querySelector('#phone').value).replace(/[^0-9]/g,'');
        	console.log(phone.length);
        	if(phone.length !== 11){
            	alert('휴대폰번호를 확인해주세요.'); return false;
           	}
        	return true;
        }
        document.querySelector('#phone').addEventListener("blur", function(){
			let val = this.value;
			this.value = val.substr(0,3) + '-' + val.substr(3,4) + '-' + val.substr(7);
		});
		
		document.querySelector('#phone').addEventListener("focus", function(){
			this.value = this.value.replace(/[^0-9]/g,'');
		});
    </script>
<%@ include file="../layouts/footer.jsp" %>
	
</body>
</html>