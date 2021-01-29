<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp" %>

	<main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>주문내역</span></h3>
            </div>
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
				                    <button class="open3"><span>상세</span>
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
</body>
</html>