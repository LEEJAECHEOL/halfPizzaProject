<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp" %>

    <main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>마이페이지</span></h3>
            </div>
            <div class="mypage-list">
                <ul>
                    <li><a href="#a">주문내역</a></li>
                    <li><a href="#a">쿠폰함</a></li>
                    <li><a href="#a">스탬프</a></li>
                    <li><a href="#a" class="selected">개인정보수정</a></li>
                </ul>
            </div>

            <div class="mypage-update-box">
                <form action="${pageContext.request.contextPath}/auth/updateProc">
                    <div class="update-form-top">
                        <h3>개인정보 입력</h3>
                        <input type="hidden" name="id" value="${user.id}">
                        <p class="update-name">
                            <span>이름</span>
                            <input type="text" value="${user.name}"readonly>
                        </p>
                        <p class="update-id">
                            <span>아이디</span>
                            <input type="text" value="${user.username}" readonly>
                        </p>
                        <p class="update-password">
                            <span>비밀번호</span>
                            <input type="password" name="password">
                            <input type="password" placeholder="비밀번호확인">
                        </p>
                        <p class="update-birth">
                            <span>생년월일</span>
                            <input type="date" value="${user.birth}" readonly>
                        </p>
                        <p class="update-phone">
                            <span>휴대전화</span>
                            <input type="text" value="${user.phone}" readonly id ="phone">
                            <a href="#a">변경</a>
                        </p>
                        <p class="update-email">
                            <span>이메일</span>
                            <c:set var="e" value="${user.email}"/>
                            <input type="text" name="emailFront" id="emailFront" value="${fn:substringBefore(e, '@')}">
                            <input type="text" name="email" id="email" value="${fn:substringAfter(e, '@')}">
                            
                            <input type="hidden" name="emailBack" id="emailBack">
                            
                        <select name="eSelect" id="eSelect">
							<option value="1" selected="selected">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="nate.com">nate.com</option>
							<option value="google.com">google.com</option>
						</select>
					</p>
                    </div>

                    <div class="update-form-middle">
                        <h3>마케팅정보 활용동의</h3>
                        <p>마케팅/홍보를 위하여 아래 항목의 정보를 이용합니다. 동의 거부시 할인 및 이벤트 정보 안내 서비스가 제한됩니다.</p>
                        <label class="checkbox">
                            <input type="checkbox" name="emailAd" id="emailAd" value=1>
                            <span class="lbl"><i></i>이메일 수신 동의</span>
                        </label>
                        <label class="checkbox">
                            <input type="checkbox" name="smsAd" id="smsAd" value=1>
                            <span class="lbl"><i></i>SMS수신 동의</span>
                        </label>
                    </div>

                    <div class="update-form-bottom">
                        <h3>SNS 계정 연동</h3>
                        <p><span>네이버 계정에 연결된 정보가 없습니다.</span><button><img src="../images/member/ico_login_naver.png" alt=""><b>연결하기</b></button></p>
                        <p><span>카카오 계정에 연결된 정보가 없습니다.</span><button><img src="../images/member/ico_login_kakako.png" alt=""><b>연결하기</b></button></p>
                    </div>
                    <a href="#a">회원탈퇴 &gt;</a>
                    <button>수정</button>
                </form>
            </div>
        </div>
    </main>

     <%@ include file="../layouts/footer.jsp" %>
     
     <script>
		document.querySelector('#eSelect').addEventListener("change", function(){
			let _value = this.value;
			let _email = document.querySelector('#email');
			if(_value === ""){
				_email.readOnly=false;
				_email.value = "";
			}else{
				_email.readOnly=true;
				_email.value = _value;
			}
			inputEmail();
		});
		
		document.querySelector('#emailFront').addEventListener("change", function(){
			inputEmail();
		});
		
		document.querySelector('#email').addEventListener("change", function(){
			inputEmail();
		});
		
		document.querySelector('#phone').addEventListener("blur", function(){
			let val = this.value;
			this.value = val.substr(0,3) + '-' + val.substr(3,4) + '-' + val.substr(7);
		});
		
		document.querySelector('#phone').addEventListener("focus", function(){
			this.value = this.value.replace(/[^0-9]/g,'');
		});
		document.querySelector('#submitBtn').addEventListener('click', function(){
			if(document.querySelector('#checkId').value !== 'ok'){
				alert('아이디 중복확인을 해주세요!');document.querySelector('#username').focus();  return;
			}
			if(document.querySelector('#checkPw').value !== 'ok'){
				alert('비밀번호가 일치하지 않습니다.');document.querySelector('#password').focus();  return;
			}
			document.querySelector('#registerForm').submit();
			
		});
		document.querySelector('#passwordCheck').addEventListener("change", function(){
			let _pass1 = document.querySelector('#password').value;
			let _pass2 = document.querySelector('#passwordCheck').value;
			if(_pass1 === _pass2){
				document.querySelector('#checkPw').value="ok";
				document.querySelector('#warnPw').style.display = "none";
			}else {
				document.querySelector('#checkPw').value="";
				document.querySelector('#warnPw').style.display = "block";
			}
		});
		function inputEmail(){
			let _end = document.querySelector('#email').value;
			document.querySelector('#emailBack').value = '@' + _end;
		}
		document.querySelector('#usernameCheck').addEventListener('click', function(){
			let _username = document.querySelector('#username').value;
			if(_username === ''){
				alert('아이디를 입력해주세요.'); document.querySelector('#username').focus(); return;
			}
			$.ajax({
				type : "GET",
				url : "http://localhost:8000/halfPizza/auth/findCheck?username=" + _username,
				contentType : "application/json;charset=utf-8",
				dataType:"json"
			})
			.done(function(result){
				let _good = document.querySelector("#goodId");
				let _warn = document.querySelector("#warnId");
				let _input = document.querySelector("#username");
				if(result.data === 'ok'){
					_good.style.display = 'none';
					_warn.style.display = 'block';
					_input.readOnly = false;
					document.querySelector('#checkId').value = '';
					_input.focus();
				}else{
					_good.style.display = 'block';
					_warn.style.display = 'none';
					_input.readOnly = true;
					document.querySelector('#checkId').value = 'ok';
					document.querySelector('#password').focus();
				}
			});
		});
    </script>
     
</body>

</html>