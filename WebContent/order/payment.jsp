<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp" %>
  
	<main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>결제하기</span></h3>
            </div>
            <div class="payment-box">
                <div class="payment-left">
                    <div class="payment-user">
                        <h3>고객정보</h3>
                        <table>
                            <colgroup>
                                <col width="20%">
                                <col width="70%">
                            </colgroup>
							<c:choose>
								<c:when test="${sessionScope.user!=null}">
									 <tr class="tb-name">
									 	<input type="hidden" id="userId" name="userId" value="${sessionScope.user.id }"/>
		                                <td>이름</td>
		                                <td><input type="text" value="${sessionScope.user.name}" id="username" name="username" readonly></td>
		                            </tr>
		                            <tr class="tb-phone">
		                                <td>휴대전화</td>
		                                <td><input type="text" value="${sessionScope.user.phone}" id="phone" name="phone" readonly></td>
		                            </tr>
		                            <tr class="tb-request">
		                                <td>요청사항</td>
		                                <td><input type="text" id="text" name="text" placeholder="요청사항을 입력해주세요"></td>
		                            </tr>
								</c:when>
								<c:otherwise>
									<tr class="tb-name">
										<input type="hidden" id="userId" name="userId" value="0"/>
		                                <td>이름</td>
		                                <td><input type="text" value="" id="username" name="username" placeholder="이름을 입력해주세요."></td>
		                            </tr>
		                            <tr class="tb-phone">
		                                <td>휴대전화</td>
		                                <td><input type="text" value="" id="phone" name="phone" placeholder="휴대전화를 입력해주세요."></td>
		                            </tr>
		                            <tr class="tb-request">
		                                <td>요청사항</td>
		                                <td><input type="text" id="text" name="text" placeholder="요청사항을 입력해주세요"></td>
		                            </tr>
								</a>
								</div>
								</c:otherwise>
							</c:choose>
                           
                        </table>
                        <div class="agree-check">
                            <label class="checkbox chkYellow">
                                <input type="checkbox" name="allCheck" id="check" value="00">
                                <span class="lbl"><i></i>개인정보 처리방침 동의</span>
                            </label>
                            <span class="open2">약관보기</span>
                        </div>
                    </div>
                    <div class="myPizza">
	                    <c:choose>
						  	<c:when test="${cart!=null}">
								<c:forEach var="item" items="${cart.cartWrap}">
									<div>
			                    		<div class="myPizza-left">
				                            <img src="${item.menu.src}" alt="">
				                        </div>
				                        <div class="myPizza-right">
				                            <div class="myPizza-right-title">
				                                <h3>${item.menu.title}</h3>
				                                <span><fmt:formatNumber value="${item.menu.price}" pattern="#,###" />원</span>
				                            </div>
				                            <table width="350px">
				                                <colgroup>
				                                    <col width="80%">
				                                    <col width="20%">
				                                </colgroup>
				                                <c:if test="${item.size != null }">
						                            <tr class="size">
						                                <td>${item.size.text}</td>
						                                <td><fmt:formatNumber value="${item.size.price}" pattern="#,###" />원</td>
						                            </tr>
					                            </c:if>
					                            <c:forEach var="option" items="${item.option}" varStatus="status">
					                            	<tr>
						                                <td>${option.text}</td>
						                                <td><fmt:formatNumber value="${option.price}" pattern="#,###" />원</td>
						                            </tr>
					                            </c:forEach>
					                            <tr>
					                            	<td>수량</td>
					                            	<td>${item.count }</td>
					                            </tr>
					                            <tr>
					                            	<td></td>
					                            	<td>
					                            	<input type="hidden" class="partPrice" value="${item.totalPrice * item.count}" /> 
					                            	<fmt:formatNumber value="${item.totalPrice * item.count}" pattern="#,###" />원
					                            	</td>
					                            </tr>
				                            </table>
				                        </div>
			                    	</div>
								</c:forEach>
						  	</c:when>
						  	<c:otherwise>
						  		<h3>장바구니가 비었습니다.</h3>
						  	</c:otherwise>
					  	</c:choose>
                    </div>
                    <div class="selectStore">
                        <h3>스토어선택</h3>
                        <div class="sunbool-point">
                        	<input type="hidden" name="storeTel" id="storeTel">
                            <input type="text" name="storeAddr" id="storeAddr"  readOnly>
                            <button type="button" id="searchStoreBtn">스토어찾기</button>
                        </div>
                    </div>
                    <div class="sunbool">
                        <h3>선불금액권</h3>
                        <div class="sunbool-point">
                            <span>선불금액권</span>
                            <input type="text">
                            <button>조회</button>
                        </div>
                    </div>
                    <div class="coupon">
                        <h3>쿠폰적용</h3>
                        <div class="coupon-discount">
                            <span>쿠폰할인&nbsp;</span>
                            <input type="text">
                            <button>조회</button>
                        </div>
                    </div>
                    <div class="delivery-info">
                        <h3>배달정보</h3>
                        <table width="100%">
                            <colgroup>
                                <col width="30%">
                                <col width="70%">
                            </colgroup>
                            <tr>
                                <td>배달정보</td>
                                <td id="addr">${selectedAddr}</td>
                            </tr>
                            <tr>
                                <td>예정시간</td>
                                <td><span>바로주문</span></td>
                            </tr>
                            <tr>
                                <td>배달소요시간</td>
                                <td>90분/ (매장 상황에 따라 지연될 수 있습니다.)</td>
                            </tr>
                        </table>
                    </div>
                    <div class="pay-method">
                        <h3>결제수단</h3>
                        <button>신용카드</button>
                    </div>
                </div>
                <div class="payment-right">
                    <div>
                        <h3>결제정보</h3>
                        <div class="payment-discount">
                            <h4>할인</h4>
                            <span>-0원</span>
                        </div>
                        <div class="payment-calced-price">
                            <h4>최종결제금액</h4>
                            <span id ="cartToltalPrice">0원</span>
                        </div>
                        <button type="button" onclick="pay()">결제하기</button>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <script>
		window.addEventListener('DOMContentLoaded', function() {
			let prices = document.querySelectorAll('.partPrice');
			let price = 0;
			prices.forEach(function(p){
				price += Number(p.value);
			});
			function moneyComma(val){
				return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+"원";
			}
			document.querySelector('#cartToltalPrice').dataset.price = price;
			document.querySelector('#cartToltalPrice').textContent = moneyComma(price);
		});
		function pay() {
			let _check = document.querySelector('#check').checked;
			let _userId = document.querySelector('#userId').value;
			let _name = document.querySelector('#username').value;
			let _phone = document.querySelector('#phone').value;
			let _text = document.querySelector('#text').value;
			let _price = document.querySelector('#cartToltalPrice').dataset.price;
			let _addr = document.querySelector('#addr').textContent;
			let _storeAddr = document.querySelector('#storeAddr').value;
			let _storeTel = document.querySelector('#storeTel').value;
			if(_name === '' || _phone === '' || _text === ''){
				alert("고객정보를 입력해주세요."); return ;
			}
			if(!_check){
				alert("개인정보처리방침을 동의해주세요.");return;	
			}
			if(_storeAddr === ''){
				alert("스토어를 선택해주세요.");return;
			}
			IMP.init('imp27033422'); 
			IMP.request_pay({
			      pg : 'html5_inicis', // 결제방식
			       pay_method : 'card',	// 결제 수단
			       merchant_uid : 'merchant_' + new Date().getTime(),
			      name : '주문명: 결제 테스트',	// order 테이블에 들어갈 주문명 혹은 주문 번호
			       amount : _price,	// 결제 금액
			       buyer_email : '',	// 구매자 email
			      buyer_name :  _name,	// 구매자 이름
			       buyer_tel :  _phone,	// 구매자 전화번호
			       buyer_addr :  _addr,	// 구매자 주소
			       buyer_postcode :  '',	// 구매자 우편번호
			       /* m_redirect_url : '/khx/payEnd.action'	// 결제 완료 후 보낼 컨트롤러의 메소드명 */
			   }, function(rsp) {
				if ( rsp.success ) { // 성공시
					let data = "name=" + _name +"&";
					data += "phone=" + _phone +"&";
					data += "userId=" + _userId +"&";
					data += "text=" + _text +"&";
					data += "storeAddr=" + _storeAddr +"&";
					data += "storeTel=" + _storeTel +"&";
					data += "addr=" + getCookie("selectedAddr").replace('path=/halfPizza', '') +"&";
					data += "info=" + getCookie("cart").replace('path=/halfPizza', '') +"&";
					data += "impId=" + rsp.imp_uid +"&";
					data += "merchantId=" + rsp.merchant_uid +"&";
					data += "paidAmount=" + rsp.paid_amount;
					
					$.ajax({
						type : "POST",
						url : "/halfPizza/order/complete",
						data : data
					})
					.done(function(result){
						location.href="/halfPizza/order/payment/success";
					});
				} else { // 실패시
					var msg = '결제에 실패하였습니다.';
					msg += '에러내용 : ' + rsp.error_msg;
				}
			});
		}
		function getCookie(name) {
			  var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
			  return value? value[2] : null;
		}
		function deleteCookie(name) {
			console.log(name);
			document.cookie = name + '=; expires=Thu, 01 Jan 1999 00:00:10 GMT';
		}
		document.querySelector('#phone').addEventListener("blur", function(){
			let val = this.value;
			this.value = val.substr(0,3) + '-' + val.substr(3,4) + '-' + val.substr(7);
		});

		document.querySelector('#phone').addEventListener("focus", function(){
			this.value = this.value.replace(/[^0-9]/g,'');
		});
		document.querySelector('#searchStoreBtn').addEventListener("click", function(){
			window.open("/halfPizza/store/popup","new","width=500,height=500,top=100,left=100");
		});
    </script>
