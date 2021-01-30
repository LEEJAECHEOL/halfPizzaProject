<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스토어찾기</title>
</head>
<body>
	<main>
		<div class="list">
			<c:choose>
				<c:when test="${dto!=null}">
					<c:forEach var="item" items="${dto}">
						<div data-tel=${item.tel }>
							${item.addr} (${item.name})
						</div>
		
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h3>등록된 스토어가 없습니다.</h3>
				</c:otherwise>
			</c:choose>
		</div>
	</main>
	<script type="text/javascript">
		document.querySelector(".list").addEventListener('click',function(e){
			let select = e.target;
			console.log(e);
			let addr = select.innerText;
			let tel = select.dataset.tel;
			if(confirm("지점을 선택하시겠습니까?")){
				opener.document.getElementById("storeAddr").value = addr;
				opener.document.getElementById("storeTel").value = tel;
				window.close();
			}
		});

	</script>
</body>
</html>