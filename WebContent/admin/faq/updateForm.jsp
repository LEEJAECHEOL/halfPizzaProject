<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../layouts/adminHeader.jsp"%>
 <main>
<div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>FAQ 등록하기</span></h3>
            </div>

            <div class="faq-add">
                <h3>FAQ추가</h3>
                <form action="${pageContext.request.contextPath}/admin/faq/updateProc" method="post">
                   <p>아이디 : ${dto.id}</p>
		           <input type="hidden" name="id" value="${dto.id}">
                    <select name="gubun">
                        <option value="계정 관련">계정 관련</option>
                        <option value="배달관련">배달관련</option>
                        <option value="스탬프 적립 관련">스탬프 적립 관련</option>
                        <option value="온라인주문 관련">온라인주문 관련</option>
                        <option value="주문확인/취소">주문확인/취소</option>
                        <option value="포장주문 관련">포장주문 관련</option>
                        <option value="할인정책 관련">할인정책 관련</option>
                    </select>
                    <div class="faq-add-title">
                        <span>제목 : </span>
                        <input type="text" name="title" value="${dto.title}">
                    </div>
                    <div class="faq-add-content">
                        <span>답변 : </span>
                        <textarea name="content" rows="3" cols="">${dto.content}</textarea>
                    </div>
                    <button>저장</button>
                </form>
            </div>
        </div>
    </main>
</body>

</html>