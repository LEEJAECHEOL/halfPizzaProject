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
    
    <script defer src="${pageContext.request.contextPath}/js/pop.js" charset="utf-8"></script>
   	
</head>

<body>
    <header>

    <!--배송정보입력-->
        <div class="top-fix">
            <div class="container">
                <div class="address">
                    <img src="${pageContext.request.contextPath}/images/common/ico_gnb_location.png" alt="">
                    <a href="#a">배송정보를 입력해 주세요</a>
                </div>
                <c:choose>
				  	<c:when test="${sessionScope.user!=null}">
				  		<div class="login">
				  			<span>${sessionScope.user.name}님 환영합니다.</span>
				  			<c:if test="${sessionScope.user.role eq 'ADMIN'}">
				  				<a href="${pageContext.request.contextPath}/admin">관리페이지</a>
				  			</c:if>
				  			<a href="">마이페이지</a>
				  			<a href="${pageContext.request.contextPath}/auth/logout">로그아웃</a>
		                    <a href="#a" class="cart"><img src="${pageContext.request.contextPath}/images/common/ico_common_cart.png" alt=""></a>
		                </div>
				  	
				  	</c:when>
				  	<c:otherwise>
		                <div class="login">
		                    <a href="${pageContext.request.contextPath}/auth/login">로그인</a>
		                    <a href="#a" class="cart"><img src="${pageContext.request.contextPath}/images/common/ico_common_cart.png" alt=""></a>
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
                        <a href="#a">이벤트</a>
                        <a href="#a">공지사항</a>
                        <a href="#a">FAQ</a>
                        <a href="#a">고객의 소리</a>
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