<%@ include file="../layouts/footer.jsp" %>
	<div class="popup2">
        <h2>개인정보 처리방침</h2>
        <div class="agree-conten-1">
            &lt;반올림식품&gt;(은)는 개인정보 보호법 제30조에 따라 정보주체(고객)의 개인정보를 보호하고 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 다음과 같이 개인정보 처리지침을 수립․공개합니다. <br>
            <br>
            1. 개인정보의 처리목적 &lt;반올림식품&gt;은(는) 다음의 목적을 위하여 개인정보를 처리하고 있으며, 다음의 목적 이외의 용도로는 이용하지 않습니다. <br>
            - 고객 가입의사 확인, 고객에 대한 서비스 제공에 따른 본인 식별․인증, 회원자격 유지․관리, 물품 또는 서비스 공급에 따른 금액 결제, 물품 또는 서비스의 공급․배송 등<br>
            <br>
            2. 개인정보의 처리 및 보유기간<br>
            ① &lt;반올림식품&gt;은(는) 정보주체로부터 개인정보를 수집할 때 동의받은 개인정보 보유․이용기간 또는 법령에 따른 개인정보 보유․이용기간 내에서 개인정보를 처리․보유합니다. <br>
            ② 구체적인 개인정보 처리 및 보유 기간은 다음과 같습니다. <br>
            - 고객 가입 및 관리 : 서비스 이용계약 또는 회원가입 해지시까지, 다만 채권․채무관계 잔존시에는 해당 채권․채무관계 정산시까지 <br>
            - 전자상거래에서의 계약․청약철회, 대금결제, 재화 등 공급기록 : 5년 <br>
            <br>
            3. 개인정보의 제3자 제공 &lt;반올림식품&gt;은(는) 정보주체의 별도 동의, 법률의 특별한 규정 등 개인정보 보호법 제17조에 해당하는 경우 외에는
            개인정보를 제3자에게 제공하지 않습니다. <br>
            <br>
            4. 개인정보처리의 위탁<br>
            ① &lt;반올림식품&gt;은(는) 원활한 개인정보 업무처리를 위하여 다음과 같이 개인정보 처리업무를 외부에 위탁하고 있습니다.<br>
            - A/S 센터 운영<br>
            ․위탁받는 자 (수탁자) : ㈜씨엔티테크<br>
            ․위탁하는 업무의 내용 : 고객 대상 제품 A/S 제공<br>
            ② &lt;반올림식품&gt;은(는) 위탁계약 체결시 개인정보 보호법 제25조에 따라 위탁업무 수행목적 외 개인정보 처리금지, 재위탁 제한, 수탁자에 대한 관리․감독, 책임에 관한 사항을 문서에 명시하고, 수탁자가 개인정보를 안전하게 처리하는지를 감독하고 있습니다.<br>
            <br>
            5. 정보주체와 법정대리인의 권리․의무 및 행사방법 정보주체는 &lt;반올림식품&gt;에 대해 언제든지 다음 각 호의 개인정보 보호 관련 권리를 행사할 수 있습니다.<br>
            1. 개인정보 열람요구<br>
            2. 개인정보에 오류 등이 있을 경우 정정 요구<br>
            3. 삭제요구<br>
            4. 처리정지 요구<br>
            <br>
            6. 처리하는 개인정보 항목 &lt;반올림식품&gt;은(는) 다음의 개인정보 항목을 처리하고 있습니다.<br>
            - 성명, 생년월일, 주소, 전화번호, 휴대전화번호, 성별, 이메일주소, 신용카드번호, 은행계좌번호 등 결제정보<br>
            <br>
            7. 개인정보의 파기 ① &lt;반올림식품&gt;은(는) 개인정보 보유기간의 경과, 처리목적 달성 등 개인정보가 불필요하게 되었을 때에는 지체없이 해당 개인정보를 파기합니다.<br>
            ② &lt;반올림식품&gt;은(는) 다음의 방법으로 개인정보를 파기합니다.<br>
            - 전자적 파일 : 파일 삭제 및 디스크 등 저장매체 포맷<br>
            - 수기 문서 : 분쇄하거나 소각<br>
            <br>
            8. 개인정보의 안전성 확보조치 &lt;반올림식품&gt;은(는) 개인정보의 안전성 확보를 위해 다음과 같은 조치를 취하고 있습니다.<br>
            - 관리적 조치 : 내부관리계획 수립․시행, 직원․종업원 등에 대한 정기적 교육<br>
            - 기술적 조치 : 개인정보처리시스템(또는 개인정보가 저장된 컴퓨터)의 비밀번호 설정 등 접근권한 관리, 백신소프트웨어 등 보안프로그램 설치, 개인정보가 저장된 파일의 암호화<br>
            - 물리적 조치 : 개인정보가 저장․보관된 장소의 시건, 출입통제 등<br>
            <br>
            9. 개인정보 자동 수집 장치의 설치∙운영 및 거부에 관한 사항<br>
            ① &lt;반올림식품&gt;은(는) 이용자에게 개별적인 맞춤서비스를 제공하기 위해 이용정보를 저장하고 수시로 불러오는 ‘쿠기(cookie)’를 사용합니다.<br>
            ② 쿠키는 웹사이트를 운영하는데 이용되는 서버(http)가 이용자의 컴퓨터 브라우저에게 보내는 소량의 정보이며 이용자들의 PC 컴퓨터내의 하드디스크에 저장되기도 합니다.<br>
            가. 쿠키의 사용목적: 이용자가 방문한 각 서비스와 웹 사이트들에 대한 방문 및 이용형태, 인기 검색어, 보안접속 여부, 등을 파악하여 이용자에게 최적화된 정보 제공을 위해 사용됩니다.<br>
            나. 쿠키의 설치∙운영 및 거부 : 웹브라우저 상단의 도구>인터넷 옵션>개인정보 메뉴의 옵션 설정을 통해 쿠키 저장을 거부 할 수 있습니다.<br>
            다. 쿠키 저장을 거부할 경우 맞춤형 서비스 이용에 어려움이 발생할 수 있습니다.<br>
            <br>
            10. 개인정보 보호책임자 &lt;반올림식품&gt;은(는) 개인정보 처리에 관한 업무를 총괄해서 책임지고, 개인정보 처리와 관련한 정보주체의 불만처리 및 피해구제를 처리하기 위하여 아래와 같이 개인정보 보호책임자를 지정하고 있습니다.<br>
            ▶ 개인정보 보호책임자 ㈜반올림식품<br>
            성명 : 윤성원 직책 : 대표이사<br>
            연락처 : 053-743-7949<br>
            이메일 : pizza7949@naver.com<br>
            <br>
            11. 개인정보 처리방침 변경 이 개인정보 처리방침은 2020. 6. 1.부터 적용됩니다.<br>
        </div>
        <a href="#a" class="close2">닫기</a>
    </div>
</body>
</html>