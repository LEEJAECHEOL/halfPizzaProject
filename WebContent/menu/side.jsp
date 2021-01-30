<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp" %>

	<main>
<div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>메뉴</span></h3>
            </div>
            <div class="menu-list">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/menu">피자</a></li>
                    <li><a href="${pageContext.request.contextPath}/menu?gubun=oneplus">1+1</a></li>
                    <li><a href="${pageContext.request.contextPath}/menu?gubun=set">세트</a></li>
                    <li><a href="${pageContext.request.contextPath}/menu?gubun=side" class="selected">사이드</a></li>
                </ul>
            </div>
            <div class="pizza-list">
            	<c:choose>
				  	<c:when test="${menu!=null}">
						<c:forEach var="m" items="${menu}">
			                <div class="pizza-item">
			                    <a href="${pageContext.request.contextPath}/menu/menuView?id=${m.id}">
			                        <img src="${pageContext.request.contextPath}${m.path}${m.changeFileName1}" alt="">
			                        <h3>${m.title }</h3>
			                        <p>
			                        	<c:if test="${m.isR eq 1}">
			                        		<strong>R</strong><span><fmt:formatNumber value="${m.price - 2000 }" pattern="#,###" />원</span>	
			                        	</c:if>
				                        <strong>L</strong><span><fmt:formatNumber value="${m.price }" pattern="#,###" />원</span>
			                        </p>
			                    </a>
			                </div>
						</c:forEach>
				  	</c:when>
				  	<c:otherwise>
				  		<h3>등록된 메뉴가 없습니다.</h3>
				  	</c:otherwise>
			  	</c:choose>
            </div>
        </div>
    </main>

<%@ include file="../layouts/footer.jsp" %>
</body>
</html>