<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../layouts/adminHeader.jsp"%>
<main>
	<div class="container">
		<div class="sub-p-title">
			<h3 class="underLine">
				<span>공지사항 등록하기</span>
			</h3>
		</div>
		<div class="event-add">
			<form
				action="${pageContext.request.contextPath}/admin/notice/registProc"
				method="post">
				<div class="notice-add-title">
					<span>제목</span> <input type="text" name="title" required>
				</div>
				<label>내용 : </label> <br>
				<textarea name="content" id=content cols="30" rows="10" style="height:500px;"></textarea>
				<button>저장</button>
			</form>
		</div>
		<script>
        ClassicEditor
            .create( document.querySelector( '#content' ),{
            	ckfinder: {
        			uploadUrl: '/halfPizza/ck/fileupload'
        		},
    			alignment: {
    	            options: [ 'left', 'right', 'center' ]
    	        },
    	        
             })
            .catch( error => {
                console.error( error );
            } );
    </script>

	</div>
</main>
</body>
</html>