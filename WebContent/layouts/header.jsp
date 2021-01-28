<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>반올림피자</title>

    <!--Fontawesome & xeicon-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <link rel="stylesheet" href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css" />
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"  />
	<style>
	     <%@ include file="../css/style.css"%>
	</style>
    <!--jQuery-->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

    <!--slick-->
    <link rel="stylesheet" type="text/css" href="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
    <script type="text/javascript" src="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    
    <script>
	    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	    function searchJuso() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var roadAddr = data.roadAddress; // 도로명 주소 변수
	                var extraRoadAddr = ''; // 참고 항목 변수
	
	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraRoadAddr !== ''){
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('sample4_postcode').value = data.zonecode;
	                document.getElementById("sample4_roadAddress").value = roadAddr;
	                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
	                
	                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
	                if(roadAddr !== ''){
	                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
	                } else {
	                    document.getElementById("sample4_extraAddress").value = '';
	                }
	
	                var guideTextBox = document.getElementById("guide");
	                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
	                if(data.autoRoadAddress) {
	                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
	                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
	                    guideTextBox.style.display = 'block';
	
	                } else if(data.autoJibunAddress) {
	                    var expJibunAddr = data.autoJibunAddress;
	                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
	                    guideTextBox.style.display = 'block';
	                } else {
	                    guideTextBox.innerHTML = '';
	                    guideTextBox.style.display = 'none';
	                }
	            }
	        }).open();
	    }
	</script>
    <script defer src="${pageContext.request.contextPath}/js/pop.js" charset="utf-8"></script>
   	
</head>

<body>
    <header>

    <!--배송정보입력-->
        <div class="top-fix">
            <div class="container">
                <div class="address">
                    <a href="${pageContext.request.contextPath}/delivery"><img src="${pageContext.request.contextPath}/images/common/ico_gnb_location.png" alt=""><span>배송정보를 입력해 주세요</span></a>
                </div>
                <c:choose>
				  	<c:when test="${sessionScope.user!=null}">
				  		<div class="login">
				  			<span>${sessionScope.user.name}님 환영합니다.</span>
				  			<c:if test="${sessionScope.user.role eq 'ADMIN'}">
				  				<a href="${pageContext.request.contextPath}/admin">관리페이지</a>
				  			</c:if>
				  			<a href="${pageContext.request.contextPath}/auth/myPage?id=${user.id}">마이페이지</a>
				  			<a href="${pageContext.request.contextPath}/auth/logout">로그아웃</a>
		                    <a href="#a" class="cart"><img src="${pageContext.request.contextPath}/images/common/ico_common_cart.png" alt=""></a>
		                </div>
				  	
				  	</c:when>
				  	<c:otherwise>
		                <div class="login">
		                    <a href="${pageContext.request.contextPath}/auth/login">로그인</a>
		                    <a href="${pageContext.request.contextPath}/cart" class="cart">
		                    <img src="${pageContext.request.contextPath}/images/common/ico_common_cart.png" alt=""><b id="cartNum">${cartCount == 0 ? '' : cartCount }</b>
		                    </a>
		                </div>
				  	</c:otherwise>
				  </c:choose>
            </div>
        </div>
    <!--네비게이션-->
        <nav class="nav-list">
            <ul class="main-menu">
                <div class="container">
                    <a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/images/common/img_logo.png" alt=""></a>
                    <li class="nav-item"><a href="#a">메뉴</a></li>
                    <li class="nav-item"><a href="#a">E쿠폰</a></li>
                    <li class="nav-item"><a href="#a">스토어</a></li>
                    <li class="nav-item"><a href="#a">커뮤니티</a></li>
                    <li class="nav-item"><a href="#a">프랜차이즈</a></li>
                    <li class="nav-item"><a href="#a">브랜드</a></li>
                </div>
                <ul class="detail-menu">
                <div class="container">
                    <li>
                        <img src="${pageContext.request.contextPath}/images/common/ico_gnb_menu1.png" alt="">
                        <h3>메뉴</h3>
                        <a href="${pageContext.request.contextPath}/menu">피자</a>
                        <a href="#a">1+1</a>
                        <a href="#a">세트</a>
                        <a href="#a">사이드</a>
                    </li>
                    <li>
                        <img src="${pageContext.request.contextPath}/images/common/ico_gnb_menu2.png" alt="">
                        <h3>E쿠폰</h3>
                        <a href="#a">E쿠폰주문</a>
                    </li>
                    <li>
                        <img src="${pageContext.request.contextPath}/images/common/ico_gnb_menu3.png" alt="">
                        <h3>스토어</h3>
                        <a href="#a">매장찾기</a>
                    </li>
                    <li>
                        <img src="${pageContext.request.contextPath}/images/common/ico_gnb_menu4.png" alt="">
                        <h3>커뮤니티</h3>
                        <a href="${pageContext.request.contextPath}/community/event">이벤트</a>
                        <a href="${pageContext.request.contextPath}/community/notice">공지사항</a>
                        <a href="${pageContext.request.contextPath}/community/faq">FAQ</a>
                        <a href="${pageContext.request.contextPath}/community/contact">고객의 소리</a>
                        <a href="#a">채용하기</a>
                    </li>
                    <li>
                        <img src="${pageContext.request.contextPath}/images/common/ico_gnb_menu5.png" alt="">
                        <h3>프렌차이즈</h3>
                        <a href="#a">창업지원시스템</a>
                        <a href="#a">창업문의</a>
                    </li>
                    <li>
                        <img src="${pageContext.request.contextPath}/images/common/ico_gnb_menu6.png" alt="">
                        <h3>브랜드</h3>
                        <a href="#a">회사소개</a>
                        <a href="#a">BI</a>
                    </li>
                </div>
            </ul>
            </ul>
        </nav>
    </header>