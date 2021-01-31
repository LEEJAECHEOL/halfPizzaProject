<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp" %>
<main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>창업문의</span></h3>
            </div>

            <section class="content_wrap">
                <form class="gform" method="post" action="https://script.google.com/macros/s/AKfycbxHNJpl1NQLOn773tW9_ljuquz-L6TmXD5FCaks/exec" name="contactus">
                    <div class="formlist">
                        <ul>
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
                                <label for="location">정보</label>
                                <span class="inputbox"><input type="text" id="location" name="location" required placeholder="개설희망지역" /></span>
                                <span class="inputbox"><input type="text" id="money" name="money" required placeholder="창업비용(만원)" /></span>
                            </li>
                            <li>
                                <label for="message">내용</label>
                                    <textarea id="message" name="message" placeholder="내용을 작성해주세요" required></textarea>
                            </li>
                        </ul>
                        <div class="btn_box">
                            <button type="submit" class="commbtn gray">발송</button>
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

    <%@ include file="../layouts/footer.jsp" %>
    <div class="dim"></div>
    <script type="text/javascript" src="../js/form-submission-handler.js"></script>
    <script type="text/javascript" src="../js/ui.js"></script>
</body>

</html>
