<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/adminHeader.jsp" %>
    <main>
        <div class="container">
        
        <div class="sub-p-title">
			<h3 class="underLine">
				<span>회원 리스트</span>
			</h3>
		</div>
            <div class="index-table-top">
                <table width="100%">
                    <colgroup>
                        <col width="5%">
                        <col width="10%">
                        <col width="10%">
                        <col width="10%">
                        <col width="10%">
                        <col width="15%">
                        <col width="10%">
                        <col width="8%">
                        <col>
                    </colgroup>
                    <tr>
                        <th>No.</th>
                        <th>아이디</th>
                        <th>성함</th>
                        <th>생년월일</th>
                        <th>전화번호</th>
                        <th>이메일</th>
                        <th>권한</th>
                        <th>회원가입일자</th>
                    </tr>
                    <c:choose>
					<c:when test="${users!=null}">
						<c:forEach var="u" items="${users}">
                    <tr>
                        <td>${u.id}</td>
                        <td>${u.username}</td>
                        <td>${u.name}</td>
                        <td>${u.birth}</td>
                        <td>${u.phone}</td>
                        <td>${u.email}</td>
                        <td>${u.role}</td>
                        <td>${u.createDate}</td>
                    </tr>
                    	</c:forEach>
					</c:when>
					<c:otherwise>
						<h3>등록된 회원이 없습니다.</h3>
					</c:otherwise>
				</c:choose>
                </table>
            </div>
        </div>

    </main>
</body>

</html>