<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp" %>
    <main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>브랜드스토리</span></h3>
            </div>
            <ul class="brand-stroy-list">
                <li class="selected"><a href="${pageContext.request.contextPath}/brand">회사소개</a></li>
                <li><a href="${pageContext.request.contextPath}/brand/slogan">슬로건</a></li>
            </ul>

            <div class="brandCont">
                <p class="brandStory animated CustomAnimate" data-animation="CustomAnimate">
                    <span>
                        2011년 10평 남짓한 작은 피자가게를 오픈하였습니다.<br> 우리는 생각했습니다. <i class="stroke_1"><em>내가 원하는 피자</em></i>를 먹을 수는 없을까? 왜 다 만들어진 피자를 먹어야만 하는 것일까?<br> 내가 사이즈, 토핑을 선택하고 <i class="stroke_2"><em>저렴한 가격</em></i>에 먹을 수는 없을까? 그렇게 고객의 입장에서 시작된 것이 반올림피자샵이었습니다.<br> 시간이 흘러 어느덧 전국 모든 지역에서 먹을 수 있는 프랜차이즈로 성장하였습니다.
                    </span>
                    <span>
                        고객 여러분의 사랑에 힘입어 반올림피자샵이 <i class="stroke_3"><em>새로운 도약</em></i>을 꿈꾸게 되었습니다. 새로운 반올림피자샵은 고객만족을 위해 노력하는 창의적인 피자브랜드가 되고자 합니다.
                    </span>
                    <span> 앞으로 더 맛있고 창의적인 피자를 여러분의 집에서 드실 수 있도록 만들겠습니다. </span>
                </p>

                <h5>Concept</h5>
                <ul class="brandConcept animated CustomAnimate" data-animation="CustomAnimate">
                    <li>Satisfaction</li>
                    <li>Craftsmanship</li>
                    <li>Creative</li>
                </ul>
                <p class="conceptTxt">
                    피자 도우판의 형태로 연결되는 반올림 피자샵의 심볼은<br> <strong>고객만족을 위해 노력하는 창의적인 피자 브랜드</strong>로서의 이미지를 표현한다.
                </p>

                <ul class="logoConcept animated" data-animation="CustomAnimate">
                    <li class="logoImg">
                        <img src="${pageContext.request.contextPath}/images/contents/brand-stroy/img_BrandLogo.jpg" alt="반올림 피자 로고">
                    </li>
                    <li>항상 Upgrade된 피자를 연구하는 반올림피자샵의 노력</li>
                    <li>친근하고 따뜻한 느낌의 Yellow color와 신뢰감을 주는 Blue color</li>
                    <li>건강하고 정직한 신념을 바탕으로 상승하는 반올림피자샵의 이미지를 상징하는 로고타입</li>
                    <li>고객의 만족스러움을 표현하는 스마일</li>
                </ul>

                <h5>Color Spec</h5>
                <div class="colorSpecCont">
                    <dl>
                        <dt>Full color</dt>
                        <dd>
                            <i><img src="${pageContext.request.contextPath}/images/contents/brand-stroy/img_BrandLogo.jpg" alt="반올림 피자 로고"></i>
                            <p class="yellow">
                                <span>BANOLIM YELLOW</span>
                                <span>PANTONE 108C</span>
                                <span>C0 M10 Y100 K0</span>
                            </p>
                            <p class="blue">
                                <span>BANOLIM BLUE</span>
                                <span>PANTONE 2995C</span>
                                <span>C100 M0 Y0 K0</span>
                            </p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>One color</dt>
                        <dd>
                            <i><img src="${pageContext.request.contextPath}/images/contents/brand-stroy/img_BrandLogo_blue.jpg" alt="반올림 피자 로고"></i>
                            <p class="blue">
                                <span>BANOLIM BLUE</span>
                                <span>PANTONE 2995C</span>
                                <span>C100 M0 Y0 K0</span>
                            </p>
                        </dd>
                    </dl>
                </div>
            </div>
            <br>
        </div>
    </main>
       <%@ include file="../layouts/footer.jsp" %>
</body>

</html>