<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>관리자페이지</title>

    <!--공통css-->
    <style>
    	<%@ include file="../css/admin.css"%>
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
    <header>
        <div class="container">
            <h3><img src="../images/common/img_logo.png" alt="">Ad<span>min</span></h3>
            <nav>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/admin/menu/list">메뉴관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/optional">추가선택관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/notice/list">공지사항관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/faq/list">FAQ관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/event/list">이벤트관리</a></li>
                    <li><a href="#a">판매량</a></li>
                </ul>
            </nav>
        </div>
    </header>