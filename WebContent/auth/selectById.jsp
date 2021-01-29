<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/header.jsp" %>

    <main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>비밀번호 찾기</span></h3>
            </div>

            <div class="subpage-box">

                <div class="agree-form">
                    <h3>이메일로 찾기</h3>
                    <form action="">
                        <div class="searchByEmail">
                            <input type="text" placeholder="이름" name="name" class="searchName" id="name">
                            <input type="text" placeholder="아이디" name="username" id="username">
                            <div>
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
                        </div>
                        <button type="button" class="btn-blue" id="searchId">비밀번호 찾기</button>
                    </form>
                </div>

                <div class="phone-form">
                    <div class="phone-agree">
                        <h3>휴대폰 본인인증으로 찾기</h3>
                        <p>*본인 명의의 휴대폰 번호로 인증합니다. <br>
                            타인 명의 휴대폰, 법인폰을 이용자는 본인인증이 불가합니다.</p>
                        <p>*본인 인증시 제공되는 정보는<br>
                            인증 이외의 용도로 이용 또는 저장하지 않습니다.
                        </p>
                    </div>
                    <br>
                    <br>
                    <br>
                    <br>
                    
                    <a href="" class="btn-blue">휴대폰 인증</a>
                </div>

            </div>
        </div>
    </main>

    <%@ include file="../layouts/footer.jsp" %>
    
    <div id="selectByEmail">
        <div id="selectSuccess">
            <h3>회원님의 비밀번호는</h3>
            <p><span>비밀번호 : </span><b id="succsessID"></b></p>
            <button id="closeBox">닫기</button>
        </div>
        <div id="selectFail">
            <h3>회원님의 비밀번호를 찾을 수 없습니다.</h3>
            <p><span>입력하신 정보를 다시 확인해주세요</span></p>
            <button id="closeBox2">닫기</button>
        </div>
    </div>
    <script>
 
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
        
        function inputEmail(){
			let _first = document.querySelector('#emailFront').value;
			let _end = document.querySelector('#emailBack').value;
			document.querySelector('#email').value = _first + '@' + _end;
		}

        document.querySelector('#searchId').addEventListener('click', function(){
			let _ckEmail = document.querySelector('#email').value;
			let _ckName = document.querySelector('#name').value;
			let _ckUsername = document.querySelector('#username').value;
			$.ajax({
				type : "GET",
				url : "http://localhost:8000/halfPizza/auth/findByUsername?email=" + _ckEmail+"&name="+_ckName+"&username="+_ckUsername,
				contentType : "application/json;charset=utf-8",
				dataType:"json"
			})
			.done(function(result){
				let _box = document.querySelector('#selectByEmail');
				let _success = document.querySelector('#selectSuccess');
				let _fail = document.querySelector('#selectFail');
				let _successId = document.querySelector('#succsessID');
				console.log(result);
				if(result.data !== 'no'){
					_box.style.display = 'block';
					_success.style.display = 'block';
					_fail.style.display = 'none';
					_successId.innerHTML = result.data;
				}
				else{
					_box.style.display = 'block';
					_success.style.display = 'none';
					_fail.style.display = 'block';
				}
			});
		});

        document.querySelector('#closeBox').addEventListener('click', function(){
        	let _box = document.querySelector('#selectByEmail');
        	_box.style.display = 'none';
        });
        document.querySelector('#closeBox2').addEventListener('click', function(){
        	let _box = document.querySelector('#selectByEmail');
        	_box.style.display = 'none';
        });
    </script>
</body>

</html>