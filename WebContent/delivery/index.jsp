<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp" %>
	
    <main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>배송지선택</span></h3>
            </div>
            
            <div class="address-box">
               <h3>
               <c:choose>
				  	<c:when test="${selectedAddr!=null}">
				  		<span>${selectedAddr}</span>
				  	</c:when>
				  	<c:otherwise>
				  		<span>배송지를 선택해주세요.</span>
				  	</c:otherwise>
			  	</c:choose>
               	<button onClick="sample2_execDaumPostcode()">배송지등록</button>
               </h3>
                <ul class="address-list">
                <c:choose>
				  	<c:when test="${addr!=null}">
						<c:forEach var="ad" items="${addr.addrWrap}">
	           				<li class="${ad.name}">
	           					<span onClick="selectedAddr('${ad.name}')"><i class='fas fa-check'></i></span>
	           					${ad.addr}
	           					<button type="button" onClick="deleteAddr('${ad.name}')"><i class='fas fa-times'></i></button></li>
						</c:forEach>
				  	</c:when>
				  	<c:otherwise>
				  		<li class="no-addr">배달지를 등록해주세요</li>
				  	</c:otherwise>
			  	</c:choose>
                </ul>
                <button type="button" onClick="orderProc()">주문진행</button>
            </div>
        </div>
    </main>
	<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
		<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
		<div class="detail">
			<h3>상세주소 입력</h4>
			<input type="hidden" id="addr">
			<span class="addr_text"></span>
			<input type="text" id="detailInput" placeholder="상세주소 입력">
			<div>
				<button type="button" onClick="closeDaumPostcode()">취소</button>
				<button type="button" onClick="addAddr()">등록</button>
			</div>
		</div>
	</div>
	<script>
	    // 우편번호 찾기 화면을 넣을 element
	    var element_layer = document.getElementById('layer');
	
	    function closeDaumPostcode() {
	        // iframe을 넣은 element를 안보이게 한다.
	        element_layer.style.display = 'none';
	    }
	
	    function sample2_execDaumPostcode() {
	    	document.querySelector('.detail').style.display = 'none';
	    	document.getElementById("detailInput").value = "";
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수
	
	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
	
	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    addr += extraAddr;
	                
	                } else {
	                	addr += '';
	                }
	
	                document.getElementById("addr").value = addr;
	                document.querySelector(".addr_text").textContent = addr;
	                document.getElementById("detailInput").focus();
	                element_layer.style.height = "270px";
	 				document.querySelector('.detail').style.display = 'flex';
	                // iframe을 넣은 element를 안보이게 한다.
	                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
	                /* element_layer.style.display = 'none'; */
	            },
	            width : '100%',
	            height : '100%',
	            maxSuggestItems : 5
	        }).embed(element_layer);
	
	        // iframe을 넣은 element를 보이게 한다.
	        element_layer.style.display = 'block';
	
	        // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
	        initLayerPosition();
	    }
	
	    function initLayerPosition(){
	        var width = 400; //우편번호서비스가 들어갈 element의 width
	        var height = 500; //우편번호서비스가 들어갈 element의 height
	        var borderWidth = 1; //샘플에서 사용하는 border의 두께
	
	        // 위에서 선언한 값들을 실제 element에 넣는다.
	        element_layer.style.width = width + 'px';
	        element_layer.style.height = height + 'px';
	        element_layer.style.border = borderWidth + 'px solid';
	        // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
	        element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
	        element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
	    }
	    function addAddr(){
	    	let cookieName = "addr";
	    	let name = "addr";
	    	
	    	let data = null;
	    	if(getCookie(cookieName) !== null){
	    		data = JSON.parse((decodeURIComponent(getCookie(cookieName))).replace('path=/halfPizza', ''));
			}else{
				data = { addrWrap : [] };
			}
			
			if(data.addrWrap.length !== 0){
				let i = 0;
				for(i = 0; i < 5; i++){
					if(data.addrWrap[i] === undefined){
						name = name + i;
						break;
					}
				}
				if(i === 4){
					alert("최대 5개까지 배송지를 등록하실 수 있습니다.");return;
				}
			}
			let addrValue = document.getElementById('addr').value;
			let detailValue = document.getElementById('detailInput').value;
			let addr = {
				name : name,
				addr : addrValue + " " + detailValue
			}
			data.addrWrap.push(addr);
			SetCookie(cookieName , JSON.stringify(data), null);
			let content = "<li class='" + name + "'><span onClick=\"selectedAddr('" + name +"')\"><i class='fas fa-check'></i></span>";
			content += (addrValue + " " + detailValue);
			content += "<button onClick=\"deleteAddr('" + name + "')\"><i class='fas fa-times'></i></button></li>";
			document.querySelector('.no-addr') ? document.querySelector('.no-addr').remove():null;
			document.querySelector('.address-list').insertAdjacentHTML("beforeend", content);
			element_layer.style.display = 'none';
	    }
	    function SetCookie( strName, strValue, iSecond )
		{
			var strCookie = strName + "=" + encodeURIComponent(strValue);
			strCookie += "path=/halfPizza";
			if( typeof iSecond === "number" )
			{
				strCookie += "; max-age=" + iSecond;
			}
			strCookie += "; path=/halfPizza";
			document.cookie = strCookie;
		}
		function getCookie(name) {
			  var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
			  return value? value[2] : null;
		}
		function deleteAddr(addrName){
			let data = null;
	    	if(getCookie("addr") !== null){
	    		data = JSON.parse((decodeURIComponent(getCookie("addr"))).replace('path=/halfPizza', ''));
			}
			for(let i = 0; i < data.addrWrap.length; i++){
				if(data.addrWrap[i].name === addrName){
					data.addrWrap.splice(i, 1);
					break;
				}
			}
			SetCookie("addr" , JSON.stringify(data), null);
			document.querySelector("." + addrName).remove();
			if(document.querySelector('.address-list').children.length === 0){
				document.querySelector('.address-list').insertAdjacentHTML("beforeend", "<li class='no-addr'>배달지를 등록해주세요</li>");
			}
		}
		function deleteCookie(name) {
			document.cookie = name + '=; expires=Thu, 01 Jan 1999 00:00:10 GMT;';
		}
		function selectedAddr(val){
			let _li = document.querySelector('.' + val);
			let _span = _li.children[0];
			removeSelectedAddr();
			_span.classList.toggle('selected');
		}
		function removeSelectedAddr(){
			let lis = document.querySelectorAll('.address-list li');
			lis.forEach(function(li){
				li.children[0].classList.remove('selected');
			});
		}
		function orderProc(){
			let select = document.querySelector('.address-list li span.selected');
			if(select === null){
				alert("배달 받으실 주소를 선택해주세요."); return;
			}
			let addr = select.parentElement.outerText;
			SetCookie("selectedAddr" , addr, null);
			location.href = "/halfPizza/order/cart"
		}
	</script>
<%@ include file="../layouts/footer.jsp" %>
</body>
</html>