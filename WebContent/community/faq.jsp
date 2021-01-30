<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp"%>

<main>
	<div class="container">
		<div class="sub-p-title">
			<h3 class="underLine">
				<span>FAQ</span>
			</h3>
		</div>

		<form action="" class="search-box faq">
			<select name="faq-category" id="">
				<option value="">전체보기</option>
				<option value="">배달관련</option>
				<option value="">포장주문 관련</option>
				<option value="">온라인주문 관련</option>
				<option value="">계정관련</option>
				<option value="">매장관련</option>
				<option value="">주문확인/취소</option>
				<option value="">할인정책 관련</option>
				<option value="">스탬프 적립 관련</option>
			</select>
			<div>
				<input type="text" placeholder="검색할 내용을 입력해주세요">
				<button type="submit">
					<i class="xi-search"></i>
				</button>
			</div>
		</form>

		<div class="notice-box">

			<c:choose>
				<c:when test="${faqs!=null}">
					<c:forEach var="f" items="${faqs}">
						<div class="faq-item">
							<a href="#a">
								<h3>
									<i class="xi-search"></i>[${f.gubun}]${f.title}
								</h3> <i class="xi-angle-down"></i>
							</a>
							<p>
								<b>A</b>${f.content}
							</p>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h3>등록된 FAQ가 없습니다.</h3>
				</c:otherwise>
			</c:choose>


			<button class="notice-more" id="faqMore">더보기+</button>
		</div>
	</div>
</main>
<%@ include file="../layouts/footer.jsp"%>
<script>
        var faq = document.querySelectorAll('.faq-item');
        faq.forEach((item)=>{
            item.addEventListener('click', function(){
                this.classList.toggle('full');
            });
        });

		let count = 1;
			
        document.querySelector('#faqMore').addEventListener('click', function(){
			$.ajax({
				type : "GET",
				url : "http://localhost:8000/halfPizza/community/faqMore?count=" + count,
				contentType : "application/json;charset=utf-8",
				dataType:"json"
			})
			.done(function(result){
				if(result.statusCode == 1){
					alert("성공");
				}
				else{
					alert("불러오기 실패");
				}
			});
		});
  
    </script>
</body>

</html>