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

		<div class="search-box faq">
			<select name="gubun" id="gubun">
				<option value="">전체보기</option>
                <option value="계정 관련">계정 관련</option>
                <option value="배달관련">배달관련</option>
                <option value="스탬프 적립 관련">스탬프 적립 관련</option>
                <option value="온라인주문 관련">온라인주문 관련</option>
                <option value="주문확인/취소">주문확인/취소</option>
                <option value="포장주문 관련">포장주문 관련</option>
                <option value="할인정책 관련">할인정책 관련</option>
			</select>
			<div>
				<input type="text" id="keyword" name="keyword" placeholder="검색할 내용을 입력해주세요">
				<button type="button" class="searchBtn">
					<i class="xi-search"></i>
				</button>
			</div>
		</div>

		<div class="notice-box">
			<div>
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
			</div>
			<button class="notice-more" id="faqMore">더보기+</button>
		</div>
	</div>
</main>
<script>
	let page = 1;
	document.querySelector('.notice-more').addEventListener('click', function(){
		let _gubun = document.querySelector('#gubun').value;
		let _keyword = document.querySelector('#keyword').value;
		$.ajax({
			type : "GET",
			url : "/halfPizza/community/faq/more?page=" + page + "&gubun=" + _gubun + "&keyword=" + _keyword,
			dataType:"json"
		})
		.done(function(result){
			if(result.statusCode === 200){
				if(result.data.length !== 0){
					let content = "";
					for(let i = 0; i < result.data.length; i++){
						content += "<div class='faq-item'><a href='#a'><h3><i class='xi-search'></i>";
						content += "[" + result.data[i].gubun + "] " + result.data[i].title;
						content += "</h3><i class='xi-angle-down'></i></a><p>";
						content += "<b>A</b>" + result.data[i].content;
						content += "</p></div>";
					}
					document.querySelector(".notice-box div").insertAdjacentHTML("beforeend", content);
					dropdown();
					page++;
				}else{
					alert("마지막 페이지입니다.");
				}
			}else {
				alert("잘못된 요청입니다.");
			}
		});
	});
	document.querySelector('.searchBtn').addEventListener('click', function(){
		let _gubun = document.querySelector('#gubun').value;
		let _keyword = document.querySelector('#keyword').value;
		page = 0;
		$.ajax({
			type : "GET",
			url : "/halfPizza/community/faq/more?page=" + page + "&gubun=" + _gubun + "&keyword=" + _keyword,
			dataType:"json"
		})
		.done(function(result){
			if(result.statusCode === 200){
				if(result.data.length !== 0){
					let content = "";
					for(let i = 0; i < result.data.length; i++){
						content += "<div class='faq-item'><a href='#a'><h3><i class='xi-search'></i>";
						content += "[" + result.data[i].gubun + "] " + result.data[i].title;
						content += "</h3><i class='xi-angle-down'></i></a><p>";
						content += "<b>A</b>" + result.data[i].content;
						content += "</p></div>";
					}
					document.querySelector(".notice-box div").innerHTML = content;
					dropdown();
					page++;
				}else{
					alert("마지막 페이지입니다.");
				}
			}else {
				alert("잘못된 요청입니다.");
			}
		});
	});
	function dropdown(){
		var faq = document.querySelectorAll('.faq-item');
	    faq.forEach((item)=>{
	        item.addEventListener('click', function(){
	            this.classList.toggle('full');
	        });
	    });
	}
	dropdown()
</script>
<%@ include file="../layouts/footer.jsp"%>

</body>

</html>