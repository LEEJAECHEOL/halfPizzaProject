<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../layouts/adminHeader.jsp"%>
<main>
	<div class="container">
		<div class="map">
           	<form method="POST" action="${pageContext.request.contextPath}/admin/store/registProc">
	            <div class="map-box">
	                <div class="map-left" id ="map" style="height:500px;"></div>
	               	<div class="map-right">
	                	<input type="hidden" name="xPos" id="xPos">
	                	<input type="hidden" name="yPos" id="yPos">
	                    <div class="store-info">
	                        <p>매장명</p>
	                        <input type="text" name="name" required />
	                    </div>
	                    <div class="store-info">
	                        <p>전화번호</p>
	                        <input type="text" name="tel" required placeholder="'-'포함해서 입력해주세요." />
	                    </div>
	                    <div class="store-info">
	                        <p>매장주소</p>
	                        <input type="text" name="addr" id="addr" required readOnly />
	                        <button type="button" onclick="getAddr()">주소 검색</button>
	                    </div>
	                    <div class="store-info">
	                        <p>나머지주소</p>
	                        <input type="text" name="addr2">
	                    </div>
	                    <button type ="submit">저장</button>
	                </div>
	            </div>
          	</form>
        </div>
	</div>
</main>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6a5e93ecd3972432d6d24bd35c2f22b5&libraries=services"></script>
<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
	    center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
	    level: 1 // 지도의 확대 레벨
	};  
	
	//지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	//주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	var marker = new daum.maps.Marker({
        position: new daum.maps.LatLng(37.566826, 126.9786567),
        map: map
    });
	infowindow = new kakao.maps.InfoWindow({zindex:1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다
	
	//지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
	kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
	searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
	    if (status === kakao.maps.services.Status.OK) {
	    	document.getElementById("addr").value = result[0].road_address.address_name;
	    	document.getElementById("xPos").value = mouseEvent.latLng.getLng();
	    	document.getElementById("yPos").value = mouseEvent.latLng.getLat();
	        // 마커를 클릭한 위치에 표시합니다 
	        marker.setPosition(mouseEvent.latLng);
	        marker.setMap(map);
	
	    }   
	});
	});
	
	//중심 좌표나 확대 수준이 변경됐을 때 지도 중심 좌표에 대한 주소 정보를 표시하도록 이벤트를 등록합니다
	kakao.maps.event.addListener(map, 'idle', function() {
		searchAddrFromCoords(map.getCenter(), function(){});
	});
	
	function searchAddrFromCoords(coords, callback) {
	// 좌표로 행정동 주소 정보를 요청합니다
		geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);         
	}
	
	function searchDetailAddrFromCoords(coords, callback) {
	// 좌표로 법정동 상세 주소 정보를 요청합니다
		geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
	}
	
	function getAddr() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = data.address; // 최종 주소 변수

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("addr").value = addr;
                // 주소로 상세 정보를 검색
                geocoder.addressSearch(data.address, function(results, status) {
                    // 정상적으로 검색이 완료됐으면
                    if (status === daum.maps.services.Status.OK) {

                        var result = results[0]; //첫번째 결과의 값을 활용

                        // 해당 주소에 대한 좌표를 받아서
                        var coords = new daum.maps.LatLng(result.y, result.x);
            	    	document.getElementById("xPos").value = result.x;
           		    	document.getElementById("yPos").value = result.y;
                        map.relayout();
                        // 지도 중심을 변경한다.
                        map.setCenter(coords);
                        // 마커를 결과값으로 받은 위치로 옮긴다.
                        marker.setPosition(coords);
                        marker.setMap(map);
                    }
                });
            }
        }).open();
    }
</script>
</body>

</html>