<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp"%>
	<main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>이벤트</span></h3>
            </div>
            <div class="event-detail-top">
                <span>${dto.title}</span>
                <b>${dto.fromDate} ~ ${dto.toDate}</b>
            </div>
            <div class="event-detail-bottom">
                <a href="#a">
                    <img src="${pageContext.request.contextPath}${dto.path}${dto.changeFileName2}" alt=""></a>
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
</body>

</html>