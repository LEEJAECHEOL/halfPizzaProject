<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../layouts/adminHeader.jsp"%>
<main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>이벤트 등록하기</span></h3>
            </div>
            <div class="event-add">
                <h3>이벤트 추가</h3>
                <form action="/halfPizza/admin/event/registProc" method="post" enctype="multipart/form-data">
                    <div class="event-add-image">
                        <span>썸네일</span>
                        <input type="file" name="previewImg" required>
                        <input type="hidden" name="gubun" value="prev">
                    </div>
                    <div class="event-add-title">
                        <span>제목</span>
                        <input type="text" name="title" required>
                    </div>
                    <div class="event-add-content">
                        <span>내용 이미지</span>
                        <input type="hidden" name="gubun" value="content" required>
                        <input type="file" name="contentImg">
                    </div>
                    <div class="event-add-fromDate">
                        <span>시작일</span>
                        <input type="date" name="fromDate" required>
                    </div>
                    <div class="event-add-toDate">
                        <span>종료일</span>
                        <input type="date" name="toDate" required>
                    </div>
                    <button>저장</button>
                </form>
            </div>
        </div>
    </main>
</body>

</html>