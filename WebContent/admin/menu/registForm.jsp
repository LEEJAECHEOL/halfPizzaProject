<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../layouts/adminHeader.jsp" %>
    <main>
        <div class="container">
           <div class="sub-p-title">
                <h3 class="underLine"><span>메뉴 등록하기</span></h3>
            </div>
            <div class="menu-add">
                <h3>메뉴추가</h3>
                <form action="${pageContext.request.contextPath}/admin/menu/registProc" method="post" enctype="multipart/form-data">
                    <div class="menu-add-image">
                        <span>상품 이미지</span>
                        <input type="file" name="file" onchange="setThumbnail(event);">
                    </div>
                    <div id="image_container"></div>
                    <div class="menu-add-title">
                        <span>상품명</span>
                        <input type="text" name="title">
                    </div>
                    <div class="menu-add-price">
                        <span>가격</span>
                        <input type="text" name="price">
                    </div>
                    <div class="menu-add-content">
                        <span>상품 설명</span>
                        <textarea name="content" id="" cols="30" rows="10"></textarea>
                    </div>
                    <div class="menu-add-regular">
                        <span>사이즈 R 여부</span>
                        <input type="checkbox" name="isR" value="1" />
                    </div>
                    <div class="menu-add-gubun">
                       <span>메뉴 구분</span>
                        <select name="gubun">
                            <option value="pizza">피자</option>
                            <option value="set">세트</option>
                            <option value="side">사이드</option>
                        </select>
                    </div>
                    <button>저장</button>
                </form>
            </div>
        </div>
    </main>
    
	<script> 
		function setThumbnail(event) { 
			var reader = new FileReader(); 
			reader.onload = function(event) { 
				var img = document.createElement("img"); 
				img.setAttribute("src", event.target.result); 
				document.querySelector("div#image_container").appendChild(img);
				document.querySelector("div#image_container").style.height="300px"; 
			}; 
			reader.readAsDataURL(event.target.files[0]); 
		} 
	</script>

</body>

</html>