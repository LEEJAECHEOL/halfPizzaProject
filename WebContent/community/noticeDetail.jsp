<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp"%>
</body>
	<main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>공지사항</span></h3>
            </div>
            <div class="event-detail-top">
                <span>${dto.title}</span>
                <b>${dto.createDate}</b>
            </div>
            <div class="event-detail-bottom">
            	${dto.content}
            </div>
            <button class="btn-blue" type="button" onclick="list()">목록</button>
        </div>
    </main>

   	<script>
		function list(){
			location.href = "/halfPizza/community/event"
		}
   	</script>
<%@ include file="../layouts/footer.jsp"%>
</html>