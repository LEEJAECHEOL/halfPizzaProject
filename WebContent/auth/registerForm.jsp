<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layouts/header.jsp" %>
	<main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>회원가입</span></h3>
            </div>

            <div class="join-box">
                <form method="post" action="${pageContext.request.contextPath}/auth/registerProc" class="user-info" id="registerForm">
                    <h3>개인정보 입력</h3>
                    <div class="name">
                        <span>이름</span>
                        <input type="text" name="name" placeholder="성함을 입력해주세요" required>
                    </div>
                    <div class="userId">
                        <span>아이디</span>
                        <input type="hidden" id="checkId">
                        <input type="text" name="username" id="username" placeholder="ID를 입력해주세요" required>
                        <button type="button" class="userIdCheck" id="usernameCheck">중복확인</button>
                    </div>
                    <p class="good" id="goodId">사용가능한 아이디입니다.</p>
                    <p class="warning" id="warnId">이미 사용중인 아이디입니다.</p>
                    <div class="password">
                        <span>비밀번호</span>
                        <input type="hidden" id="checkPw">
                        <input type="password" name="password" id="password" placeholder="비밀번호를 입력해주세요" required>
                        <input type="password" name="passwordCheck" id="passwordCheck" placeholder="비밀번호 확인" required>
                    </div>
                    <p class="warning" id="warnPw">비밀번호가 일치하지 않습니다.</p>
                    <div class="birth">
                        <span>생년월일</span>
                        <input type="date" name="birth" required>
                    </div>
                    <div class="phone">
                        <span>휴대전화</span>
                        <input type="text" name="phone" id ="phone" required>
                    </div>

                    <h3>이메일정보 입력</h3>
                    <div class="email">
                        <span>이메일</span>
                        <input type="text" name="emailFront" id="emailFront" required>
                        @
                        <input type="text" name="emailBack" id="emailBack" required>
                        <input type="hidden" name="email" id="email">
                        <select name="eSelect" id="eSelect">
                            <option value="">직접입력</option>
                            <option value="naver.com">naver.com</option>
                            <option value="nate.com">nate.com</option>
                            <option value="google.com">google.com</option>
                        </select>
                    </div>

                    <!--여기 아이디값 체크하세용-->
                    <h3>마케팅 정보 동의</h3>
                    <div class="marketing">
                        <label class="checkbox chkYellow">
                            <input type="checkbox" name="emailAd" id="emailAd" value=1>
                            <span class="lbl"><i></i>이메일 광고성 정보 동의</span>
                        </label>
                        <label class="checkbox chkYellow">
                            <input type="checkbox" name="smsAd" id="smsAd" value=1>
                            <span class="lbl"><i></i>SMS 광고성 정보 동의</span>
                        </label>
                    </div>
                    <button type="button" id="submitBtn" class="btn-blue">신규가입</button>
                </form>
            </div>
        </div>
    </main>
    <script>
		document.querySelector('#emailAd').addEventListener('click', function(){
			console.log(this);
		});
		
		document.querySelector('#eSelect').addEventListener("change", function(){
			let _value = this.value;
			let _emailBack = document.querySelector('#emailBack');
			if(_value === ""){
				_emailBack.readOnly=false;
				_emailBack.value = "";
			}else{
				_emailBack.readOnly=true;
				_emailBack.value = _value;
			}
			inputEmail();
		});
		
		document.querySelector('#emailFront').addEventListener("change", function(){
			inputEmail();
		});
		
		document.querySelector('#emailBack').addEventListener("change", function(){
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
			let _first = document.querySelector('#emailFront').value;
			let _end = document.querySelector('#emailBack').value;
			document.querySelector('#email').value = _first + '@' + _end;
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

<%@ include file="../layouts/footer.jsp" %>
</body>
</html>