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
		<div class="notice-add">
			<form
				action="${pageContext.request.contextPath}/admin/notice/registProc"
				method="post">
				<div class="notice-add-title">
					<span>제목</span> <input type="text" name="title" required>
				</div>
				<label>내용 : </label> <br /><br />
				<textarea name="content" id="content"></textarea>
				<button type="submit" class="notic">저장</button>
			</form>
		</div>
		<script>
			$(document).ready(function() {
				$('#content').summernote({
					height: 400,
					lang: "ko-KR",
					callbacks: {	//여기 부분이 이미지를 첨부하는 부분
						onImageUpload : function(files) {
							uploadSummernoteImageFile(files[0], this);
						},
						onPaste: function (e) {
							var clipboardData = e.originalEvent.clipboardData;
							if (clipboardData && clipboardData.items && clipboardData.items.length) {
								var item = clipboardData.items[0];
								if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
									e.preventDefault();
								}
							}
						}
					}
				});
			});
			function uploadSummernoteImageFile(file, editor) {
				data = new FormData();
				data.append("file", file);
				$.ajax({
					data : data,
					type : "POST",
					url : "/halfPizza/summer/fileupload",
					contentType : false,
					processData : false,
					dataType : "json",
					success : function(data) {
		            	//항상 업로드된 파일의 url이 있어야 한다.
		            	console.log(data.url);
						$(editor).summernote('insertImage', data.url);
					}
				});
			}
    	</script>

	</div>
</main>
</body>
</html>