<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp"%>

    <main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>고객의 소리</span></h3>
            </div>

            <section class="content_wrap">
                <form class="gform" method="post" action="https://script.google.com/macros/s/AKfycbx7W3LKLAHl90l3XGz_kvYRoAET3BnjF9AEsZ0k5g/exec" name="contactus">
                    <div class="formlist">
                        <ul>
                            <li>
                                <label for="part">문의종류</label>
                                <select name="part" id="part">
                                    <option value="불만">불만</option>
                                    <option value="칭찬">칭찬</option>
                                    <option value="건의">건의</option>
                                    <option value="문의">문의</option>
                                </select>
                                <i class="xi-angle-down"></i>
                            </li>
                            <li>
                                <label for="name">이름</label>
                                <span class="inputbox"><input type="text" id="name" name="name" required placeholder="이름을 입력하여 주세요" /></span>
                            </li>
                            <li>
                                <label for="email">이메일</label>
                                <span class="inputbox"><input type="email" id="email" name="email" required placeholder="sample@mail.com" /></span>
                            </li>
                            <li>
                                <label for="phone">휴대전화</label>
                                <span class="inputbox"><input type="text" id="phone" name="phone" required placeholder="-없이 숫자만 입력해주세요" /></span>
                            </li>
                            <li>
                                <label for="message">문의 내용</label>
                                    <textarea id="message" name="message" placeholder="궁금한 사항을 작성해 주세요" required></textarea>
                            </li>
                        </ul>
                        <div class="btn_box">
                            <button type="submit" class="commbtn gray">문의하기</button>
                        </div>
                    </div>

                    <div class="thankyou_message">
                        <section>
                            <h1>작성 완료되었습니다.</h1>
                            <p>확인 후 빠르게 답변 드리겠습니다.</p>
                            <div class="btn_box">
                                <a href="#" class="commbtn gray close">닫기</a>
                            </div>
                        </section>
                    </div>
                </form>
            </section>

        </div>
    </main>
    <%@ include file="../layouts/footer.jsp"%>
    <script type="text/javascript" src="../js/form-submission-handler.js"></script>
    <script type="text/javascript" src="../js/ui.js"></script>
</body>

</html>