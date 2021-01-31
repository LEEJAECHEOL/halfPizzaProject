<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../layouts/adminHeader.jsp"%>
<main>
	<div class="container">
		<div class="sub-p-title">
			<h3 class="underLine">
				<span>주문리스트</span>
			</h3>
		</div>

		<div class="order-list">
			<table width="100%">
				<colgroup>
					<col width="10%">
					<col width="10%">
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col>
				</colgroup>
				<tr>
					<th>No.</th>
					<th>성함</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>가격</th>
					<th>상태</th>
					<th>주문시간</th>
				</tr>
				<c:choose>
					<c:when test="${orders!=null}">
						<c:forEach var="o" items="${orders}">
							<tr>
								<td>${o.id}</td>
								<td>${o.name}</td>
								<td>${o.phone}</td>
								<td>${o.addr}</td>
								<td>${o.paidAmount}</td>
								<td>${o.state}</td>
								<td>${o.createDate}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<h3>등록된 메뉴가 없습니다.</h3>
					</c:otherwise>
				</c:choose>
			</table>

		</div>
	</div>
</main>
</body>

</html>