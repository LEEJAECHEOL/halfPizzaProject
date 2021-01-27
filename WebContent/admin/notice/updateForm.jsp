<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	 <script src="https://cdn.ckeditor.com/ckeditor5/24.0.0/classic/ckeditor.js"></script>
</head>
<body>
	<form
		action="${pageContext.request.contextPath}/admin/notice/updateProc"
		method="post">
		<p>게시물id : ${dto.id}</p>
		<input type="hidden" name="id" value="${dto.id}">
		<label>제목 : </label><input type="text" name="title" value="${dto.title}"> 
		<label>내용
			: </label> <br>
		<textarea name="content" id=content cols="30" rows="10">${dto.content}</textarea>
		<button>저장</button>
	</form>
	
    <script>
        ClassicEditor
            .create( document.querySelector( '#content' ) )
            .catch( error => {
                console.error( error );
            } );
    </script>


</body>
</html>