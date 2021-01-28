<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp" %>
	<main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>주문완료</span></h3>
            </div>
            <div class="subpage-box">
                <div class="order-success-box">
                    <img src="../images/common/ico_gnb_menu1.png" alt="">
                    <div class="success-complete">
                        <h4>주문이 완료되었습니다.</h4>
                        <p>주문내역 변경이나 취소는 고객센터를 통해 가능합니다.</p>
                    </div>
                    <div class="success-complete-button">
                        <button class="btn-gray" type="button" onclick="home()">메인으로</button>
                        <button class="btn-blue" type="button" onClick="orderlist()">주문내역확인</button>
                    </div>
                </div>
            </div>
        </div>
        <br>
    </main>
    <script>
		function home(){
			location.href="/halfPizza/";
		}
		function orderlist(){

		}
    </script>
<%@ include file="../layouts/footer.jsp" %>
	
</body>
</html>