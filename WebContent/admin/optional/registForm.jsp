<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../layouts/adminHeader.jsp"%>
    <main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>옵션 등록하기</span></h3>
            </div>
            <div class="option-add">
                <h3>옵션추가</h3>
                <form action="${pageContext.request.contextPath}/admin/optional/registProc" method="post">
                    <div class="option-add-title">
                        <span>상품명</span>
                        <input type="text" name="title">
                    </div>
                    <div class="option-add-price">
                        <span>가격</span>
                        <input type="text" name="price">
                    </div>
                    <button>저장</button>
                </form>
            </div>
        </div>
    </main>
</body>

</html>

