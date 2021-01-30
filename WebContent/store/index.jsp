<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp" %>
	
    <main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>스토어</span></h3>
            </div>
            <div class="store-select">
                <h3>방문하실매장을 검색하여 선택해주세요</h3>
                <div>
                    <select name="" id="city" class="city" onchange="GuList(this)">
                        <option value="">지역선택</option>
                        <option value="강원">강원</option>
                        <option value="경기">경기</option>
                        <option value="경남">경남</option>
                        <option value="경북">경북</option>
                        <option value="광주">광주</option>
                        <option value="대구">대구</option>
                        <option value="대전">대전</option>
                        <option value="부산">부산</option>
                        <option value="서울">서울</option>
                        <option value="세종특별자치시">세종특별자치시</option>
                        <option value="울산">울산</option>
                        <option value="인천">인천</option>
                        <option value="전남">전남</option>
                        <option value="전북">전북</option>
                        <option value="제주특별자치도">제주특별자치도</option>
                        <option value="충남">충남</option>
                        <option value="충북">충북</option>
                    </select>
                    <i class="xi-angle-down"></i>
                </div>
                <div>
                   <i class="xi-angle-down"></i>
                    <select name="" id="" class="store" onChange="selectStore(this)">
                        <option value="">-</option>
                    </select>
                </div>
            </div>
            <div class="map">
				<c:choose>
					<c:when test="${dto!=null}">
		                <div class="map-box">
		                	<input type="hidden" id="xPos" value="${dto.getXPos()}">
		                	<input type="hidden" id="yPos" value="${dto.getYPos()}">
		                    <div class="map-left" id ="map" style="height:400px">
		                    </div>
		                    <div class="map-right">
		                        <div class="store-info">
		                            <p>매장명</p>
		                            <h3 id="storeName">${dto.name}</h3>
		                        </div>
		                        <div class="store-info">
		                            <p>전화번호</p>
		                            <h3 id="storeTel">${dto.tel}</h3>
		                        </div>
		                        <div class="store-info">
		                            <p>매장주소</p>
		                            <h3 id="storeAddr">${dto.addr} ${dto.addr2}</h3>
		                        </div>
		                    </div>
		                </div>
				 	</c:when>
				 	<c:otherwise>
            			<h2 style="text-align:center">등록된 스토어가 없습니다.</h2>
				 	</c:otherwise>
				 </c:choose>
            </div>
        </div>
    </main>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6a5e93ecd3972432d6d24bd35c2f22b5&libraries=services"></script>
	<script>
		var x = document.querySelector('#xPos').value;
		var y = document.querySelector('#yPos').value;
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    	mapOption = { 
		        center: new kakao.maps.LatLng(Number(y), Number(x)), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
	    };
	
		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		// 마커가 표시될 위치입니다 
		var markerPosition  = new kakao.maps.LatLng(Number(y), Number(x)); 
		
		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: markerPosition
		});
		
		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
		function GuList(_this){
			$.ajax({
				type:"GET",
				url:"/halfPizza/store/findPoint?area="+_this.value,
				dataType: "json",
			}).done(function(result){
				let content = "<option value=''>-</option>";
				if(result.data.length !== 0){
					for(let i = 0; i < result.data.length; i++){
						content += "<option value='" + result.data[i].id + "'>" + result.data[i].name + "</option>";
					}
				}
				document.querySelector(".store").innerHTML = content;
			});
		}
		function selectStore(_this){
			let value = _this.value;
			if(value === ''){
				return;
			}
			$.ajax({
				type:"GET",
				url:"/halfPizza/store/findStore?id=" + value,
				dataType: "json",
			}).done(function(result){
				console.log(result);
				document.querySelector("#storeName").textContent = result.data.name;
				document.querySelector("#storeTel").textContent = result.data.tel;
				document.querySelector("#storeAddr").textContent = result.data.addr + ' ' + result.data.addr2;
				map.setCenter(new kakao.maps.LatLng(result.data.yPos, result.data.xPos));
				marker.setPosition(new kakao.maps.LatLng(result.data.yPos, result.data.xPos));
	            marker.setMap(map);
			});
		}
	</script>
<%@ include file="../layouts/footer.jsp" %>
</body>
</html>