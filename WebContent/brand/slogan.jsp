<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/header.jsp" %>
 <main>
        <div class="container">
            <div class="sub-p-title">
                <h3 class="underLine"><span>브랜드스토리</span></h3>
            </div>
            <ul class="brand-stroy-list">
                <li><a href="${pageContext.request.contextPath}/brand">회사소개</a></li>
                <li class="selected"><a href="${pageContext.request.contextPath}/brand/slogan">슬로건</a></li>
            </ul>




            <!-- 브랜드스토리 -->
            <div class="brandCont sloganCont">
                <h5>Slogan</h5>
                <div class="brandSloganCont slogan animated CustomAnimate pulse" data-animation="CustomAnimate">
                    <h1>
                        반올림 하세요!<br> UPGRADE PREMIUM PIZZA
                    </h1>
                </div>
                <h5>Graphic Motif</h5>
                <div class="brandSloganCont motif animated bounce" data-animation="CustomAnimate">
                    <ul>
                        <li><img src="../images/contents/brand-stroy/img_motif_1.jpg" alt="Hello"></li>
                        <li><img src="../images/contents/brand-stroy/img_motif_2.jpg" alt="It's delicius"></li>
                        <li><img src="../images/contents/brand-stroy/img_motif_3.jpg" alt="피자조각 이미지"></li>
                        <li><img src="../images/contents/brand-stroy/img_motif_4.jpg" alt="핸드폰 이미지"></li>
                        <li><img src="../images/contents/brand-stroy/img_motif_5.jpg" alt="피자 이미지"></li>
                    </ul>
                </div>
            </div>
        </div>
        <br>
    </main>
    <%@ include file="../layouts/footer.jsp" %>
</body>

</html>